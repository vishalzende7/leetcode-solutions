package org.example.domain

import kotlin.math.min

class MinSubArrayLen {
    operator fun invoke(target: Int, nums: IntArray): Int {
        var op: Int = 0
        var i = 0
        var j = 0
        var sum = 0

        while (j < nums.size) {
            sum += nums[j]
            while (sum >= target) {
                op = if (op == 0) (j - i) + 1 else min(op, (j - i) + 1)
                sum -= nums[i]
                i++
            }
            j++
        }
        return op
    }
}