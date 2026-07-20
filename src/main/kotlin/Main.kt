package org.example

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.runBlocking
import org.example.domain.ContainsNearbyDuplicateNew
import org.example.domain.AverageAgeByCities
import org.example.domain.`kotlin-collection`.DistinctFlatElements
import org.example.domain.`kotlin-collection`.GroupAnagrams
import org.example.domain.LengthOfLongestSubstring
import org.example.domain.MinSubArrayLen
import org.example.domain.`kotlin-collection`.MostFrequentElement
import org.example.domain.`kotlin-collection`.PartitionAndTransform
import org.example.domain.`kotlin-collection`.MaxKSum
import org.koin.core.annotation.KoinApplication
import org.koin.plugin.module.dsl.startKoin
import kotlin.math.max
import kotlin.math.min


@KoinApplication
class Main {
    companion object {
        val minSubArrayLen = MinSubArrayLen()
        val lengthOfLongestSubstring = LengthOfLongestSubstring()
        val containsNearbyDuplicateNew = ContainsNearbyDuplicateNew()
        val mostFrequentElement = MostFrequentElement()
        val groupAnagrams = GroupAnagrams()
        val partitionAndTransform = PartitionAndTransform()
        val averageAgeByCities = AverageAgeByCities()
        val distinctFlatElements = DistinctFlatElements()
        val maxKSum = MaxKSum()

        @JvmStatic
        fun main(args: Array<String>) {
            startKoin<App>()
            val mainApp = App()
            runBlocking(context = SupervisorJob() + Dispatchers.Default) {
                mainApp.run()
            }


//            println(maxArea(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)))
//            println(intToRoman(1994))
//            println(romanToInt("MXI"))
//            println(threeSum(intArrayOf(0, 0, 0)))
//            Tribonacci().run()
//            println(minSubArrayLen(15,intArrayOf(1,2,3,4,5)))
//            println(lengthOfLongestSubstring("dvdf"))
//            println(containsNearbyDuplicateNew(intArrayOf(1,2,3,1,2,3),0))
//            println(mostFrequentElement(intArrayOf(1, 3, 2, 1, 4, 1, 3, 2, 3, 3)))
//            println(groupAnagrams(arrayOf("eat", "tea", "tan", "ate", "nat", "bat")))
//            println(partitionAndTransform(intArrayOf(5, 2, 9, 1, 4, 6, 8, 3)))

//            val people = listOf(
//                Person("Alice", 25, "New York"),
//                Person("Bob", 30, "London"),
//                Person("Charlie", 35, "New York"),
//                Person("Diana", 28, "London")
//            )
//            averageAgeByCities(people)

//            val tags = listOf(
//                listOf("kotlin", "android"),
//                listOf("android", "compose", "ui"),
//                listOf("kotlin", "architecture")
//            )
//            distinctFlatElements(tags)

//            maxKSum(intArrayOf(1, 5, 2, 8, 3, 6, 4),3)
        }
    }
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
    var lastSymbol: Char? = null
    var total = 0;
    for (i in s) {
        total += romanMap[i] ?: throw IllegalArgumentException("Invalid roman symbol")
        when (lastSymbol) {
            'I', 'X', 'C' -> {
                if (romanMap[lastSymbol]!! >= romanMap[i]!!) {
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
    return total
}

fun threeSum(nums: IntArray): List<List<Int>> {
    val triplets = mutableSetOf<List<Int>>()
    nums.sort()
    for (i in nums.indices) {
        var j = i + 1
        var k = nums.size - 1
        while (j < k) {
            val sum = nums[i] + nums[j] + nums[k]
            if (sum == 0) {
                triplets.add(listOf(nums[i], nums[j], nums[k]))
                j++
                k--
            } else if (sum < 0) {
                j++
            } else {
                k--
            }
        }
    }
    return triplets.toList()
}
