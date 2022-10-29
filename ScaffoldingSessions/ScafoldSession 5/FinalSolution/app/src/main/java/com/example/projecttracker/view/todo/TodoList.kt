package com.example.projecttracker.view.todo

import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.projecttracker.data.entity.Todo
import com.example.projecttracker.viewmodel.TodoViewModel
import kotlinx.coroutines.flow.asStateFlow

@Composable
fun TodoList(onNavigate: () -> Unit) {
    val todoViewModel =
        viewModel<TodoViewModel>(viewModelStoreOwner = LocalContext.current as ComponentActivity)
    val todos by todoViewModel.todos.asStateFlow().collectAsState()

    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize(),
        elevation = 16.dp
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            LazyColumn {
                items(todos) { todo ->
                    TodoCard(todo)
                }
            }
        }
    }
}

@Composable
fun TodoCard(todo: Todo) {

    Card(
        elevation = 10.dp,
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()

    ) {
        Row(
            modifier = Modifier
                .padding(15.dp)

        ) {

            Column(modifier = Modifier)
            {
                Text(text = "Task Name : ${todo.title}")
                Text(text = "Priority : ${todo.priority}")
                Text(text = "Deadline : ${todo.date}")
            }


        }

    }
}
