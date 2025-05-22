package org.utl.introkotlin_901.ejemplo2

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.utl.introkotlin_901.R

class Saludo : AppCompatActivity() {
    private lateinit var txtSaludo: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_saludo)

        txtSaludo = findViewById<TextView>(R.id.txt_saludo)
        val name = intent.getStringExtra("extra_name")
        txtSaludo.text = "Bienvenido $name"

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}