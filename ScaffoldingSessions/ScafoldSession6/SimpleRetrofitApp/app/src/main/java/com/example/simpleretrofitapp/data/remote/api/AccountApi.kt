package com.example.simpleretrofitapp.data.remote.api

import com.example.simpleretrofitapp.data.model.Account
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path


//TODO 2 : Create an interface for the API requests
interface AccountApi {

    //all accounts
    @GET("users.json")
    suspend fun getAccounts(): List<Account>

    //this will not work as wwe did not implement the server side API
    @POST("/users")
    suspend fun addAccounts(@Body account: Account): Account

    //this will not work as wwe did not implement the server side API
    //Single account by id
    @POST("/users/{id}")
    suspend fun getAccount(@Path("id") id : String, @Body account: Account): Account
    
}