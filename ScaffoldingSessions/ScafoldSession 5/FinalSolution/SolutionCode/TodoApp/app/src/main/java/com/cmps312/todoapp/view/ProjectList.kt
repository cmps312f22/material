package com.cmps312.todoapp.view

import androidx.activity.ComponentActivity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.cmps312.todoapp.data.entity.Project
import com.cmps312.todoapp.viewmodel.TodoViewModel

@Composable
fun ProjectList(
    onAddProject: () -> Unit,
    onProjectSelected: () -> Unit,
    onEditProject: () -> Unit,
) {

    val todoViewModel =
        viewModel<TodoViewModel>(viewModelStoreOwner = LocalContext.current as ComponentActivity)
    val projects = todoViewModel.projects.observeAsState(listOf()).value
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
                items(projects) { project ->
                    ProjectCard(project,
                        onProjectSelected = {
                            todoViewModel.selectedProject = project
                            todoViewModel.getTodos(project.id)
                            onProjectSelected()
                        },
                        onEditProject = {
                            todoViewModel.selectedProject = project
                            todoViewModel.isEdit = true
                            onEditProject()
                        },
                        onDeleteProject = {
                            todoViewModel.deleteProject(project)
                        })
                }
            }
        }
        Column(verticalArrangement = Arrangement.Bottom, horizontalAlignment = Alignment.End) {
            FloatingActionButton(
                onClick = {
                    todoViewModel.selectedProject = null
                    onAddProject()
                },
                backgroundColor = Color.Blue,
                contentColor = Color.White,
                modifier = Modifier.size(width = 62.dp, height = 62.dp)) {
                Icon(Icons.Filled.Add, "")
            }
        }

    }
}

@Composable
fun ProjectCard(
    project: Project,
    onProjectSelected: () -> Unit,
    onEditProject: () -> Unit,
    onDeleteProject: () -> Unit,

    ) {
    Card(elevation = 10.dp,
        backgroundColor = Color.LightGray,
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()

    ) {
        Row(
            modifier = Modifier
                .padding(15.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(text = "${project.name}",
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .clickable { onProjectSelected() }
                    .weight(1f))
            Row {
                Icon(imageVector = Icons.Default.Edit,
                    contentDescription = "Edit Icon",
                    modifier = Modifier
                        .clickable {
                            onEditProject()
                        }
                        .padding(horizontal = 5.dp))
                Icon(imageVector = Icons.Default.Delete,
                    contentDescription = "Delete Icon",
                    modifier = Modifier.clickable {
                        onDeleteProject()
                    })
            }
        }

    }
}