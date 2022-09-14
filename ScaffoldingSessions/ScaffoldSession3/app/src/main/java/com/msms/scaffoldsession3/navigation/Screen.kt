package com.msms.scaffoldsession3.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

//sealed class Screen(val route: String){
//    object Home: Screen(route = "home")
//    object Item: Screen(route = "item")
//    object Profile: Screen(route = "profile")
//    object Settings: Screen(route = "settings")
//}

//sealed class Screen(val route: String){
//    object Home: Screen(route = "home")
//    object Item: Screen(route = "item/{id}")
//    object Profile: Screen(route = "profile")
//    object Settings: Screen(route = "settings")
//}
//
sealed class Screen(
    val route: String,
    val title: String,
    val icon: ImageVector
){
    object Home: Screen(
        route = "home",
        title = "Home",
        icon = Icons.Default.Home
    )
    object Profile: Screen(
        route = "profile",
        title = "Profile",
        icon = Icons.Default.Person
    )
    object Settings: Screen(
        route = "settings",
        title = "Settings",
        icon = Icons.Default.Settings
    )
    object Item: Screen(
        route = "item/{id}",
        title = "Item",
        icon = Icons.Default.Info
    )
}
