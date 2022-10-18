package com.cmps312.todoapp.data.entity

import com.google.firebase.firestore.DocumentId

data class Todo(
    var title: String? = "",
    var priority: String? = "",
    var date: String? = "",
    var projectId: String? = "",

    //todo make it an document id
    var id: String = "",
)