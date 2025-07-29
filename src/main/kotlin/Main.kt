package org.example

import org.example.navigation.ui.Navigation
import kotlin.math.max
import kotlin.math.min
import kotlin.math.pow

fun main() {
    Navigation.getInstance()
    println("Welcome to DSA Problems")
    println("Select any one from choices: ")

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
        if (repeat > 0) {
            sb.append(s.repeat(repeat))
            n %= v
        }
    }
    return sb.toString()
}

fun romanToInt(s: String): Int {
    val romanMap = mapOf<Char, Int>(
        'I' to 1,
        'V' to 5,
        'X' to 10,
        'L' to 50,
        'C' to 100,
        'D' to 500,
        'M' to 1000,
    )
    var lastSymbol:Char? = null
    var total = 0;
    for(i in s){
        total += romanMap[i]?: throw IllegalArgumentException("Invalid roman symbol")
        when(lastSymbol){
            'I','X','C'-> {
                if(romanMap[lastSymbol]!! >= romanMap[i]!!) {
                    lastSymbol = i
                    continue
                }
                total -= romanMap[i]!!
                total -= romanMap[lastSymbol]!!
                total += (romanMap[i]!! - romanMap[lastSymbol]!!)
            }
            else -> lastSymbol = i
        }

    }
    return  total
}

fun threeSum(nums: IntArray): List<List<Int>> {
    val triplets = mutableSetOf<List<Int>>()
    nums.sort()
    for (i in nums.indices){
        var j = i+1
        var k = nums.size - 1
        while(j < k){
            val sum = nums[i] + nums[j] + nums[k]
            if(sum == 0){
                triplets.add(listOf(nums[i],nums[j],nums[k]))
                j++
                k--
            }else if(sum < 0){
               j++
            }
            else{
                k--
            }
        }
    }
    return triplets.toList()
}
