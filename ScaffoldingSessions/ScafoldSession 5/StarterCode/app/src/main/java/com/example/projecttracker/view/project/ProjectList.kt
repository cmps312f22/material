package com.example.projecttracker.view.project

import androidx.activity.ComponentActivity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.projecttracker.data.entity.Project
import com.example.projecttracker.viewmodel.AuthViewModel
import com.example.projecttracker.viewmodel.TodoViewModel
import kotlinx.coroutines.flow.asStateFlow

@Composable
fun ProjectList(
//    onAddProject: () -> Unit,
    navigateToTodoList: () -> Unit,
    onEditProject: () -> Unit,
) {

    val todoViewModel =
        viewModel<TodoViewModel>(viewModelStoreOwner = LocalContext.current as ComponentActivity)
    val authViewModel =
        viewModel<AuthViewModel>(viewModelStoreOwner = LocalContext.current as ComponentActivity)


    val projects by todoViewModel.projects.asStateFlow().collectAsState()

    authViewModel.user?.email?.let { todoViewModel.getProjects(it) }

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
                            navigateToTodoList()
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
//        Column(verticalArrangement = Arrangement.Bottom, horizontalAlignment = Alignment.End) {
//            FloatingActionButton(
//                onClick = {
//                    todoViewModel.selectedProject = null
//                    onAddProject()
//                },
//                backgroundColor = Color.Blue,
//                contentColor = Color.White,
//                modifier = Modifier.size(width = 62.dp, height = 62.dp)
//            ) {
//                Icon(Icons.Filled.Add, "")
//            }
//        }

    }
}

@Composable
fun ProjectCard(
    project: Project,
    onProjectSelected: () -> Unit,
    onEditProject: () -> Unit,
    onDeleteProject: () -> Unit,

    ) {
    Card(
        elevation = 10.dp,
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
                    .clickable {
                        onProjectSelected()
                    }
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