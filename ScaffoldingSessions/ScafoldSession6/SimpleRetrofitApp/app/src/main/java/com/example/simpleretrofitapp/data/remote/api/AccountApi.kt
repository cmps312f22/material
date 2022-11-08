package com.example.simpleretrofitapp.data.remote.api

import android.accounts.Account
import retrofit2.http.GET


//https://gist.githubusercontent.com/abdalabaaji/31714e28bc6ed0b506c90e5ed00f0f59/raw/ba04331fdbb59ef0af192f8362c568b4dfe5c7b3/users
interface AccountApi {
    @GET("")
    fun getAccounts() : List<Account>

}