package org.utl.introkotliny_901.temasKotlin

fun saludo(){
    return println("Hola Mundo")
}

fun sum(x: Int, y: Int): Int{
    return x + y
}


fun main(){
    saludo()
    println("------------------------------------------------------------------------------------" +
            "")
    println(sum(2,3))
    println(sum2(2,3))
}

fun sum2(x: Int, y: Int) = x + y // Función de línea