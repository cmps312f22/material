package com.msms.scaffoldsession3.navigation

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.navigation.NavHostController
import com.msms.scaffoldsession3.util.Action
import com.msms.scaffoldsession3.util.Constants.SCREEN1

class Navigate(navController: NavHostController) {
    val toHome: (Action) -> Unit = {
        navController.navigate("screen1/${it.name}"){
            popUpTo(SCREEN1){inclusive = true}
        }
    }
    val toItem: (Int) -> Unit = {
        navController.navigate("screen2/$it")
    }
}


