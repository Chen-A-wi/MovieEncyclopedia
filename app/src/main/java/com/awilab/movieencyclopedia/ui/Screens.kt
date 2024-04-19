package com.awilab.movieencyclopedia.ui

sealed class Screens(val route: String) {
    object Login : Screens("login")
    object Home : Screens("home")
    object Profile : Screens("profile/{id}?isEditable={isEditable}")
    object Search : Screens("search?query={query}")
}