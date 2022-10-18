package com.cmps312.todoapp.data.repository

import android.util.Log
import com.cmps312.todoapp.data.entity.Project
import com.cmps312.todoapp.data.entity.Todo
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await


object TodoListRepo {
    val TAG = "TodoListRepo"

    private val db by lazy { Firebase.firestore }
    val projectDocumentRef by lazy { db.collection("project") }
    val todoDocumentRef by lazy { db.collection("todo") }

    suspend fun getProjects(): List<Project> =
        projectDocumentRef.get().await().toObjects(Project::class.java)

    fun addProject(project: Project) = projectDocumentRef.add(project)
        .addOnSuccessListener { Log.d(TAG, "Successfully added") }
        .addOnFailureListener { Log.d(TAG, it.stackTraceToString()) }

    suspend fun updateProject(updatedProject: Project) =
        projectDocumentRef.document(updatedProject.id).set(updatedProject)

    suspend fun deleteProject(project: Project) {
        val todos = getTodoListByProject(project.id)
        todos.forEach { deleteTodo(it.id) }
        projectDocumentRef.document(project.id).delete()

    }

    suspend fun getTodoListByProject(pid: String): List<Todo> = todoDocumentRef
        .whereEqualTo("pid", pid)
        .get().await()
        .toObjects(Todo::class.java)

    fun addTodo(todo: Todo) = todoDocumentRef.add(todo)
        .addOnSuccessListener { Log.d(TAG, "Successfully added") }
        .addOnFailureListener { Log.d(TAG, it.stackTraceToString()) }

    suspend fun deleteTodo(id: String) = todoDocumentRef.document(id).delete()

    suspend fun getTodo(id: String) =
        todoDocumentRef.document(id).get().await().toObject(Todo::class.java)

}