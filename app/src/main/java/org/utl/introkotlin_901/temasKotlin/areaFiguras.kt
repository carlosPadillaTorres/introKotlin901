package org.utl.introkotliny_901.temasKotlin

import java.math.RoundingMode

fun main(){
    var opcionSel = 0
    println("\nBienvendio a la calculadora de área de figuras.")
            do{
       println("\nSeleccione una opción del 1 al 5 en base al siguiente menú:\n" +
               "1. Círculo\n" +
               "2. Cuadrado\n" +
               "3. Triángulo\n" +
               "4. Pentágono regular\n" +
               "5. Salir")
        opcionSel = verificarEntrada("la opción del menú").toInt()

        when(opcionSel){
            1 -> calcularAreaCirculo()
            2 -> calcularAreaCuadrado()
            3 -> calcularAreaTriangulo()
            4 -> calcularAreaPentagono()
            5 -> println("Gracias por usar la calculadora de áreas\nSaliendo...")
            else -> println("\n\nOpción no válida. Intente de nuevo")
        }
    }while(opcionSel != 5)
}


fun calcularAreaCirculo(){
    println("Cálculo del área de un Círculo")
    var radio = verificarEntrada(("el radio del círculo en cm²"))
    val area = (Math.PI * Math.pow(radio, 2.0)).toBigDecimal().setScale(1, RoundingMode.UP)
    println("El área del círculo es: $area cm²")
}

fun calcularAreaCuadrado(){
    println("Cálculo del área de un Cuadrado")
    val perimetro = verificarEntrada(("el perímetro del cuadrado en cm²"))
    val area = (Math.pow(perimetro, 2.0)).toBigDecimal().setScale(1, RoundingMode.UP)
    println("El área del cuadrado es: $area cm²")
}

fun calcularAreaTriangulo(){
    println("Cálculo del área de un Triángulo")
    var base = verificarEntrada(("la base del triángulo en cm²"))
    var altura = verificarEntrada("la altura del triángulo")

    val area = (base * altura / 2).toBigDecimal().setScale(1, RoundingMode.UP)
    println("El área del triángulo es: $area cm²")
}


fun calcularAreaPentagono(){
    println("Cálculo del área de un Pentágono")
    var lado = verificarEntrada("el lado del pentágono en cm²")
    var apotema = verificarEntrada("el apotema del pentágono")
    val area = (lado *5 *apotema / 2).toBigDecimal().setScale(1, RoundingMode.UP)
    println("El área del pentágono es: $area cm²")

}

fun verificarEntrada(elementoAPedir:String): Double {
    var calculado = true
    do {
        println("Ingrese $elementoAPedir: ")
        try {
            val valor = readln().toDouble()
            if (valor == 0.0) {
                println("$elementoAPedir ingresado no puede ser cero. Intente de nuevo.")
                calculado = false
            }else{
                return valor
            }
        } catch (e: NumberFormatException) {
            println("Entrada no válida. Intente de nuevo.")
            calculado = false
        }
    }while(calculado==false)
    return -1.0
}
