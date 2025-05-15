package org.utl.introkotliny_901.temasKotlin

class Usuario(){
    val materia_String = ""
}

class Usuario2(val id:Int, var nombre:String){
    val materia_String = ""
    fun saludo(){
        println("Hola")

    }
}

fun main(){
    val alumno = Usuario()
    val alumno2 = Usuario2(1, "Carlos")

    println(alumno2.id)
    println(alumno2.nombre)
    alumno2.saludo()
}