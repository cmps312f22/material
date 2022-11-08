package com.example.simpleretrofitapp.data.remote.api

import android.accounts.Account

interface AccountApi {
    fun getAccounts() : List<Account>

}