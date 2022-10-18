package com.example.projecttracker.data.entity

import kotlinx.serialization.Serializable

@Serializable
data class Project(
    var id: String = "",
    var name: String? = "",
    var imageUrl: String? = "",

    //TODO 1. EACH PROJECT NOW HAS A USER LINKED TO IT
    var userId: String
) {
    // Required by Firebase deserializer
    // otherwise you get exception 'does not define a no-argument constructor'
    constructor() : this(id = "", name = "", imageUrl = "", userId = "")

}