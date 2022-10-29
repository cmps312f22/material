package com.cmps312.todoapp

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@Composable
fun MainScreen() {
    val navHostController = rememberNavController()
    Scaffold(
        topBar = { TopBar(navHostController) },
        // floatingActionButton = { FAB(navHostController)}

    ) {
        AppNavHost(navHostController)
    }
}

@Composable
fun TopBar(navHostController: NavHostController) {
    val currentRoute = navHostController
        .currentBackStackEntryAsState()?.value?.destination?.route
    TopAppBar(
        title = {
            Text(text = currentRoute.toString())
        },
        //Provide the navigation Icon ( Icon on the left to toggle drawer)

    )
}