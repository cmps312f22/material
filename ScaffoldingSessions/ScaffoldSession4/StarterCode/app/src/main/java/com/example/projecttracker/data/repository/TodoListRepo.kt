package com.example.projecttracker.data.repository

import com.example.projecttracker.data.entity.Project
import com.example.projecttracker.data.entity.Todo


object TodoListRepo {


    //TODO () ADD THE DOCUMENT REFERENCE

    suspend fun getProjects(): List<Project> = TODO()
    suspend fun addProject(project: Project) {
        TODO()
    }

    suspend fun updateProject(updatedProject: Project) = TODO()
    suspend fun deleteProject(project: Project) = TODO()
    suspend fun getTodoListByProject(pid: String) = TODO()
    suspend fun addTodo(todo: Todo) = TODO()
    suspend fun deleteTodo(id: String) = TODO()
    suspend fun getTodo(id: String) = TODO()
}

