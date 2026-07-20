package com.vishalzende.navigation

/**
 * The entry point for the navigation graph.
 */

fun NavHost(startDestination: String, builder: NavGraphBuilder.() -> Unit) {
    val graphBuilder = NavGraphBuilder()
    graphBuilder.builder()

    val navController = NavController(
        startDestination = startDestination,
        graph = graphBuilder.destinations
    )

    navController.start()
}