package com.cmps312.todoapp.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.cmps312.todoapp.data.entity.Project
import com.cmps312.todoapp.data.entity.Todo
import com.cmps312.todoapp.data.repository.TodoListRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class TodoViewModel(application: Application) : AndroidViewModel(application) {
    private val TAG = "ProjectViewModel"
    private var _projects = MutableLiveData<List<Project>>()
    private var _todos = MutableLiveData<List<Todo>>()

    var projects: LiveData<List<Project>> = _projects
    var todos: LiveData<List<Todo>> = _todos

    lateinit var selectedTodo: Todo
    var selectedProject: Project? = null
    var isEdit = false

    init {
        registerProjectlistener()
        registerTodolistener()
    }

    fun getTodos(projectId: String) {
        _todos.value = listOf<Todo>() //clear the list
        viewModelScope.launch(Dispatchers.IO) {
            withContext(Dispatchers.Main) {
                _todos.value =
                    TodoListRepo.getTodoListByProject(projectId)
            }
        }
    }

    fun addTodo(todo: Todo) {
        viewModelScope.launch(Dispatchers.IO) {
            TodoListRepo.addTodo(todo).await()
        }
    }

    fun addProject(project: Project) {
        viewModelScope.launch(Dispatchers.IO) {
            TodoListRepo.addProject(project).await()
        }
    }

    fun updateProject(updatedProject: Project) = viewModelScope.launch(Dispatchers.IO) {
        TodoListRepo.updateProject(updatedProject)
    }
    fun deleteProject(project: Project) = viewModelScope.launch {
        Log.d(TAG, "deleteProject: is called $project")
        TodoListRepo.deleteProject(project)
    }

    private fun registerProjectlistener() {
       TODO()
    }

    private fun registerTodolistener() {
       TODO()
    }


}