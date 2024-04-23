package COCI06.week2

import java.lang.Integer.min
import kotlin.math.max

fun main() {
    val (n1:Int, n2:Int) = readlnOrNull()?.split(" ")?.map{it.toInt()} ?: throw Throwable("Invalid Input")

    val line1 = readlnOrNull()?.toCharArray()?: throw Throwable("Invalid Input")
    val line2 = readlnOrNull()?.toCharArray()?: throw Throwable("Invalid Input")
    var t = readlnOrNull()?.toInt() ?: throw Throwable("Invalid Input") // t만큼 이동

    val leftStart = line1.lastIndex
    val rightStart = leftStart + 1

    val answer = Array(line1.size + line2.size) {'.'}
    val lastIndex = answer.lastIndex

    for (i in 0..leftStart){
        if (t-i > 0){
            answer[if(leftStart-i + (t-i) >= lastIndex - i) lastIndex-i else leftStart-i + (t-i)] = line1[i]
        } else{
            answer[leftStart - i] = line1[i]
        }
    }

    for (i in 0..line2.lastIndex){
        if (t-i > 0){
            answer[if((rightStart + i) - (t-i) <= i) i else (rightStart+i) - (t-i)] = line2[i]
        } else{
            answer[rightStart + i] = line2[i]
        }
    }

    println(answer.joinToString(""))
}