// https://dmoj.ca/problem/coci06c2p1
/**
 * S = (R1 + R2)/2 이므로 R2 = 2 * S - R1이다
 * */

fun main() {
    val input = readlnOrNull()?.split(" ")?.map{it.toInt()} ?: throw Throwable("invalid Input")
    if(input.size != 2) throw Throwable("invalid Input")
    val (r1:Int, s:Int) = input

    println(s * 2 - r1)
}