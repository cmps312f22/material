package com.example.projecttracker.data.entity

data class Todo(
    var title: String? = "",
    var priority: String? = "",
    var date: String? = "",
    var projectId: String = "",

    var id: String = ""
) {

    // Required by Firebase deserializer
    // otherwise you get exception 'does not define a no-argument constructor'
    constructor() : this(title = "", priority = "", date = "", projectId = "", id = "")
}