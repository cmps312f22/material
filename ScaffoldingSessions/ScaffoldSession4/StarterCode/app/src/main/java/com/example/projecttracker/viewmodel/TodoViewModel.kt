package com.example.projecttracker.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.projecttracker.data.entity.Project
import com.example.projecttracker.data.entity.Todo
import com.example.projecttracker.data.repository.TodoListRepo
import com.google.firebase.firestore.ListenerRegistration
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TodoViewModel(application: Application) : AndroidViewModel(application) {

    private val TAG = "ProjectViewModel"
    var projects = MutableStateFlow<List<Project>>(emptyList())
        private set

    var todos = MutableStateFlow<List<Todo>>(emptyList())
        private set

    //the two listeners
    private lateinit var projectDocumentListener: ListenerRegistration
    private lateinit var todoDocumentListener: ListenerRegistration

    lateinit var selectedTodo: Todo
    var selectedProject: Project? = null

    var isEdit = false

    init {
        viewModelScope.launch { projects.value = TodoListRepo.getProjects() }

        //TODO register the listeners
        registerProjectListener()
        registerTodoListener()
    }

    fun getTodos(projectId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            withContext(Dispatchers.Main) {
                todos.value = TodoListRepo.getTodoListByProject(projectId)
            }
        }
    }

    fun addTodo(todo: Todo) {
        viewModelScope.launch(Dispatchers.IO) {
            TodoListRepo.addTodo(todo)
        }
    }

    fun addProject(project: Project) {
        viewModelScope.launch(Dispatchers.IO) {
            TodoListRepo.addProject(project)
        }
    }

    fun updateProject(updatedProject: Project) = viewModelScope.launch(Dispatchers.IO) {
        Log.d(TAG, updatedProject.toString())
        TodoListRepo.updateProject(updatedProject)
    }

    fun deleteProject(project: Project) = viewModelScope.launch {
        Log.d(TAG, "deleteProject: is called $project")
        TodoListRepo.deleteProject(project)
    }

    private fun registerProjectListener() {

    }

    private fun registerTodoListener() {
        todoDocumentListener =
            TodoListRepo.todosDocumentRef.addSnapshotListener { snappshot, e ->
                if (e != null) {
                    println(e.printStackTrace())
                    return@addSnapshotListener
                }
                val filtered = mutableListOf<Todo>()

                snappshot!!.toObjects(Todo::class.java).forEach {
                    if (it.projectId == selectedProject?.id)
                        filtered.add(it)

                    todos.value = filtered
                }
            }
    }

    //TODO
    private fun unregisterListeners() {
        todoDocumentListener.remove()
        projectDocumentListener.remove()
    }

    override fun onCleared() {
        super.onCleared()
        unregisterListeners()
    }
}