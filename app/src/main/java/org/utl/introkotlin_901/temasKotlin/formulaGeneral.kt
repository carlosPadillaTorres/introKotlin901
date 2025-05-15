package org.utl.introkotliny_901.temasKotlin

fun main(){
    println("Bienvenido a la calculadora de X")
    println("Este programa calcula los valores de x mediante los valores dados A, B y C usando la fórmula general: ")
    val a = verificarEntrada("el valor de A")
    val b = verificarEntrada("el valor de B")
    val c = verificarEntrada("el valor de C")
    var x1 = Math.pow(b, 2.0) - 4 * a * c
    if(x1 < 0){
        println("No existen valores de x reales")
        return
    }
    x1 = (-b + Math.sqrt(x1)) / (2 * a)
    val x2 = (-b - Math.sqrt(Math.pow(b, 2.0) - 4 * a * c)) / (2 * a)
    println("Los valores de x son: $x1, $x2")

}
