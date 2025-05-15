package org.utl.introkotliny_901.temasKotlin

fun main(){
    val d:Int
    val e=true
    if (e){
        d=1
    }else{
        d=0
    }
    println("Respuesta "+d)
    val numero = if(e) 1 else 2
    println("Respuesta "+numero)
    //--------------------------
    print("Ingrese el sueldo del empleado: ")
    val sueldo = readln().toDouble()
    if (sueldo>3000){
        println("Debe pagar impuestos")
    }else{
        println("No debe pagar impuestos")
    }

    //when
    val objeto:Any ="Hola"
    when(objeto){
        "1" -> println("Es un uno")
        "Hola" -> println("Es un saludo")
        is String -> println("Es un String")
        else -> println("No se que es")
    }

    //Range
    1..4// 1234

    4 downTo 1// 4321
    1 .. 10 step 2// 13579
    'z' downTo 'a' step 2 // z, y, x, w, v, u, t, s, r, q ...


}