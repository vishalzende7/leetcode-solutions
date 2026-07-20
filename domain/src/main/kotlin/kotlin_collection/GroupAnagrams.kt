package org.example.domain.kotlin_collection

class GroupAnagrams {
    operator fun invoke(a: Array<String>): List<List<String>> {
        return a.groupBy { it.toCharArray().sorted().joinToString("") }.values.toList()
    }
}