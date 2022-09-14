package com.msms.scaffoldsession3.ui.screens.item

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.msms.scaffoldsession3.navigation.Screen

@Composable
//fun ItemScreen(navController: NavController,id:Int){
fun ItemScreen(onNavigate: ()->Unit, id:Int){
    Column (
        modifier = Modifier.fillMaxSize(),
    ){
        Text(
            text = "Item Screen",
            color = MaterialTheme.colors.primary,
            fontSize = MaterialTheme.typography.h3.fontSize,
            fontWeight = FontWeight.Bold,
        )
        Text(
            text = "Received item id: $id from Home Screen",
            color = MaterialTheme.colors.primary,
            fontSize = MaterialTheme.typography.h5.fontSize,
            fontWeight = FontWeight.Bold,
        )
        Text(
            text = "Go to Profile Screen",
            color = MaterialTheme.colors.primary,
            fontSize = MaterialTheme.typography.h5.fontSize,
            fontWeight = FontWeight.Bold,
//            modifier = Modifier.clickable {
//                navController.navigate(route = Screen.Profile.route)
//            }
            modifier = Modifier.clickable {onNavigate()}
        )
    }
}