package com.example.projecttracker.view.todo

import android.os.Build
import androidx.activity.ComponentActivity
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.projecttracker.data.entity.Todo
import com.example.projecttracker.view.components.DatePicker
import com.example.projecttracker.viewmodel.TodoViewModel
import kotlinx.datetime.LocalDate


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TodoScreen(onAddTodo: () -> Unit) {

    //this is coming from java
    val today = java.time.LocalDate.now()

    val todoViewModel =
        viewModel<TodoViewModel>(viewModelStoreOwner = LocalContext.current as ComponentActivity)

    var todoTask by remember { mutableStateOf("") }
    var priority by remember { mutableStateOf("Low") }

    var date by remember {
        mutableStateOf(
            LocalDate(
                today.year,
                today.month,
                today.dayOfMonth
            )
        )
    }

    var expandable by remember { mutableStateOf(false) }
    val options = listOf("High", "Medium", "Low")

    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        elevation = 16.dp
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            OutlinedTextField(
                value = todoTask,
                onValueChange = { todoTask = it },
                label = { Text(text = "Enter Task ") })
            Row(modifier = Modifier.clickable { expandable = !expandable }) {
                OutlinedTextField(
                    value = priority,
                    onValueChange = {},
                    enabled = false,
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.ArrowDropDown,
                            contentDescription = ""
                        )
                    })
                DropdownMenu(expanded = expandable, onDismissRequest = { expandable = false }) {
                    options.forEach { st ->
                        DropdownMenuItem(onClick = {
                            expandable = false
                            priority = st
                        }) {
                            Text(text = "$st")
                        }
                    }
                }

            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                DatePicker(
                    LocalContext.current,
                    "Select Date",
                    LocalDate(
                        today.year,
                        today.monthValue,
                        today.dayOfMonth
                    )
                ) { selectedDate -> date = selectedDate }
                Spacer(modifier = Modifier.padding(40.dp))
                Text(fontWeight = FontWeight.Bold, text = date.toString())
            }
            Button(onClick = {
                val todo = Todo(
                    todoTask,
                    priority,
                    date.toString(),
                    todoViewModel.selectedProject!!.id
                )

                todoViewModel.addTodo(todo)
                onAddTodo()
            }) {
                Text(text = "Add Task")
            }

        }

    }
}


