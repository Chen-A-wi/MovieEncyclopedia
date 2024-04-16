package com.awilab.movieencyclopedia.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

// Learn more: https://medium.com/@KaushalVasava/navigation-in-jetpack-compose-full-guide-beginner-to-advanced-950c1133740
enum class PageType {
    HOME, LOGIN
}

sealed class NavigationItem(val route: String) {
    object Home : NavigationItem(PageType.HOME.name)
    object Login : NavigationItem(PageType.LOGIN.name)
}

@Composable
fun MainNavigation(
    navController: NavHostController = rememberNavController(),
) {
    NavHost(navController = navController, startDestination = "list") {
        composable("list") {
//            ListRoute
        }
    }
}
