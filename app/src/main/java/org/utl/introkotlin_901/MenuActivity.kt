package org.utl.introkotlin_901

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.utl.introkotlin_901.cinepolis.Cinepolis
import org.utl.introkotlin_901.ejemplo1.Operaciones
import org.utl.introkotlin_901.ejemplo2.Saludo
import org.utl.introkotliny_901.temasKotlin.saludo

class MenuActivity : AppCompatActivity() {
    private lateinit var edNombre: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)

        edNombre = findViewById(R.id.ed_nombre)
        val btnSaludo = findViewById<Button>(R.id.btn_saludar)
        val btnOperaciones = findViewById<Button>(R.id.btn_operaciones)
        val btnCinepolis = findViewById<Button>(R.id.btn_cinepolis)

        btnSaludo.setOnClickListener { saludarNavegante() }
        btnOperaciones.setOnClickListener { abrirPantallaOperaciones() }
        btnCinepolis.setOnClickListener { abrirPantallaCinepolis() }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun abrirPantallaOperaciones(){
        val intent = Intent(this, Operaciones::class.java)
        startActivity(intent)
    }
    private fun abrirPantallaCinepolis(){
        val intent = Intent(this, Cinepolis::class.java)
        startActivity(intent)
    }
    private fun saludarNavegante() {
        var name = edNombre.text.toString()
        if (name.isNotEmpty()) {
            val intent = Intent(this, Saludo::class.java)
            intent.putExtra("extra_name", name)
            startActivity(intent)
        } else{
            Toast.makeText(this, "Ingrese su nombre primero", Toast.LENGTH_SHORT).show()
        }
    }
}