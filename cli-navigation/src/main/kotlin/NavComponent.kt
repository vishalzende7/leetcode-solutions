package com.vishalzende.navigation

abstract class NavComponent {
    /**
     * 1. ONLY responsible for printing the UI.
     * Must NEVER contain blocking calls like readln().
     */
    abstract fun render()

    /**
     * 2. Responsible for handling the user's choice.
     * return false if not handling the inputs, false will trigger pop back stack
     */
    open fun handleInput(input: String, navController: NavController): Boolean {
        return false
    }
}