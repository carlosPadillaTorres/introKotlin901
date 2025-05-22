package org.utl.introkotlin_901.cinepolis

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.utl.introkotlin_901.R

class Cinepolis : AppCompatActivity() {
    private lateinit var nombre_comprador: EditText
    private lateinit var cantidad_compradores: EditText
    private lateinit var cantidad_boletos: EditText
    private lateinit var cineco_si: RadioButton
    private lateinit var cineco_no: RadioButton
    private lateinit var txt_resultado: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cinepolis)

        nombre_comprador = findViewById(R.id.ed_nombre_comprador)
        cantidad_compradores = findViewById(R.id.ed_cantidad_compradores)
        cantidad_boletos = findViewById(R.id.ed_cantidad_boletos)
        cineco_si = findViewById(R.id.radio_si)
        cineco_no = findViewById(R.id.radio_no)
        txt_resultado = findViewById(R.id.txt_resultado)

        cineco_si.isChecked = true

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun calcular(v: View) {
        val costo_boleto= 12.0
       // var nombre: String = nombre_comprador.text.toString()

        if (nombre_comprador.text.toString().isEmpty()) {
            Toast.makeText(this, "Ingrese su nombre", Toast.LENGTH_SHORT).show()
            return
        }
       var compradores = 0
        var boletos = 0
        var total = 0.0
        try {
             compradores = (cantidad_compradores.text.toString().toInt())
             boletos = (cantidad_boletos.text.toString().toInt())
        }catch (e: NumberFormatException){
            Toast.makeText(this, "Ingrese valores enteros", Toast.LENGTH_SHORT).show()
            return
        }
        if (compradores < 1) {
            Toast.makeText(this, "Ingrese una cantidad de compradores válida", Toast.LENGTH_SHORT).show()
            return
        }
        if (boletos > compradores*7) {
            Toast.makeText(this, "No puede comprar más de 7 boletos por persona", Toast.LENGTH_SHORT).show()
            return
        }else if(boletos < 1){
            Toast.makeText(this, "Ingrese una cantidad de boletos válida", Toast.LENGTH_SHORT).show()
            return
        }
        else if(boletos < compradores){
            Toast.makeText(this, "El número de boletos no puede ser menor al número de compradores", Toast.LENGTH_SHORT).show()
            return
        }
        total = costo_boleto * boletos

        if(boletos > 5){
            total = total * 0.85
        }else if(boletos >= 3){
            total = total * 0.90
        }

        if(cineco_si.isChecked){
            total = total * 0.90
        }
        txt_resultado.text = "$"+total.toString()

    }

}