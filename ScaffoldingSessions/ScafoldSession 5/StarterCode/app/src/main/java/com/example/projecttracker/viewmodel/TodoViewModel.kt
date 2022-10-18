package com.example.projecttracker.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.projecttracker.data.entity.Project
import com.example.projecttracker.data.entity.Todo
import com.example.projecttracker.data.remote.repository.TodoListRepo
import com.google.firebase.firestore.ListenerRegistration
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class TodoViewModel(application: Application) : AndroidViewModel(application) {

    private val TAG = "ProjectViewModel"

    var projects = MutableStateFlow<List<Project>>(emptyList())
        private set
    var todos = MutableStateFlow<List<Todo>>(emptyList())
        private set

    //the two listeners
    private var projectDocumentListener: ListenerRegistration? = null
    private var todoDocumentListener: ListenerRegistration? = null

    var selectedProject: Project? = null

    //    it will help us reuse the form for editing
    var isEdit = false


    //TODO GETTING PROJECTS
    fun getProjects(userId: String) {
        viewModelScope.launch(Dispatchers.IO) {
//            projects.value = TodoListRepo.getProjects(userId)
//            registerProjectListener()
        }
    }


    //    TODO GETTING TODOS
    fun getTodos(projectId: String) {
//        todos.value = emptyList()
//        viewModelScope.launch(Dispatchers.IO) {
//            todoDocumentListener?.remove()
//            todos.value = TodoListRepo.getTodoListByProject(projectId)
//            registerTodoListener(projectId)
//        }
    }

    //TODO ADDING TODO
    fun addTodo(todo: Todo) {
//        viewModelScope.launch(Dispatchers.IO) {
//            TodoListRepo.addTodo(todo)
//        }
    }

    //TODO ADD PROJECT
    fun addProject(project: Project) {
//        viewModelScope.launch(Dispatchers.IO) {
//            TodoListRepo.addProject(project)
//        }
    }

    fun updateProject(updatedProject: Project) = viewModelScope.launch(Dispatchers.IO) {
        Log.d(TAG, updatedProject.toString())
        TodoListRepo.updateProject(updatedProject)
    }

    fun deleteProject(project: Project) = viewModelScope.launch {
        Log.d(TAG, "deleteProject: is called $project")
        TodoListRepo.deleteProject(project)
    }


    //TODO EXPLAIN HOW THE LISTNER IS IMPLEMENTED
    private fun registerProjectListener() {

//        projectDocumentListener = TodoListRepo.projectDocumentRef.whereEqualTo(
//            "userId",
//            FirebaseAuth.getInstance().currentUser?.email
//        ).addSnapshotListener { snapshot, error ->
//            if (error != null) {
//                Log.d(TAG, error.message.toString())
//                return@addSnapshotListener
//            }
//            projects.value = snapshot!!.toObjects(Project::class.java)
//        }

    }

    //TODO EXPLAIN HOW THE LISTNER IS IMPLEMENTED
    private fun registerTodoListener(projectId: String) {

//        todoDocumentListener =
//            TodoListRepo.projectDocumentRef
//                .document(projectId)
//                .collection("todos")
//                .orderBy("priority", Query.Direction.ASCENDING)
//                .addSnapshotListener { snapshot, e ->
//                    if (e != null) return@addSnapshotListener
//                    todos.value = snapshot!!.toObjects(Todo::class.java)
//                }
    }

    //    TODO EXPLAIN WHY WE NEED THIS
    override fun onCleared() {
        super.onCleared()
//        todoDocumentListener?.remove()
//        projectDocumentListener?.remove()

    }

    fun clearDate() {
        projects.value = emptyList()
        todos.value = emptyList()
    }
}