/** https://dmoj.ca/problem/coci06c1p4 */

/** 너비 우선 탐색을 통해 물, 사람을 상하좌우 한칸씩 매번 이동시켜 탐색한다.
 *  한번 탐색한 공간은 다시 확인할 필요가 없다. 최소 시간을 확인하므로
 *
 * */

fun main() {
    fun moveWater(arr:MutableList<CharArray>,position: ArrayDeque<Pair<Int, Int>>, R: Int, C: Int): ArrayDeque<Pair<Int,Int>> {
        val dx = listOf(0, 0, 1, -1) // 동 서 남 북
        val dy = listOf(1, -1, 0, 0) // 동 서 남 북
        val nextPosition = ArrayDeque<Pair<Int, Int>>()
        while (position.size > 0) {
            val (x, y) = position.removeFirst()
            for (i in 0..3) {
                val nx = x + dx[i]
                val ny = y + dy[i]
                if (nx in 0..<R && ny in 0..<C && arr[nx][ny] != 'X' && arr[nx][ny] != 'D' && arr[nx][ny] != '*') {
                    arr[nx][ny] = '*'
                    nextPosition.add(Pair(nx, ny))
                }
            }
        }
        return nextPosition
    }

    fun move(arr:MutableList<CharArray>,position: ArrayDeque<Pair<Int, Int>>, R: Int, C: Int, time: Int): ArrayDeque<Pair<Int,Int>>{
        val dx = listOf(0, 0, 1, -1) // 동 서 남 북
        val dy = listOf(1, -1, 0, 0) // 동 서 남 북
        val nextPosition = ArrayDeque<Pair<Int,Int>>()
        while (position.size > 0){
            val (x, y) = position.removeFirst()
            for (i in 0..3){
                val nx = x + dx[i]
                val ny = y + dy[i]
                if(nx in 0..<R && ny in 0..<C){
                    if(arr[nx][ny] == 'D') {
                        arr[nx][ny] = time.toChar()
                        return ArrayDeque()
                    } else if(arr[nx][ny] == '.'){
                        arr[nx][ny] = 'S'
                        nextPosition.add(Pair(nx, ny))
                    }
                }
            }
        }
        return nextPosition
    }

    val (R: Int, C: Int) = readlnOrNull()?.split(" ")?.map{it.toInt()} ?: throw Throwable("invalid input")

    val arr :MutableList<CharArray> = mutableListOf() // 지도

    var dPosition = Pair(0, 0) // Beaver Den 도착점 좌표
    var floodWater = ArrayDeque<Pair<Int, Int>>()
    var painterHedgehogs = ArrayDeque<Pair<Int,Int>>()

    for (i in (0..<R)){
        val line = readlnOrNull()?.toCharArray() ?: throw Throwable("invalid input")
        arr.add(line)

        for (j in (0..<C)){
            if(arr[i][j] == 'D'){
                dPosition = Pair(i, j)
            }else if(arr[i][j] == '*'){
                floodWater.add(Pair(i, j))
            }else if(arr[i][j] == 'S'){
                painterHedgehogs.add(Pair(i, j))
            }
        }
    }

    var time = 1
    while (painterHedgehogs.size>0){
        floodWater = moveWater(arr, floodWater, R, C)
        painterHedgehogs = move(arr, painterHedgehogs, R, C, time)
        time++
    }
    val answer = arr[dPosition.first][dPosition.second]
    println(if(answer == 'D') "KAKTUS" else answer.code)
}