package org.example.domain

import org.koin.core.annotation.Singleton

@Singleton
class ValidPalindrome {
    operator fun invoke(s: String): Boolean {
        var i = 0
        var j = s.length - 1
        while (i < j) {
            if (!s[i].isLetterOrDigit()) {
                i++
            } else if (!s[j].isLetterOrDigit()) {
                j--
            } else {
                if (!s[i].equals(s[j], ignoreCase = true)) {
                    return false
                }
                i++
                j--
            }
        }
        return true
    }
}

//fun main() {
//    println(ValidPalindrome()("a.,a"))
//}