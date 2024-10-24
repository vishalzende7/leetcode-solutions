package org.example

import kotlin.math.max
import kotlin.math.min
import kotlin.math.pow

fun main() {
//    println(maxArea(intArrayOf(1,8,6,2,5,4,8,3,7)))
    println(intToRoman(1994))
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


fun intToRoman(num: Int): String {
    val romanMap = mutableMapOf<Int, String>(
        1000 to "M",
        900 to "CM",
        500 to "D",
        400 to "CD",
        100 to "C",
        90 to "XC",
        50 to "L",
        40 to "XL",
        10 to "X",
        9 to "IX",
        5 to "V",
        4 to "IV",
        1 to "I",
    )
    val sb = StringBuilder()
    var n = num
    for ((v, s) in romanMap) {
        val repeat = n / v
        if(repeat >0){
            sb.append(s.repeat(repeat))
            n %= v
        }
    }
    return sb.toString()
}

