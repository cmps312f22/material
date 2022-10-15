package com.example.projecttracker

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.cmps312.todoapp.view.todo.TodoScreen
import com.example.projecttracker.view.project.ProjectList
import com.example.projecttracker.view.project.ProjectScreen
import com.example.projecttracker.view.todo.TodoList

@Composable
fun AppNavHost(navHostController: NavHostController, paddingValues: PaddingValues) {
//    val todoViewModel =
//        viewModel<TodoViewModel>(viewModelStoreOwner = LocalContext.current as ComponentActivity)
    NavHost(navController = navHostController, startDestination = Screen.ProjectList.route) {
        composable(route = Screen.ProjectList.route) {
            ProjectList(onAddProject = { navHostController.navigate(Screen.ProjectScreen.route) },
                navigateToTodoList = { navHostController.navigate(Screen.TodoList.route) },
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