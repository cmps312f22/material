package com.cmps312.todoapp.view

import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.cmps312.todoapp.data.entity.Todo
import com.cmps312.todoapp.viewmodel.TodoViewModel

@Composable
fun TodoList(onNavigate: () -> Unit) {
    val todoViewModel =
        viewModel<TodoViewModel>(viewModelStoreOwner = LocalContext.current as ComponentActivity)
    val todos = todoViewModel.todos.observeAsState(listOf()).value

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
        Column(verticalArrangement = Arrangement.Bottom, horizontalAlignment = Alignment.End) {
            FloatingActionButton(
                onClick = { onNavigate() },
                backgroundColor = Color.Blue,
                contentColor = Color.White,
                modifier = Modifier.size(width = 62.dp, height = 62.dp)
            ) {
                Icon(Icons.Filled.Add, "")
            }
        }

    }
}

@Composable
fun TodoCard(todo: Todo) {

    Card(elevation = 10.dp,
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()

    ) {
        Row(modifier = Modifier
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
