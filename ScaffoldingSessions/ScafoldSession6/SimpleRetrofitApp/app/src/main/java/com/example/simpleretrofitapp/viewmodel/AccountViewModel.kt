package com.example.simpleretrofitapp.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simpleretrofitapp.data.model.Account
import com.example.simpleretrofitapp.data.remote.repo.AccountRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


//AndroidViewModel
class AccountViewModel : ViewModel() {

    private lateinit var x: List<Account>
    var accounts = MutableStateFlow<List<Account>>(emptyList())
        private set

    init {
        getAccounts()
    }
    private fun getAccounts() = viewModelScope.launch(Dispatchers.IO) {
        val data = withContext(Dispatchers.Default) { AccountRepo.getAccounts()}

        Log.d("TAG", "getAccounts: $data")


    }
}