package com.example.simpleretrofitapp.data.remote.api

import com.example.simpleretrofitapp.data.model.Account
import com.example.simpleretrofitapp.data.model.Company
import retrofit2.http.*


//TODO 2 : Create an interface for the API requests
interface AccountApi {

    @GET("/users.json")
    fun getAccounts() : List<Account>

    @PUT("/company/{id}")
    fun addCompany(@Body company : Company,
                   @Path("id") id : Int) : Company


//    //all accounts
//    @GET("users.json")
//    suspend fun getAccounts(): List<Account>
//
//    //this will not work as wwe did not implement the server side API
//    @POST("/users")
//    suspend fun addAccounts(@Body account: Account): Account
//
//    //this will not work as wwe did not implement the server side API
//    //Single account by id
//    @POST("/users/{id}")
//    suspend fun getAccount(@Path("id") id : String, @Body account: Account): Account

}