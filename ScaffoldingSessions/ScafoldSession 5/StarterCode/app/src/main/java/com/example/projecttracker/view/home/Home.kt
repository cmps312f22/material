package com.example.projecttracker.navigation

import android.util.Log
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.projecttracker.util.getCurrentRoute
import com.example.projecttracker.view.home.UserProfile
import com.example.projecttracker.viewmodel.AuthViewModel
import com.example.projecttracker.viewmodel.TodoViewModel
import kotlinx.coroutines.launch

@Composable
fun HomeSeen() {
    val TAG = "MainScreen"

    val authViewModel =
        viewModel<AuthViewModel>(viewModelStoreOwner = LocalContext.current as ComponentActivity)

    val navHostController = rememberNavController()

    //to control the drawer
    val state = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = state,
        topBar = { TopBar(navHostController) },
        floatingActionButton = {
            val currentScreen = getCurrentRoute(navHostController)
            val todoViewModel =
                viewModel<TodoViewModel>(viewModelStoreOwner = LocalContext.current as ComponentActivity)
            //we can reuse the floating action button to do different things depending on the focus screen
            if (!currentScreen.equals(Screen.Login.route))
                //TODO : EXPLAIN THIS
                FloatingActionButton(
                    onClick = {
                        when (currentScreen) {
                            Screen.ProjectList.route -> {
                                todoViewModel.selectedProject = null
                                navHostController.navigate(Screen.ProjectEditor.route)
                            }
                            Screen.TodoList.route -> navHostController.navigate(Screen.TodoEditor.route)
                            else -> Log.d(TAG, "MainScreen: ")
                        }

                    },
                    backgroundColor = Color.Blue,
                    contentColor = Color.White,
                    modifier = Modifier.size(width = 62.dp, height = 62.dp)
                ) {
                    Icon(Icons.Filled.Add, "")
                }
        },
        drawerContent = {
            //TODO : EXPLAIN THIS
            val todoViewModel =
                viewModel<TodoViewModel>(viewModelStoreOwner = LocalContext.current as ComponentActivity)
            UserProfile(signOut = {
                scope.launch {
                    state.drawerState.close()
                }

                todoViewModel.clearDate()
                authViewModel.signOut()
                navHostController.navigate(Screen.Login.route)

            })
        },
        drawerGesturesEnabled = authViewModel.user != null

    ) {
        AppNavHost(navHostController, it)
    }
}

@Composable
fun TopBar(navHostController: NavHostController) {
    val currentRoute = navHostController
        .currentBackStackEntryAsState().value?.destination?.route
    TopAppBar(
        title = {
            Text(text = currentRoute.toString())
        },
        //Provide the navigation Icon ( Icon on the left to toggle drawer)

    )
}
