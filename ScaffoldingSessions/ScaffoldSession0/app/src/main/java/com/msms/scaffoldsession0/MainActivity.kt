package com.msms.scaffoldsession0

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.msms.scaffoldsession0.ui.theme.ScaffoldSession0Theme
import com.msms.scaffoldsession0.views.composabledemo.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScaffoldSession0Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
//                    Greeting("Android")
//                    ButtonDemo()
//                    ButtonDemo1()
//                    ButtonsDemo()
//                    TextFieldsDemo()
//                    TabRawDemo1()
//                    TabRawDemo2()
//                    ScrollableTabRow1()
                    ScaffoldDemo()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    ScaffoldSession0Theme {
//        Greeting("Android")
//    }
//}