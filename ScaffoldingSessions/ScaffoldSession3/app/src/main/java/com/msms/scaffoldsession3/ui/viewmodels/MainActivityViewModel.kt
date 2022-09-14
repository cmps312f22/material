package com.msms.scaffoldsession3.ui.viewmodels

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel

class MainActivityViewModel: ViewModel() {
    private val _myList: SnapshotStateList<String> = mutableStateListOf<String>()
    val myList: List<String> = _myList

    init {
        initMyList()
    }
    private fun initMyList(){
        repeat(8) { id ->
            _myList.add("Item number $id")
        }
    }

    fun addItem(item: String){
        _myList.add(item)
    }
}