package org.utl.introkotliny_901.temasKotlin

fun main(){
    /*
    List, MutableList
    Set, MutableSet
    Map, MutableMap
   */

    var readOnly:List<String> = listOf("Lunes", "Martes", "Miercoles")
    println(readOnly)
    println("El primer día es ${readOnly[0]}")
    println("El primer día es ${readOnly.first()}")
    println("El número de días es ${readOnly.count()}") // Es igual a readOnly.size
    println("El día Martes está en la posición ${readOnly.indexOf("Martes")}")
    println("Existe el día Lunes? R=${"Martes" in readOnly}")

    var figuras:MutableList<String> = mutableListOf("Triangulo", "Circulo", "Cuadrado")
    println(figuras)
    figuras.add("Pentágono")
    println(figuras)
    figuras.removeAt(0) // Eliminar por posición
    println(figuras)
    figuras.remove("Círculo") // Eliminar por valor
    println(figuras)

    // --------------------------------------------------------
    val readOnlyFrutas = mapOf("manzana" to 1500, "platano" to 2000, "sandia" to 2500)
    println(readOnlyFrutas)
    println(readOnlyFrutas["manzana"])
    println(readOnlyFrutas.keys)
    println(readOnlyFrutas.values)
}