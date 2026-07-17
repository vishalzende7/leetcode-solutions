package org.example.domain.kotlin

class MaxKSum {
    operator fun invoke(nums: IntArray, k:Int) {
//        println(
//            nums.asList().windowed(3, step = 1)
//                .maxOfOrNull { w-> w.sum() }
//        )
        if(nums.size < k) {
            println(0)
            return
        }
        var currentSum = nums.take(k).sum()
        var maxSum = currentSum

        for(i in k until nums.size) {
            currentSum = currentSum + nums[i] - nums[i - k]
            if(currentSum > maxSum) {
                maxSum = currentSum
            }
        }

        println(maxSum)
    }
}