package org.example

import kotlin.math.max
import kotlin.math.min

fun main() {
    println(maxArea(intArrayOf(1,8,6,2,5,4,8,3,7)))
}

fun maxArea(height: IntArray): Int {
    var left = 0
    var right = height.size - 1
    var maxArea = 0

    while (left < right) {
        val smallestBar = min(height[left], height[right])
        val distance = right - left
        maxArea = max(smallestBar * distance, maxArea)
        if (height[left] < height[right]) left++
         else if (height[right] <= height[left]) right--
        else {
            left++
            right--
        }
    }
    return maxArea
}