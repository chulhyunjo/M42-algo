// https://dmoj.ca/problem/coci06c2p2
/**
 *  A < B이고 B < C이다.
 *  입력 받은 3개의 숫자를 비교해 정해진 순서대로 출력하라
 * */

fun main() {
    val regex1 = Regex("^-?\\d+ -?\\d+ -?\\d+$")
    val regex2 = Regex(("^(?=.*A)(?=.*B)(?=.*C).*$"))

    val input = readlnOrNull() ?: throw Throwable("invalid Input")
    val order = readlnOrNull() ?: throw Throwable("invalid Input")
    if(!input.matches(regex1) || !order.matches(regex2)) throw Throwable("invalid Input")


    val numbers = input.split(" ").map{it.toInt()}.sorted()
    println("${numbers[order[0].code - 65]} ${numbers[order[1].code - 65]} ${numbers[order[2].code - 65]}")
}