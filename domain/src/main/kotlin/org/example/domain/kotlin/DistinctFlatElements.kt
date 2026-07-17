package org.example.domain.kotlin

class DistinctFlatElements {
    operator fun invoke(tags: List<List<String>>) {
        println(
            tags.flatMap { it }.distinct().sorted()
        )
    }
}