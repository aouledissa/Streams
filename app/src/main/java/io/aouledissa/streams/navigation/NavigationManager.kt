package io.aouledissa.streams.navigation

import androidx.navigation.NavController
import androidx.navigation.NavDirections

interface INavigationManager {
    val navController: NavController

    fun navigate(destination: NavDirections)
}

class NavigationManager(override val navController: NavController) : INavigationManager {

    override fun navigate(destination: NavDirections) {
        navController.navigate(destination)
    }
}