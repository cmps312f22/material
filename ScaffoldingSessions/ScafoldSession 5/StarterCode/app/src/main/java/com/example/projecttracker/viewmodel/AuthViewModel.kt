package com.example.projecttracker.viewmodel

import android.app.Application
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AuthViewModel(application: Application) : AndroidViewModel(application) {

//    val TAG = "AuthViewModel"
//    private val auth by lazy { FirebaseAuth.getInstance() }
//
//    var user by mutableStateOf(auth.currentUser)
//        private set

    fun signInWithEmailAndPassWord(email: String, password: String) =
//        viewModelScope.launch(Dispatchers.IO) {
//            auth.signInWithEmailAndPassword(email, password)
//                .addOnCompleteListener { task ->
//                    if (task.isSuccessful) {
//                        user = auth.currentUser
//                        Log.w(TAG, "signInWithEmail:success")
//                    } else
//                        Log.w(TAG, "signInWithEmail:failure", task.exception)
//                }
//        }

    fun signOut() {
//        FirebaseAuth.getInstance().signOut()
//        user = auth.currentUser
    }

    fun resetPassword(email: String) {
//        FirebaseAuth.getInstance().sendPasswordResetEmail(email)
    }

}



