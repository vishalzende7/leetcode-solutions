package features

import NavComponent
import kotlin.system.measureTimeMillis

class Tribonacci : NavComponent("Tribonacci Using Recursion") {
    override fun run() {
        val millis = measureTimeMillis {
            val result = trib(10)
            println("Tribonacci Number for 10 is $result")
        }

        println("Execution Time: $millis ms")
    }

    private fun trib(n: Int): Int {
        val memo = HashMap<Int, Int>();
        return trib(n, memo)
    }

    private fun trib(n: Int, memo: HashMap<Int, Int>): Int {
        if (n == 0 || n == 1 || n == 2) return n

        if (memo.containsKey(n)) return memo[n]!!
        val result = trib(n - 1, memo) + trib(n - 2, memo) + trib(n - 3, memo)
        memo[n] = result
        return result
    }

    private fun tribNoMemo(n:Int):Int {
        if (n == 0 || n == 1 || n == 2) return n

         return tribNoMemo(n-1) + tribNoMemo(n-2) + tribNoMemo(n-3)
    }
}