package org.example.domain

class ContainsNearbyDuplicateNew {
    operator fun invoke(nums: IntArray, k: Int): Boolean {
        val seen = hashSetOf<Int>()
        var i = 0
        var j = 0
        while(j < nums.size) {
            if((j-i) > k) {
                seen.remove(nums[i])
                i++
            }
            if(seen.contains(nums[j])) return true
            seen.add(nums[j])
            j++
        }
        return false
    }
}