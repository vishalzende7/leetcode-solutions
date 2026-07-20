package org.example.domain

import kotlin.math.max

class LengthOfLongestSubstring {

    operator fun invoke(s: String): Int {
        val charSet = hashSetOf<Char>()
        var maxLen = 0
        var j = 0
        var i = 0
        while (j < s.length) {
            if (charSet.contains(s[j])) {
                while (charSet.contains(s[j])) {
                    charSet.remove(s[i])
                    i++
                }
            }
            charSet.add(s[j])
            maxLen = max(maxLen, (j - i) + 1)
            j++
        }
        return maxLen
    }
}