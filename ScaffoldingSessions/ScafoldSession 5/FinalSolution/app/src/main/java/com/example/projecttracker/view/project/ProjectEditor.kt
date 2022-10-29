package com.example.projecttracker.view.project

import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.projecttracker.R
import com.example.projecttracker.data.entity.Project
import com.example.projecttracker.viewmodel.AuthViewModel
import com.example.projecttracker.viewmodel.TodoViewModel
import java.util.*

@Composable
fun ProjectScreen(onSubmit: () -> Unit) {
    val todoViewModel =
        viewModel<TodoViewModel>(viewModelStoreOwner = LocalContext.current as ComponentActivity)
    val authViewModel =
        viewModel<AuthViewModel>(viewModelStoreOwner = LocalContext.current as ComponentActivity)

    val context = LocalContext.current
    val pid = UUID.randomUUID()
    var projectName by remember { mutableStateOf("") }
    var title by remember { mutableStateOf(context.getString(R.string.add_project)) }

    if (todoViewModel.selectedProject != null) {
        title = context.getString(R.string.edit_project)
        projectName = todoViewModel.selectedProject!!.name.toString()
    }

    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .fillMaxSize(), elevation = 16.dp
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {

            Text(
                text = title,
                Modifier
                    .align(
                        Alignment.CenterHorizontally
                    )
                    .padding(16.dp), fontWeight = FontWeight.Bold
            )

            OutlinedTextField(
                value = projectName,
                onValueChange = { projectName = it },
                label = { Text(text = "Project Name ") },
                modifier = Modifier
                    .align(
                        Alignment.CenterHorizontally
                    )
                    .padding(16.dp)
                    .fillMaxWidth()
            )

            Button(
                onClick = {
                    if (
                        projectName.isNotEmpty()

                    ) {
                        if (todoViewModel.selectedProject == null) {
                            val newProject = authViewModel.user?.email?.let { Project(pid.toString(), projectName, userId = it) }
                            if (newProject != null) {
                                todoViewModel.addProject(newProject)
                            }
                        } else {
                            val updatedProject =
                                authViewModel.user?.email?.let { Project(todoViewModel.selectedProject!!.id, projectName , userId = it) }
                            if (updatedProject != null) {
                                todoViewModel.updateProject(updatedProject)
                            }
                        }

                        onSubmit()
                    } else {
                        Toast.makeText(
                            context, "Please provide all the information",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                },
                modifier = Modifier
                    .align(
                        Alignment.CenterHorizontally
                    )
                    .padding(16.dp)
            ) {
                Text(text = "Submit")
            }
        }
    }

}