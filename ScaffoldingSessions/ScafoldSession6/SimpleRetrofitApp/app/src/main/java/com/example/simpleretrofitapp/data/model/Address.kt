package com.example.simpleretrofitapp.data.model

data class Address(
    val street: String,
    val suite: String,
    val city: String,
    val zipcode: String,
    val geo: Geo
)