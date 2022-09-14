package com.msms.scaffoldsession3.ui.screens.home

import androidx.activity.viewModels
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.msms.scaffoldsession3.ui.viewmodels.HomeViewModel
import com.msms.scaffoldsession3.ui.viewmodels.MainActivityViewModel

//@Composable
//fun HomeScreen(navController: NavController){
//    Column (
//        modifier = Modifier.fillMaxSize(),
//    ){
//            Text(
//                text = "Home Screen",
//                color = MaterialTheme.colors.primary,
//                fontSize = MaterialTheme.typography.h3.fontSize,
//                fontWeight = FontWeight.Bold,
//            )
//            repeat(8) { id ->
//                Text(
//                    text = "Item number $id",
//                    color = Color.Black,
//                    fontSize = MaterialTheme.typography.h5.fontSize,
//                    modifier = Modifier
//                        .padding(8.dp)
//                        .clickable {
////                            navController.navigate(route = Screen.Item.route)
//                            navController.navigate(route = "item/$id")
//                        }
//                )
//            }
//        }
//}

@Composable
//fun HomeScreen(navController: NavController, homeViewModel: HomeViewModel = viewModel()){
fun HomeScreen(navController: NavController, mainActivityViewModel: MainActivityViewModel = viewModel()){

//    val myList:  List<String> = homeViewModel.myList
    val myList:  List<String> = mainActivityViewModel.myList

    var item by remember {mutableStateOf("")}

    Column (
        modifier = Modifier.fillMaxSize(),
    ){
        Text(
            text = "Home Screen",
            color = MaterialTheme.colors.primary,
            fontSize = MaterialTheme.typography.h3.fontSize,
            fontWeight = FontWeight.Bold,
        )
        OutlinedTextField(
            value = item,
            onValueChange = { value->
                item = value
            }
        )
        Button(
            onClick = {
//                homeViewModel.addItem(item)
                mainActivityViewModel.addItem(item)
            }
        ) {
            Text(text = "Add Item")
        }
        myList.forEachIndexed { id, item ->
            Text(
                text = item,
                color = Color.Black,
                fontSize = MaterialTheme.typography.h5.fontSize,
                modifier = Modifier
                    .padding(8.dp)
                    .clickable {
                  //          navController.navigate(route = Screen.Item.route)
                        navController.navigate(route = "item/$id")
                    }
            )
        }
    }
}