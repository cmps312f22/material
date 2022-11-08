package com.example.simpleretrofitapp.data.remote.repo

import com.example.simpleretrofitapp.data.remote.api.AccountApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object AccountRepo {
    val BASE_URL = "https://gist.githubusercontent.com/abdalabaaji/31714e28bc6ed0b506c90e5ed00f0f59/raw/ba04331fdbb59ef0af192f8362c568b4dfe5c7b3/"

    private val accountApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AccountApi::class.java)
    }

    suspend fun getAccounts() = accountApi.getAccounts()
}