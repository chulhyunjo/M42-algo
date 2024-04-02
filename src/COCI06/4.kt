fun main() {
    fun moveWater(arr:MutableList<CharArray>, visited:Array<Array<Int>>,position: ArrayDeque<Pair<Int, Int>>, R: Int, C: Int, time: Int): ArrayDeque<Pair<Int,Int>> {
        val dx = listOf(0, 0, 1, -1) // 동 서 남 북
        val dy = listOf(1, -1, 0, 0) // 동 서 남 북
        val nextPosition = ArrayDeque<Pair<Int, Int>>()
        while (position.size > 0) {
            val (x, y) = position.removeFirst()
            for (i in 0..3) {
                val nx = x + dx[i]
                val ny = y + dy[i]
                if (nx in 0..<R && ny in 0..<C && arr[nx][ny] != 'X' && arr[nx][ny] != 'D' && visited[nx][ny] == 0) {
                    visited[nx][ny] = time
                    nextPosition.add(Pair(nx, ny))
                }
            }
        }
        return nextPosition
    }

    fun move(arr:MutableList<CharArray>, visited:Array<Array<Int>>,position: ArrayDeque<Pair<Int, Int>>, R: Int, C: Int, time: Int): ArrayDeque<Pair<Int,Int>>{
        val dx = listOf(0, 0, 1, -1) // 동 서 남 북
        val dy = listOf(1, -1, 0, 0) // 동 서 남 북
        val nextPosition = ArrayDeque<Pair<Int,Int>>()
        while (position.size > 0){
            val (x, y) = position.removeFirst()
            for (i in 0..3){
                val nx = x + dx[i]
                val ny = y + dy[i]
                if(nx in 0..<R && ny in 0..<C && visited[nx][ny] == 0){
                    if(arr[nx][ny] == 'D') {
                        visited[nx][ny] = time
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

    val (R, C) = readlnOrNull()?.split(" ")?.map{it.toInt()} ?: throw Throwable("invalid input")

    var dPosition = Pair(0, 0) // Beaver Den

    val arr :MutableList<CharArray> = mutableListOf()
    val visited = Array(R) {Array(C) { 0 }}

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
                visited[i][j] = 1
            }else if(arr[i][j] == 'S'){
                painterHedgehogs.add(Pair(i, j))
            }
        }
    }

    var time = 1
    while (painterHedgehogs.size>0){
        floodWater = moveWater(arr, visited, floodWater, R, C, time)
        painterHedgehogs = move(arr, visited, painterHedgehogs, R, C, time)
        time++
    }
    val answer = visited[dPosition.first][dPosition.second]
    println(if(answer == 0) "KAKTUS" else answer)
}