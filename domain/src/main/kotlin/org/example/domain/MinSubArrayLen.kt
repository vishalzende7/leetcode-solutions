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


/*
Example 1:

Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.
Solution:
[7,3,1,2,4,3]
 i
 j



Example 2:

Input: target = 4, nums = [1,4,4]
Output: 1


Example 3:

Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0
*/
