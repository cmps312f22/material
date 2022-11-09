package com.example.simpleretrofitapp.data.remote.api

import com.example.simpleretrofitapp.data.model.Account
import retrofit2.http.GET
import retrofit2.http.Path


//https://gist.githubusercontent.com/abdalabaaji/31714e28bc6ed0b506c90e5ed00f0f59/raw/db27d337b5d5d5e0a050cb1b12d5686a592ab2d6/accounts
interface AccountApi {

    //annotations
    @GET("/accounts")
    fun getAccounts(): List<Account>

        @GET("/products/{id}")
        fun getProduct(@Path("id") id : Int)

//        @POST("/company")
//        fun addCompany(@Body company : Company) : Company
//
//        @PUT("/company/{id}")
//        fun updateCompany(@Body company : Company, @Path("id") id: Int) : Company
//
//
//        @DELETE("/company/{id}")
//        fun deleteCompany( @Path("id") id: Int) : Int
}