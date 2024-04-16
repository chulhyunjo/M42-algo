import java.lang.Integer.min
import kotlin.math.max

fun main() {
    val (n1: Int, n2: Int) = readlnOrNull()?.split(" ")?.map { it.toInt() } ?: throw Throwable("Invalid Input")

    val line1 = readlnOrNull()?.toCharArray() ?: throw Throwable("Invalid Input")
    val line2 = readlnOrNull()?.toCharArray() ?: throw Throwable("Invalid Input")
    val t = readlnOrNull()?.toInt() ?: throw Throwable("Invalid Input") // t만큼 이동

    val answer = Array(n1 + n2) {'1'}

    // line2 만큼 뒤에 '2'로 변경
    for (i in 0..<n2){
        answer[i + n1] = '2'
    }

    // t번 만큼 1, 2 교체
    repeat(t){
        val changeIndex = mutableListOf<Int>() // '1' <=> '2' 변경될 index담은 리스트
        for (i in 0..<n1+n2-1){
            if(answer[i] == '1' && answer[i+1] == '2') changeIndex.add(i)
        }

        for (i in changeIndex){
            val tmp = answer[i]
            answer[i] = answer[i+1]
            answer[i+1] = tmp
        }
    }

    var line1Index = n1 - 1
    var line2Index = 0
    for (i in 0..<n1+n2){
        if(answer[i] == '1'){
            answer[i] = line1[line1Index]
            line1Index--
        }
        else{
            answer[i] = line2[line2Index]
            line2Index++
        }
    }
    println(answer.joinToString(""))
}