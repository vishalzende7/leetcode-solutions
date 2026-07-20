package com.vishalzende.navigation

class NavGraphBuilder {
    val destinations = mutableMapOf<String, NavComponent>()

    fun composable(route: String, component: NavComponent) {
        destinations[route] = component
    }
}