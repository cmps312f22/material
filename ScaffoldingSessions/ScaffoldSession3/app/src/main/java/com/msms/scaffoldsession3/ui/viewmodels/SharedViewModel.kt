package com.msms.scaffoldsession3.ui.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.msms.scaffoldsession3.util.Action
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SharedViewModel: ViewModel() {
    val id: MutableState<Int> = mutableStateOf(0)
    val searchTextState: MutableState<String> = mutableStateOf("")
    val action: MutableState<Action> = mutableStateOf(Action.NO_ACTION)

//    private val _allBreeds = MutableStateFlow<List<Breed>>(emptyList())
//    val allBreeds : StateFlow <List<Breed>> =_allBreeds
//
//    init {
//        getAllBreeds()
//    }
//
//    private fun getAllBreeds(){
//        viewModelScope.launch {
//            repository.getAllBreeds.collect{
//                _allBreeds.value = it
//            }
//        }
//    }
}