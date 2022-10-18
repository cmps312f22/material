package com.example.projecttracker.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.projecttracker.view.login.Login
import com.example.projecttracker.view.project.ProjectList
import com.example.projecttracker.view.project.ProjectScreen
import com.example.projecttracker.view.todo.TodoList
import com.example.projecttracker.view.todo.TodoScreen
import com.google.firebase.auth.FirebaseAuth

@Composable
fun AppNavHost(navHostController: NavHostController, paddingValues: PaddingValues) {

    NavHost(
        navController = navHostController,
        startDestination = if (FirebaseAuth.getInstance().currentUser == null) Screen.Login.route else Screen.ProjectList.route
    ) {
        composable(route = Screen.Login.route) {
            Login { projectList -> navHostController.navigate(projectList) }
        }

        composable(route = Screen.ProjectList.route) {
            ProjectList(navigateToTodoList = {
                    navHostController.navigate(Screen.TodoList.route)
                },
                onEditProject = { navHostController.navigate(Screen.ProjectEditor.route) })
        }

        composable(route = Screen.ProjectEditor.route) {
            ProjectScreen(onSubmit = {
                navHostController.navigate(Screen.ProjectList.route) {
                    popUpTo(Screen.ProjectEditor.route) {
                        inclusive = true
                    }
                }
            })
        }

        composable(route = Screen.TodoList.route) {
            TodoList(onNavigate = {
                navHostController.navigate(
                    Screen.TodoEditor.route
                ) { popUpTo(Screen.TodoEditor.route) { inclusive = true } }
            })
        }

        composable(route = Screen.TodoEditor.route) {
            TodoScreen(onAddTodo = {
                navHostController.navigate(Screen.TodoList.route) {
                    popUpTo(Screen.TodoList.route) {
                        inclusive = true
                    }
                }
            })
        }
    }
}