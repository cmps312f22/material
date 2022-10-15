package com.cmps312.todoapp

sealed class Screen(val route: String, val title: String) {

    object ProjectList : Screen(route = "Projects", title = "Project List")
    object ProjectScreen : Screen(route = "Add Project", title = "Add Project")
    object TodoList : Screen(route = "Todo List", title = "Todo List")
    object TodoScreen : Screen(route = "Todo Screen", title = "Todo")


}