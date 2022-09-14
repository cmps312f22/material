package com.msms.scaffoldsession3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.msms.scaffoldsession3.navigation.SetupNavigation
import com.msms.scaffoldsession3.ui.theme.ScaffoldSession3Theme
import com.msms.scaffoldsession3.ui.viewmodels.MainActivityViewModel

class MainActivity : ComponentActivity() {
    private lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mainActivityViewModel: MainActivityViewModel by viewModels()

        setContent {

            ScaffoldSession3Theme {
                navController = rememberNavController()
//                SetupNavigation(navController)

               MainScreen(navController)

            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ScaffoldSession3Theme {
        Greeting("Android")
    }
}