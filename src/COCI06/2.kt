package COCI06

import kotlin.math.*

fun main() {
    val R = readLine()?.toIntOrNull()?: throw Throwable("invalid value")

    val euclidean = R * R * PI
    val taxicab = R * sqrt(2.0) * R * sqrt(2.0)

    println(String.format("%.6f", euclidean))
    println(String.format("%.6f", taxicab))
}