package com.example.simpleretrofitapp.data.remote.repo

import android.util.Log
import com.example.simpleretrofitapp.data.model.Account
import com.example.simpleretrofitapp.data.remote.api.AccountApi
import kotlinx.coroutines.runBlocking
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object AccountRepo {
    val BASE_URL =
        "https://gist.githubusercontent.com/abdalabaaji/31714e28bc6ed0b506c90e5ed00f0f59/raw/db27d337b5d5d5e0a050cb1b12d5686a592ab2d6/"

    // TODO 3: Create a Retrofit object
    val accountApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AccountApi::class.java)
    }

    suspend fun getAccounts() = accountApi.getAccounts()

    //TODO 4: Create a function to add the data to firebase
    //fun addAccounts(account : Account) = db.collection("accounts").add(account)
    init {
        initializeAccounts()
    }

    private fun initializeAccounts() {
        val data = runBlocking { getAccounts() }
        Log.d("The data TAG", "initializeAccounts: $data")
        //TODO 4: Add data to firebase
        //        data.forEach { addAccounts(it) }
    }
}
//
////import okhttp3.MediaType.Companion.toMediaType
//val mediaType = MediaType.parse("application/json")
////OR
//val contentType = "application/json".toMediaType()
//
//val converterFactory = Json { ignoreUnknownKeys = true }
//    .asConverterFactory(contentType)*/