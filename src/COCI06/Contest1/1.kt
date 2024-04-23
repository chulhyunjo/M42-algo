/** https://dmoj.ca/problem/coci06c1p1 */

package COCI06.Contest1

fun main(){
    println((1..10).fold(mutableSetOf<Int>()){acc, _ ->
        acc.add(readLine()?.toIntOrNull()?.let{
            if(it < 0 || it > 1000) throw Throwable("invalid range")
            it % 42
        }?: throw Throwable("invalid range"))

        acc
    }.size)
}