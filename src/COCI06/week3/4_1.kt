package COCI06.week3

/**
 * https://dmoj.ca/problem/coci06c3p4
 *
 *
 * -문제 설명-
 *  두명의 친구는
 *  N * N 의 battlefield에서 게임을 한다
 *
 *  1턴에 탱크는 인접한 칸으로 상, 하, 좌, 우 한칸을 움직일 수 있다.(탱크 2대는 같은 칸에 있을 수 없다)
 *  탱크는 같은 열, 행을 공격할 수 있다.
 *
 *  중간에 엄마가 소리질러 점심먹으라고 했다
 *  탱크들이 서로 공격 하지 못하게 재배치하고 내려가자고 했다, (같은 열, 행에 탱크는 1대만)
 *  이때, 최소한의 움직임으로 배치하고자 한다.
 *
 *  점심먹기 전 재배치 하기 위한 최소의 움직임이 몇번인지 계산, 어떻게 움직여야하는지 구하는 프로그램을 구현하라
 *
 *  - Input -
 *  N = 사각형의 한변 길이 (3<= N <= 500)
 *  N 개 만큼 R, C 입력(각 탱크의 위치)
 *  R, C 오름 차순으로 입력 된다.
 *
 *  - Output -
 *  K : 최소의 움직임을 출력
 *  K개의 움직임 한 줄씩 출력 (탱크의 숫자, 움직임)
 *
 *  - 문제 접근 법 -
 *  위 아래 움직이기 =
 *      가장 위에 있는 탱크부터 위로 움직인다.
 *
 *      가장 아래에 있는 탱크부터 아래로 움직인다.
 *  좌 우 움직이기 =
 *      가장 왼쪽에 있는 탱크부터 왼쪽으로 움직인다.
 *
 *      가장 오른쪽에 있는 탱크부터 오른쪽으로 움직인다.
 *
 *      Input 2
 *      * * * * *           * * 1 * *           * 1 * * *           * * 1 * *
 *      * * 1 * *           * 2 * * *           2 * * * *           * 2 * * *
 *      * 2 3 4 *       ->  * * 3 * *       ->  * * 3 * *       ->  * * * 3 *
 *      * * 5 * *           * * * 4 *           * * * * 4           * * * * 4
 *      * * * * *           * * 5 * *           * * * 5 *           5 * * * *
 *
 *  *      * * * * *           * * * * *           * 1 * * *
 *  *      * * 1 * *           * 1 * * *           2 * * * *
 *  *      * 2 3 4 *       ->  2 * 3 * 4       ->  * * 3 * *
 *  *      * * 5 * *           * * * 5 *           * * * * 4
 *  *      * * * * *           * * * * *           * * * 5 *
 *
 *      Input 3
 *      1 2 * * * *         1 * * * * *           1 * * * * *           1 * * * * *
 *      3 * * * * *         * 2 * * * *           * * 2 * * *           * 2 * * * *
 *      * * * * * *         3 * * * * *           * 3 * * * *           * * 3 * * *
 *      * * * * * *     ->  * * * * * 4       ->  * * * * 4 *       ->  * * * * * 4
 *      * * * * * 4         * * * * 5 *           * * * 5 * *           * * * * 5 *
 *      * * * * 5 6         * * * * * 6           * * * * * 6           * * * 6 * *
 * */

fun findMove(N:Int, tanks:List<Pair<Int, Pair<Int, Int>>>, isRow:Boolean): MutableList<Pair<Int, Char>>{
    val movingUpLeft = mutableListOf<Int>() // (위 or 왼쪽)으로 움직일 탱크들을 모은 리스트
    val movingDownRight = mutableListOf<Int>() // (아래 or 오른쪽)으로 움직일 탱크들을 모은 리스트

    // 맨(위, 왼) 방향에 있는 탱크부터 움직일 방향 확인
    for (i in 1..N){
        // i번째 탱크의 현재 (x,y)좌표가 i보다 크면 (아래, 오)에 위치
        // i번째 자리로 가기 위해 (위, 왼) 방향으로 이동해야함
        if(tanks[i-1].second.first > i) // i 보다 좌표가 크면 (아래, 오른쪽)에 위치해 있는 것
            movingUpLeft.add(i)

        // i번째 탱크의 현재 (x,y)좌표가 i보다 작으면 (위, 왼)에 위치
        // i-1번째 탱크는 i번째 자리로 가기 위해 (아래, 오) 반향으로 이동해야함
        else if(tanks[i-1].second.first < i)  // i보다 좌표가 작으면 (위, 왼쪽)에 위치해 있는 것
            movingDownRight.add(i)

        else continue // i번째 칸에 위치해 있다면 이동하지 않아도 된다.
    }

    // 출력값 저장
    val result: MutableList<Pair<Int, Char>> = mutableListOf()
    movingUpLeft.forEach{i ->
        // i는 1부터 시작
        // i번째 탱크의 현재 위치 - i 만큼 이동
        repeat(tanks[i - 1].second.first - i){
            result.add(i to (if(isRow) 'U' else 'L'))
        }
    }

    movingDownRight.reversed().forEach{i ->
        // i는 맨 아래(N)부터 시작
        // i - i번째 탱크의 현재 위치만큼 이동
        repeat(i - tanks[i - 1].second.first){
            result.add(i to (if(isRow) 'D' else 'R'))
        }
    }
    return result
}

fun main(){
    /*입력*/
    val N = readlnOrNull()?.toInt() ?: throw Throwable("숫자를 입력하세요") // 탱크의 개수, 보드판의 크기
    if(1 > N || 500 < N) throw Throwable("1 ~ 500 사이의 숫자를 입력하세요") // 1<=N<=500

    val tanks : MutableList<Pair<Int, Pair<Int, Int>>> = mutableListOf() // Pair(탱크 번호, Pair(x좌표, y좌표))
    repeat(N){idx ->
        val positionInput = readlnOrNull()?.split(" ")?.map{it.toInt()} ?: throw Throwable("Invalid Input")
        if(positionInput.size != 2) throw Throwable("Invalid Input")
        tanks.add(idx + 1 to (positionInput[0] to positionInput[1]))
    }

    /*구현*/
    // 위에서부터 순서대로 위에서부터 i번째 칸으로 상,하로 움직인다.
    val upDownResult = findMove(N, tanks, true)

    // y축을 기준으로 정렬 -> 좌 우 움직일거 찾기 위함
    val tanksColOrder = tanks.sortedBy { it.second.second }.map{ it.first to (it.second.second to it.second.first)} // (탱크번호, (y좌표, x좌표))로 변환, 같은 함수 쓰기 위함
    // 왼쪽에서부터 순서대로 왼쪽에서 i번째 칸으로 좌,우로 움직인다.
    val leftRightResult = findMove(N, tanksColOrder, false)

    val answer = upDownResult + leftRightResult
    println(answer.size)
    answer.forEach{
        println("${it.first} ${it.second}")
    }
}
