package com.example.simpleretrofitapp.data.remote.api

import android.accounts.Account
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path


//https://gist.githubusercontent.com/abdalabaaji/31714e28bc6ed0b506c90e5ed00f0f59/raw/ba04331fdbb59ef0af192f8362c568b4dfe5c7b3/users
interface AccountApi {
    @GET("/users")
    fun getAccounts() : List<Account>

    @GET("/users/{id}")
    fun getAccount(@Path("id") id : Int) : Account

    @POST("/users")
    fun addAccount(@Body account: Account) : Account

}