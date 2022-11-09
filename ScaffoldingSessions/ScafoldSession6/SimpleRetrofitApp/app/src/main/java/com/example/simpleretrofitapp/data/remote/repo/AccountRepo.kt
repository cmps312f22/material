package com.example.simpleretrofitapp.data.remote.repo

import retrofit2.Retrofit

object AccountRepo {

    val BASE_URL = "https://gist.githubusercontent.com/abdalabaaji/31714e28bc6ed0b506c90e5ed00f0f59/raw/db27d337b5d5d5e0a050cb1b12d5686a592ab2d6/"

    val accountApi by lazy {
        Retrofit.Builder()
            .baseUrl()
            .addConverterFactory()
            .build()
            .create()
    }
}