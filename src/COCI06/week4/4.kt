package COCI06.week4

/** https://dmoj.ca/problem/coci06c4p4
 * 1 ~ N까지의 숫자로 이루어진 조건에 맞는 수열의 개수를 구하라,
 * 조건 - (a, b) a > b로 이루어진 개수가 C개인 수열
 * 입력 1) N=10, C=1
 *      1 2 3 4 5 6 7 8 10 9
 *      2 1 3 4 5 6 7 8 9 10
 *      2 3 1 4 5 6 7 8 9 10
 *      2 3 4 1 5 6 7 8 9 10
 *      2 3 4 5 1 6 7 8 9 10
 *      2 3 4 5 6 1 7 8 9 10
 *      2 3 4 5 6 7 1 8 9 10
 *      2 3 4 5 6 7 8 1 9 10
 *      2 3 4 5 6 7 8 9 10 1
 *
 *  입력 2) N=4 C=3
 *      1 4 3 2
 *      2 4 1 3
 *      2 3 1 4
 *      3 2 1 4
 *      3 1 4 2
 *      4 1 2 3
 *
 *
 *  N=1일 경우
 *  1
 *  0개 -> default
 *
 *  C=0 -> 1개
 *  C=1 -> 0개
 *
 *  N=2일 경우
 *  1 2     2 1
 *  0개      1개  -> default(앞자리 숫자 1, 2 기준으로 봤을때)
 *
 *  C=0 -> 1개 (N=1,C=0)
 *  C=1 -> 1개 (N=1,C=1) + (N=1,C=0)
 *  C=2 -> 0개 (N=1,C=1)
 *
 *  N=3일 경우
 *  1 2 3   2 1 3   3 1 2
 *  1 3 2   2 3 1   3 2 1
 *  0개      1개      2개 -> default(앞자리 숫자 1, 2, 3 기준으로 봤을때)
 *
 *  C=0 -> 1개(N=2,C=0)
 *  C=1 -> 2개(N=2,C=1) + (N=2,C=0)
 *  C=2 -> 2개(N=2,C=2) + (N=2,C=1) + (N=2,C=0)
 *  C=3 -> 1개            (N=2,C=2) + (N=2,C=1)
 *  C=4 -> 0개                        (N=2,C=2)
 *
 *  N=4일 경우
 *  1 2 3 4     2 1 3 4     3 1 2 4     4 1 2 3
 *  1 2 4 3     2 1 4 3     3 1 4 2     4 1 3 2
 *  1 3 2 4     2 3 1 4     3 2 1 4     4 2 1 3
 *  1 3 4 2     2 3 4 1     3 2 4 1     4 2 3 1
 *  1 4 2 3     2 4 1 3     3 4 1 2     4 3 1 2
 *  1 4 3 2     2 4 3 1     3 4 2 1     4 3 2 1
 *  0개          1개          2개          3개 -> default(앞자리 숫자 1, 2, 3,4 기준으로 봤을때)
 *
 *  C=0 -> 1개(N=3,C=0)
 *  C=1 -> 3개(N=3,C=1) + (N=3, C=0)
 *  C=2 -> 5개(N=3,C=2) + (N=3,C=1) + (N=3,C=0)
 *  C=3 -> 6개(N=3,C=3) + (N=3,C=2) + (N=3,C=1) + (N=3,C=0)
 *  C=4 -> 5개(N=4,C=4) + (N=3,C=3) + (N=3,C=2) + (N=3,C=1)
 *  C=5 -> 3개            (N=4,C=4) + (N=3,C=3) + (N=3,C=2)
 *  C=6 -> 1개                        (N=4,C=4) + (N=3,C=3)
 *  C=7 -> 0개                                    (N=4,C=4)
 * */

fun main(){
    val (n, c) = readlnOrNull()?.split(" ")?.map { it.toInt() } ?: throw Throwable("invalid input format")
    val array = Array(n){Array(c){0} }

    array[0][0] = 1
    for (i in 1..<n){
        for (j in 0..<c){
            array[i][j] =
        }
    }

}