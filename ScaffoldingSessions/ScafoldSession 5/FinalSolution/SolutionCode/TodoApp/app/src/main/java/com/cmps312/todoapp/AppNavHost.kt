package com.cmps312.todoapp

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.cmps312.todoapp.view.ProjectList
import com.cmps312.todoapp.view.ProjectScreen
import com.cmps312.todoapp.view.TodoList
import com.cmps312.todoapp.view.TodoScreen
import com.cmps312.todoapp.viewmodel.TodoViewModel

@Composable
fun AppNavHost(navHostController: NavHostController) {
    val todoViewModel =
        viewModel<TodoViewModel>(viewModelStoreOwner = LocalContext.current as ComponentActivity)

    NavHost(navController = navHostController, startDestination = Screen.ProjectList.route) {
        composable(route = Screen.ProjectList.route) {

            ProjectList(onAddProject = { navHostController.navigate(Screen.ProjectScreen.route) },
                onProjectSelected = { navHostController.navigate(Screen.TodoList.route) },
                onEditProject = { navHostController.navigate(Screen.ProjectScreen.route) })
        }

        composable(route = Screen.ProjectScreen.route) {
            ProjectScreen(onSubmit = { navHostController.navigate(Screen.ProjectList.route) })
        }

        composable(route = Screen.TodoList.route) {
            TodoList(onNavigate = { navHostController.navigate(Screen.TodoScreen.route) })
        }

        composable(route = Screen.TodoScreen.route) {
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