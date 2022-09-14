package com.msms.scaffoldsession3

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.msms.scaffoldsession3.navigation.BottomBarScreen
import com.msms.scaffoldsession3.navigation.Screen
import com.msms.scaffoldsession3.ui.screens.home.HomeScreen
import com.msms.scaffoldsession3.ui.screens.item.ItemScreen
import com.msms.scaffoldsession3.ui.screens.profile.ProfileScreen
import com.msms.scaffoldsession3.ui.screens.settings.SettingsScreen

@Composable

fun NavigationGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ){
        composable(route = Screen.Home.route){
            HomeScreen(navController)
        }
        composable(route = Screen.Profile.route){
            ProfileScreen(navController)
        }
        composable(route = Screen.Settings.route){
            SettingsScreen(navController)
        }
        composable(
            route = Screen.Item.route,
            arguments = listOf(navArgument("id"){
                type = NavType.IntType
            })
        ){
            val id = it.arguments?.getInt("id")//,0)

            if (id != null) {
//                ItemScreen(navController = navController,id)
                ItemScreen(onNavigate = { navController.navigate(route = Screen.Profile.route)},id)
            }
        }
    }
}