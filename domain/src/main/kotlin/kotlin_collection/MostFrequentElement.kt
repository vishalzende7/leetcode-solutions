package org.example.domain.kotlin_collection

class MostFrequentElement {
    operator fun invoke(nums: IntArray): Int {
        return nums.groupBy{ it }.maxBy { it.value.size }.key
    }
}