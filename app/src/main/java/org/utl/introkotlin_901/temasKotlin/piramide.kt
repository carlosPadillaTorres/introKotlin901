package org.utl.introkotliny_901.temasKotlin

import java.math.RoundingMode

fun main(){
    println("Bienvenido al constructor de pirámides")
    println("La unidad de medida que se utilizará son asteríscos")
    val tamanioPiramide = verificarTamanioPiramide("el tamaño de la pirámide")
    var i = 1
    var j = -2
    var espacioPiramide = (tamanioPiramide / 2)
    println("Espacio de la pirámide: $espacioPiramide")
    do{
        var a=tamanioPiramide-i
        do{
            print("  ")
            j++
        }while(j<espacioPiramide)
        do{
            print("*  ")
            a++
        }while(a<tamanioPiramide)
        print("\n")
        espacioPiramide--
        i++
        j=-1
    }while(i<=tamanioPiramide)
}


fun verificarTamanioPiramide(elementoAPedir:String): Int {
    var calculado = true
    do {
        println("Ingrese $elementoAPedir: ")
        try {
            val valor = readln().toInt()
            if (valor <= 1) {
                println("$elementoAPedir ingresado no puede ser menor a 2. Intente de nuevo.")
                calculado = false
            }else{
                return valor
            }
        } catch (e: NumberFormatException) {
            println("Entrada no válida. Intente de nuevo.")
            calculado = false
        }
    }while(calculado==false)
    return -1
}