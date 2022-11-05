package com.example.simpleretrofitapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.simpleretrofitapp.ui.theme.SimpleRetrofitAppTheme
import com.example.simpleretrofitapp.viewmodel.AccountViewModel
import kotlinx.coroutines.flow.asStateFlow

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleRetrofitAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Home()
                }
            }
        }
    }
}

@Composable
fun Home() {
    val accountViewModel: AccountViewModel = viewModel()
    val accounts by accountViewModel.accounts.asStateFlow().collectAsState()

    LazyColumn {
        items(accounts) { account ->
            Text(text = account.name)
            Spacer(modifier = Modifier.fillMaxSize())
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SimpleRetrofitAppTheme {
        Home()
    }
}