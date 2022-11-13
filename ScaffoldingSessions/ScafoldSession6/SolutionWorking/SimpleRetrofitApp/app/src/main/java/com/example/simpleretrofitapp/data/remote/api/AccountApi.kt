package com.example.simpleretrofitapp.data.remote.api

import com.example.simpleretrofitapp.data.model.Account
import com.example.simpleretrofitapp.data.model.Company
import retrofit2.http.*
//GET : get data from server
//POST : send data to server
//PUT : update data on server
//DELETE : delete data from server
//TODO 2 : Create an interface for the API requests
interface AccountApi {

   @GET("accounts")
   suspend fun getAccounts() : List<Account>
   /*
      @POST("/accounts")
      fun addAccount(account: Account) : Account

      @PUT("/accounts/{id}")
      fun updateAccount(@Path ("id") id : Int , @Body account: Account) : Account

      @DELETE("/accounts/{id}")
      fun updateAccount(@Path ("id") id : Int) : Int
   */


}