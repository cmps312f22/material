package com.example.projecttracker.viewmodel

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class AuthViewModel(application: Application) : AndroidViewModel(application) {
    val TAG = "AuthViewModel"
    private val auth by lazy { FirebaseAuth.getInstance() }
    var user by mutableStateOf(auth.currentUser)
        private set

    fun signInWithEmailAndPassWord(email: String, password: String) =
        viewModelScope.launch(Dispatchers.IO) {
            val authResult = auth.signInWithEmailAndPassword(email, password).await()
            user = if (authResult.user != null) authResult.user else null

        }

    fun signOut() = auth.signOut().also {
        user = auth.currentUser
    }

    fun resetPassword(email: String)  = auth.sendPasswordResetEmail(email)
}



