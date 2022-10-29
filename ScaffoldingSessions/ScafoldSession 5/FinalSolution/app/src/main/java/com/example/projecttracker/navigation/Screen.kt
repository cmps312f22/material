package com.example.projecttracker.navigation

sealed class Screen(val route: String, val title: String) {

    object Login : Screen(route = "Login", title = "Login")
    object ProjectList : Screen(route = "Projects", title = "Project List")
    object ProjectEditor : Screen(route = "Project Editor", title = "Project Editor")
    object TodoList : Screen(route = "Todo List", title = "Todo List")
    object TodoEditor : Screen(route = "Todo Editor", title = "Todo")


}