package org.utl.introkotliny_901.temasKotlin

fun main(){
    println("Hola Mundooo")

    val nombre = "Carlos" //val es inmutable
    var apellido = "Hernandez" //var es mutable

    println("Bienvenido " + nombre + " "+ apellido)
    println("Hola $nombre $apellido")
    var num1 = 10
    println("La suma de $num1 + 5 es igual a ${num1 + 5}")

    num1 = num1 + 5 // num
    num1 += 3
    num1++
     val sueldo:Float = 12.5f
     val nomina:Double = 12.5
    val edad:Byte = 25
    val estadoCivil:Char = 'K'

}
