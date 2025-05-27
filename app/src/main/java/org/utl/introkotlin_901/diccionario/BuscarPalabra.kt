package org.utl.introkotlin_901.diccionario

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import org.utl.introkotlin_901.R
import java.io.FileNotFoundException
import java.io.IOException

class BuscarPalabra : AppCompatActivity() {
    private val fileName = "datos.txt"
    private lateinit var btnVolver: Button
    private lateinit var btnBuscarPalabra: Button
    private lateinit var espaniol: RadioButton
    private lateinit var ingles: RadioButton
    private lateinit var edPalabra: EditText
    private lateinit var txtPalabraEncontrada: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_buscar_palabra)

        btnVolver = findViewById(R.id.btn_volver)
        btnBuscarPalabra = findViewById(R.id.btn_buscar_palabra)
        espaniol = findViewById(R.id.radio_espaniol)
        ingles = findViewById(R.id.radio_ingles)
        edPalabra = findViewById(R.id.ed_palabra_ingles)
        txtPalabraEncontrada = findViewById(R.id.txt_palabra_encontrada)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        espaniol.isChecked = true

        btnBuscarPalabra.setOnClickListener {
            buscarPalabra()
        }
        btnVolver.setOnClickListener {
            val intent = Intent(this, Inicio::class.java)
            startActivity(intent)
        }
    }

    private fun buscarPalabra() {
        val palabra = edPalabra.text.toString().trim().lowercase()
        val idioma =  (espaniol.isChecked)

        if(palabra.isEmpty()){
            Snackbar.make(findViewById(R.id.main), "Ingrese una palabra", Snackbar.LENGTH_SHORT).show()
            return
        }

        txtPalabraEncontrada.text = Inicio().buscarPalabra(idioma, palabra, getApplicationContext())
        cerrarTeclado(btnBuscarPalabra)
    }

    fun cerrarTeclado(view: View) {
        var imm = getSystemService(InputMethodManager::class.java)
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}