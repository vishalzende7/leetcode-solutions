package org.example.navigation

import com.vishalzende.navigation.NavComponent
import com.vishalzende.navigation.NavController

class NavMenu : NavComponent() {
    override fun render() {
        println("Leetcode Solutions")
        println("1. Index of first occurrence in string")
        println("2. PartitionAndTransformNav")
        println("3. ValidPalindromeNav")
    }

    override fun handleInput(input: String, navController: NavController): Boolean {
        return when (input) {
            "1" -> {
                navController.navigate("FirstOccurrenceStringCli")
                true
            }

            "2" -> {
                navController.navigate("PartitionAndTransformNav")
                true
            }

            "3" -> {
                navController.navigate("ValidPalindromeNav")
                true
            }

            else -> false
        }
    }
}