package org.example.domain

import org.koin.core.annotation.Singleton

@Singleton
class FirstOccurrenceString {
    operator fun invoke(haystack: String, needle: String): Int {

        for(i in 0 .. haystack.length - needle.length) {
            if(haystack.substring(i, i+needle.length) == needle){
                return i
            }
        }
        return -1
    }
}

//fun main() {
//    print(FirstOccurrenceString()("a", "a"))
//}