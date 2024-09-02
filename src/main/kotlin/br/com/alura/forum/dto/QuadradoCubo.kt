package br.com.alura.forum.dto

import java.util.*
import kotlin.math.pow

class QuadradoCubo {

}

fun main() {
    val input = Scanner(System.`in`)
    val a = input.nextInt()

    println(quadradoCubo(a))


}
fun quadradoCubo(numero: Int): String {
    val result = StringBuilder()
    for (valor in 1..numero) {
        val quadrado: Int = (valor.toDouble().pow(2)).toInt()
        val cubo: Int = (valor.toDouble().pow(3)).toInt()
        result.append("$valor $quadrado $cubo\n")
    }
    return result.toString()
}