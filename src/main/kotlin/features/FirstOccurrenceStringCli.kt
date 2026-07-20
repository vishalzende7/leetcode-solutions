package org.example.features

import com.vishalzende.navigation.NavComponent
import org.example.domain.FirstOccurrenceString
import org.example.inject
import kotlin.math.PI

class FirstOccurrenceStringCli : NavComponent() {
    private val firstOccurrenceString: FirstOccurrenceString by inject()
    override fun render() {
        println("Leetcode #28, Find the index of first occurrence in string")
        println("Do you want to use pre-defined inputs")
        println("(y)es / (n)o")
        val ch = readln()
        if (ch.equals("y", true)) {
            //run with predefined test
            val inputs = listOf(
                "sadbutsad" to "sad",
                "leetcode" to "leeto",
                "hello" to "ll",
                "a" to "a"
            )

            for (i in inputs) {
                println("${i.second} in ${i.first} @ ${firstOccurrenceString(i.first, i.second)}")
            }
        } else {
            val i = getUserInput()
            println("${i.second} in ${i.first} @ ${firstOccurrenceString(i.first, i.second)}")
        }
    }

    private fun getUserInput(): Pair<String, String> {
        println("\nEnter Haystack string")
        val haystack = readln()
        println()
        println("Enter needle to find in string")
        val needle = readln()

        return (haystack to needle)
    }
}