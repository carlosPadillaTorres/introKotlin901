package org.utl.introkotlin_901.diccionario

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import org.utl.introkotlin_901.R
import java.io.IOException
import kotlin.text.clear
import kotlin.toString

class NuevaPalabra : AppCompatActivity() {
    private val fileName = "datos.txt"
    private lateinit var btnVolver: Button
    private lateinit var btnGuardarPalabra: Button
    private lateinit var edPalabraEspaniol: EditText
    private lateinit var edPalabraingles: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_nueva_palabra)

        btnVolver = findViewById(R.id.btn_volver)
        btnGuardarPalabra = findViewById(R.id.btn_guardar_palabra)
        edPalabraEspaniol = findViewById(R.id.ed_palabra_espaniol)
        edPalabraingles = findViewById(R.id.ed_palabra_ingles)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btnGuardarPalabra.setOnClickListener {
            guardarPalabra()
        }

        btnVolver.setOnClickListener {
            val intent = Intent(this, Inicio::class.java)
            startActivity(intent)
        }
    }
    fun guardarPalabra(){
        cerrarTeclado(btnGuardarPalabra)

        val textoEspaniol = edPalabraEspaniol.text.toString().lowercase().trim()
        val textoIngles = edPalabraingles.text.toString().lowercase().trim()

        if(textoEspaniol.isEmpty() || textoIngles.isEmpty()){
            Snackbar.make(findViewById(R.id.main), "Hay datos faltantes", Snackbar.LENGTH_LONG).show()
            return
        }
        if(textoEspaniol.contains("|") || textoIngles.contains("|") || textoEspaniol.contains(" ") || textoIngles.contains(" ")){
            Snackbar.make(findViewById(R.id.main), "El texto contiene caractéres no válidos", Snackbar.LENGTH_LONG).show()
            return
        }

        var verificador = Inicio().buscarPalabra(true, textoEspaniol, getApplicationContext())
        if(verificador != "Palabra no encontrada" &&  verificador != "Archivo no encontrado") {
            Snackbar.make(findViewById(R.id.main), "La palabra en español ya existe", Snackbar.LENGTH_LONG).show()
            return
        }
        verificador = Inicio().buscarPalabra(false, textoIngles, getApplicationContext())
        if( verificador!= "Palabra no encontrada" && verificador != "Archivo no encontrado"){
            Snackbar.make(findViewById(R.id.main), "La palabra en inglés ya existe", Snackbar.LENGTH_LONG).show()
            return
        }

        val texto = textoEspaniol+ "|" + textoIngles+"\n"
        try {
            openFileOutput(fileName, MODE_APPEND).use {
                it.write(texto.toByteArray())

                Snackbar.make(findViewById(R.id.main), "Palabras guardada", Snackbar.LENGTH_SHORT).show()
                edPalabraEspaniol.text.clear()
                edPalabraingles.text.clear()
            }

        } catch (e: IOException) {
            Snackbar.make(findViewById(R.id.main), "Error al guardar", Snackbar.LENGTH_SHORT).show()
            e.printStackTrace()
        }
    }

    fun cerrarTeclado(view: View) {
        var imm = getSystemService(InputMethodManager::class.java)
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}