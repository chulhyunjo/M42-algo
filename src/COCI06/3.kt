/** https://dmoj.ca/problem/coci06c1p3 */

fun main() {
    val word = readLine()?: throw Throwable("invalid input")
    val l = word.length
    val arr = Array(3) {Array(l * 5 - (l-1)) {'.'} }

    for (i in (1..l)){
        val pattern = if(i%3 == 0) '*' else '#'
        val start = (i-1) * 4 + 2 // 맨위에 줄 시작 인덱스
        arr[0][start] = pattern
        for (j in (1..2)){
            if(arr[j][start-j] != '*') arr[j][start-j] = pattern
            if(arr[j][start+j] != '*') arr[j][start+j] = pattern
        }
        arr[2][start] = word[i-1]
    }

    println(arr.joinToString("\n") {it.joinToString("")})
    println(arr.reversed().slice(1..2).joinToString("\n"){it.joinToString("")})
}