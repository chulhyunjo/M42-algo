import kotlin.math.max

fun main() {
    // depth = 탐색 깊이, percent = 현재 탐색 깊이까지의 확률, answer = 퍼센트 최대값
    fun search(arr:Array<Array<Double>>, N:Int, used: Array<Int>, depth: Int, percent: Double, answer: Double): Double{
        // 현재 탐색 깊이의 확률이 최대값보다 낮으면 더 높아질 수 없다
        if(percent <= answer){
            return answer
        }

        if(depth == N){ // 마지막 줄에 도달 시
            return percent
        }

        var now = 0.0
        for (i in 0..<N){
            if(used[i] == 0){
                used[i] = 1
                now = search(arr, N, used,depth + 1, percent * arr[depth][i], max(answer, now))
                used[i] = 0
            }
        }

        return now
    }

    val N = readLine()?.toInt() ?: throw Throwable("invalid Input")
    val arr = Array(N) {Array(N) {0.0}}
    val used = Array(N){0} // 사용했으면 1, 아니면 0
    var answer = 0.0

    for(i in 0..<N){
        val line = readLine()?.split(" ")?.map{it.toDouble()/100} ?: throw Throwable("invalid Input") /** 퍼센트 */
        for (j in 0..<N){
            arr[i][j] = line[j]
        }
    }

    for(i in 0..<N){
        used[i] = 1
        answer = search(arr, N, used, 1, 100.0 * arr[0][i], answer)
        used[i] = 0
    }

    println(String.format("%.6f", answer))
}