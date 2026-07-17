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
            maxLen = max(maxLen, (j-i)+1)
            j++
        }
        return maxLen
    }
}


/*
*
* Input: s = "bbbbb"
* Output: 1
* Explanation: The answer is "b", with the length of 1.
* charSet = {b,}
* bbbbb
*  i
*   j
*
*
* Input: s = "abcbbabc"
* Output: 3
* Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.
*
* charSet = {a,b,c}
* abcbababc
*       i=j-1
*          j=5
*
* Input: s = "dvdf"
* Output: 3
* Explanation: The answer is "vdf", with the length of 1.
*
* charSet = {v,}
* dvdf
*  i
*    j
*
* */