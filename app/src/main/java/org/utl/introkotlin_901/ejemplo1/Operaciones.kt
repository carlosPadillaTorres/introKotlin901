package org.utl.introkotlin_901.ejemplo1

import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.utl.introkotlin_901.R

class Operaciones : AppCompatActivity() {
    private lateinit var tv1: TextView
    private lateinit var num1: EditText
    private lateinit var num2: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_operaciones)

        tv1 = findViewById(R.id.txt_resultado   )
        num1 = findViewById(R.id.ed_numero_uno)
        num2 = findViewById(R.id.ed_numero_dos)

        findViewById<RadioButton>(R.id.radio_suma).isChecked = true

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    fun cerrarTeclado(view: View) {
            var imm = getSystemService(InputMethodManager::class.java)
            imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

    fun validarOperacion(v: View){

        cerrarTeclado(tv1)

        var numUno: Double = 0.0
        var numDos: Double = 0.0

        try {
            numUno = num1.text.toString().toDouble()
            numDos = num2.text.toString().toDouble()
        }catch (e: NumberFormatException){
            tv1.text = "Error: Ingrese números válidos"
            return
        }

        if(findViewById<RadioButton>(R.id.radio_suma).isChecked){
            sumar(numUno, numDos)
            return
        }
        if(findViewById<RadioButton>(R.id.radio_resta).isChecked){
            restar(numUno, numDos)
            return
        }
        if(findViewById<RadioButton>(R.id.radio_multiplicacion).isChecked){
            multiplicar(numUno, numDos)
            return
        }
        if(findViewById<RadioButton>(R.id.radio_division).isChecked){
            dividir(numUno, numDos)
            return
        }
    }

    fun sumar(num1: Double, num2: Double){

        val suma = num1 + num2
        tv1.text ="Resultado: "+ suma.toString()
    }

    fun restar(num1: Double, num2: Double){

        val suma = num1 - num2
        tv1.text ="Resultado: "+ suma.toString()
    }

    fun multiplicar(num1: Double, num2: Double){
        val suma = num1 * num2
        tv1.text ="Resultado: "+ suma.toString()
    }

    fun dividir(num1: Double, num2: Double){
        if(num2 == 0.0){
            tv1.text ="No se puede dividir entre cero"
            return
        }
        val suma = num1 / num2
        tv1.text ="Resultado: "+ suma.toString()
    }

}