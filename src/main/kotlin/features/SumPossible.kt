package features

import NavComponent

class SumPossible : NavComponent("Sum Possible") {
    override fun run() {
        val sum = 15
        val numbers = intArrayOf(4, 6, 10)
        val result = sumPossible(sum, numbers, hashMapOf())
        println(result)
    }

    private fun sumPossible(sum: Int, numbers: IntArray, memo: HashMap<Int, Boolean>): Boolean {
        if (sum == 0) return true
        if (sum < 0) return false
        if (memo.containsKey(sum)) return memo[sum]!!
        for (i in numbers) {
            val sumAmt = sum - i
            val result = sumPossible(sumAmt, numbers, memo)
            if (result) {
                memo[sum] = true
                return true
            }
        }
        memo[sum] = false
        return false
    }
}