
fun main() {
    // n1: 첫 줄 개미 개수, n2: 두번 째 줄 개미 개수
    val (n1: Int, n2: Int) = readlnOrNull()?.split(" ")?.map { it.toInt() } ?: throw Throwable("Invalid Input")

    val line1:CharArray // 첫 줄
    val line2:CharArray // 둘째 줄
    val regex = Regex("%[A-Z]+$") // 대문자 알파벳으로만 이루어짐
    val input1 = readlnOrNull() ?: throw Throwable("Invalid Input")
    if(regex.matches(input1)) line1 = input1.toCharArray()
    else throw Throwable("대문자만 입력하세요")

    val input2 = readlnOrNull() ?: throw Throwable("Invalid Input")
    if(regex.matches(input2)) line2 = input2.toCharArray()
    else throw Throwable("대문자만 입력하세요")

    val t = readlnOrNull()?.toIntOrNull() ?: throw Throwable("숫자를 입력하세요") // t만큼 이동
    if(0 > t || 50 < t)  throw Throwable("1~50을 입력하세요")

    // 첫 줄 개미 '1', 두번째 줄 개미 '2'
    // input:
    // ABC
    // DEF
    // answer = [1, 1, 1, 2, 2, 2]
    val answer = Array(n1 + n2) {'1'}
    for (i in 0..<n2){
        answer[i + n1] = '2'
    }

    // t번 만큼 마주치고 있는 1, 2 교체
    repeat(t){
        val changeIndex = mutableListOf<Int>() // '1' <=> '2' 변경될 index를 담는다.
        for (i in 0..<n1+n2-1){
            if(answer[i] == '1' && answer[i+1] == '2') changeIndex.add(i)
        }

        for (i in changeIndex){
            val tmp = answer[i]
            answer[i] = answer[i+1]
            answer[i+1] = tmp
        }
    }

    var line1Index = n1 - 1 // 첫 줄 개미는 오른쪽이 앞
    var line2Index = 0 // 두번째 줄 개미는 왼족이 앞
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