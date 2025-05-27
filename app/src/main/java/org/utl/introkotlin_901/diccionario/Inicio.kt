package org.utl.introkotlin_901.diccionario

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.utl.introkotlin_901.R
import java.io.FileNotFoundException
import java.io.IOException

class Inicio : AppCompatActivity() {
    private val fileName = "datos.txt"
    private lateinit var btnPantallaNuevaPalabra: Button
    private lateinit var btnPantallaBuscarPalabra: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_inicio)

        btnPantallaNuevaPalabra = findViewById(R.id.btn_pantalla_nueva_palabra)
        btnPantallaBuscarPalabra = findViewById(R.id.btn_pantalla_buscar_palabra)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnPantallaNuevaPalabra.setOnClickListener {
            val intent = Intent(this, NuevaPalabra::class.java)
            startActivity(intent)
        }
        btnPantallaBuscarPalabra.setOnClickListener {
            val intent = Intent(this, BuscarPalabra::class.java)
            startActivity(intent)
        }
    }

     fun buscarPalabra(idioma: Boolean, palabra: String, context: Context): String {
         println("palabra: "+palabra)
        try {
            context.openFileInput(fileName).bufferedReader().useLines { lines ->
                for(line in lines){
                    val palabraYTraduccion: List<String> = line.split("|")
                    println("Todo: "+palabraYTraduccion.toString())
                    println("Pirmera: "+palabraYTraduccion[0])
                    println("Segunda: "+palabraYTraduccion[1])

                    if(idioma){
                        if(palabraYTraduccion[0] == palabra){
                            println("Palabra encontrada: "+palabraYTraduccion[1])
                            return palabraYTraduccion[1]
                        }
                    }else{
                        if(palabraYTraduccion[1] == palabra){
                            println("Palabra encontrada: "+palabraYTraduccion[0])
                            return palabraYTraduccion[0]
                        }
                    }
                }
                println("Palabra no encontrada")
                return "Palabra no encontrada"
            }
        } catch (e: FileNotFoundException) {
            println("Archivo no encontrado")
            return "Archivo no encontrado"
        } catch (e: IOException) {
            e.printStackTrace()
            println("Error al leer el archivo")
            return "Error al leer el archivo"
        }
        return ""
    }

}