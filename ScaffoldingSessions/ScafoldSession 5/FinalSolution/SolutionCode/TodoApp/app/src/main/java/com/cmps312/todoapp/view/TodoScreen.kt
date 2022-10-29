package com.cmps312.todoapp.view

import androidx.activity.ComponentActivity
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
import com.cmps312.todoapp.data.entity.Todo
import com.cmps312.todoapp.view.components.Datepicker
import com.cmps312.todoapp.viewmodel.TodoViewModel
import kotlinx.datetime.LocalDate
import java.util.*

@Composable
fun TodoScreen(onAddTodo: () -> Unit) {

    val todoViewModel =
        viewModel<TodoViewModel>(viewModelStoreOwner = LocalContext.current as ComponentActivity)

    var todoTask by remember { mutableStateOf("") }
    var priority by remember { mutableStateOf("") }
    var date by remember { mutableStateOf(LocalDate(2021, 1, 4)) }

    var expandable by remember {
        mutableStateOf(false)
    }

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
                horizontalArrangement = Arrangement.SpaceBetween) {
                Datepicker(LocalContext.current,
                    "Select Date",
                    LocalDate(2021, 11, 4)) { selectedDate -> date = selectedDate }
                Spacer(modifier = Modifier.padding(40.dp))
                Text(fontWeight = FontWeight.Bold, text = date.toString())
            }
            Button(onClick = {
                val todo = Todo(
                    todoTask,
                    priority,
                    date.toString(),
                    todoViewModel.selectedProject?.id, UUID.randomUUID().toString()
                )
                todoViewModel.addTodo(todo)
                onAddTodo()
            }) {
                Text(text = "Add Task")
            }

        }

    }
}
