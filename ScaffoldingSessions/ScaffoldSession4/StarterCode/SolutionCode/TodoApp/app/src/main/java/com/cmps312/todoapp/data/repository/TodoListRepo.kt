package com.cmps312.todoapp.data.repository

import com.cmps312.todoapp.data.entity.Project
import com.cmps312.todoapp.data.entity.Todo

object TodoListRepo {
    val TAG = "TodoListRepo"

    init {
        TODO()
    }

    suspend fun getProjects(): List<Project> {
        TODO()
    }

    fun addProject(project: Project) {
        TODO()
    }

    suspend fun updateProject(updatedProject: Project) {
        TODO()
    }


    suspend fun deleteProject(project: Project) {
        TODO()
    }

    suspend fun getTodoListByProject(pid: String): List<Todo> {
        TODO()
    }

    fun addTodo(todo: Todo) {
        TODO()
    }

    suspend fun getTodo(id: String) {
        TODO()
    }
}