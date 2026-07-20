package com.vishalzende.navigation

/**
 * Holds the navigation state and main application loop.
 */
class NavController(
    val startDestination: String,
    private val graph: Map<String, NavComponent>
) {
    // The Backstack
    private val backStack = ArrayDeque<String>()
    private var isRunning = true

    init {
        backStack.addLast(startDestination)
    }

    // Pushes a new screen onto the stack
    fun navigate(route: String) {
        if (graph.containsKey(route)) {
            backStack.addLast(route)
        } else {
            println("\n[!] Error: Route '$route' does not exist in NavGraph.")
        }
    }

    // Pops the current screen, returning to the previous one
    fun popBackStack() {
        if (backStack.size > 1) {
            backStack.removeLast()
        } else {
            println("\n[!] Cannot pop root destination. Exiting app...")
            exit()
        }
    }

    // Kills the application loop
    fun exit() {
        isRunning = false
    }

    // The "Recomposition" Loop
    fun start() {
        while (isRunning && backStack.isNotEmpty()) {
            val currentRoute = backStack.last()
            val currentComponent = graph[currentRoute]

            // Render the top-most screen in the backstack
            currentComponent?.render()

            // 5. THE GUARANTEED BLOCK
            // The framework controls the console prompt, guaranteeing the thread sleeps.

            print("Enter choice: For Exit(X) ")

            val input = readlnOrNull()?.trim() ?: ""
            // 6. Pass the input back to the component to process
            if(input.lowercase() == "x") {
                exit()
                return
            }
            if(currentComponent?.handleInput(input, this) == false){
                if (backStack.size > 1) {
                    backStack.removeLast()
                } else {
                    exit()
                }
            }
        }
    }
}