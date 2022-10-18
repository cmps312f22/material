package com.example.projecttracker.data.remote.repository

import android.util.Log
import com.example.projecttracker.data.entity.Project
import com.example.projecttracker.data.entity.Todo
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.firestoreSettings
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await

object TodoListRepo {
    val TAG = "TodoListRepo"

    val db by lazy { Firebase.firestore }
    val projectDocumentRef by lazy { db.collection("projects") }
    val todosDocumentRef by lazy { db.collection("todos") }

    init {
        val settings = firestoreSettings { isPersistenceEnabled = true }
        db.firestoreSettings = settings
    }

    //TODO () ADD THE DOCUMENT REFERENCE

    suspend fun getProjects(userId : String): List<Project> = projectDocumentRef.whereEqualTo("userId", userId)
        .get().await()
        .toObjects(Project::class.java)

    suspend fun addProject(project: Project) {
        val documentId = projectDocumentRef.document().id
        project.id = documentId
        projectDocumentRef.document(documentId).set(project).await()
    }

    suspend fun updateProject(updatedProject: Project) = projectDocumentRef
        .document(updatedProject.id)
        .set(updatedProject)
        .addOnSuccessListener {
            Log.d(TAG, "Successfully updated")
        }.addOnFailureListener {
            it.message?.let { it1 -> Log.d(TAG, it1) }
        }

    suspend fun deleteProject(project: Project) =
        projectDocumentRef.document(project.id).delete().await()

    //TODO : EXPLAIN THE CHANGES MADE FROM THE PREVIOUS SESSION PROJECT

    suspend fun getTodoListByProject(projectId: String): List<Todo> = projectDocumentRef
        .document(projectId)
        .collection("todos")
        .get()
        .await()
        .toObjects(Todo::class.java)

    //TODO : EXPLAIN THE CHANGES MADE FROM THE PREVIOUS SESSION TO THE ADD_TO_DO
    suspend fun addTodo(todo: Todo) {
        val documentId = projectDocumentRef
            .document(todo.projectId)
            .collection("todos")
            .document().id
        todo.id = documentId

        projectDocumentRef
            .document(todo.projectId)
            .collection("todos")
            .document(documentId).set(todo).await()
    }

    suspend fun deleteTodo(id: String) = todosDocumentRef.document(id).delete().await()
    suspend fun getTodo(id: String) = todosDocumentRef.document(id).get().await()
}

