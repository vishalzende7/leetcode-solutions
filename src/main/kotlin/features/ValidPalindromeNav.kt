package org.example.features

import com.vishalzende.navigation.NavComponent
import org.example.domain.FirstOccurrenceString
import org.example.domain.ValidPalindrome
import org.example.inject
import kotlin.getValue

class ValidPalindromeNav : NavComponent() {

    private val validPalindrome: ValidPalindrome by inject()
    override fun render() {
        println("Leetcode #125, Valid Palindrome")
        println("Do you want to use pre-defined inputs")
        println("(y)es / (n)o")
        val ch = readln()
        if (ch.equals("y", true)) {
            //run with predefined test
            val inputs = listOf(
                "A man, a plan, a canal: Panama",
                "race a car",
                " ",
                ".,"
            )

            for (i in inputs) {
                println("'$i' is Palindrome: ${validPalindrome(i)}")
            }
        } else {
            val i = getUserInput()
            println("'$i' is Palindrome: ${validPalindrome(i)}")
        }
    }

    private fun getUserInput(): String {
        println("\nEnter string")
        val input = readln()
        return input
    }
}