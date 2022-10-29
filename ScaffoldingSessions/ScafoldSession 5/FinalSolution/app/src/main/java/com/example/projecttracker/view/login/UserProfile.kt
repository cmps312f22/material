package com.example.projecttracker.view.home

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.firebase.auth.FirebaseAuth

@Composable
fun UserProfile(signOut: () -> Unit) {
    Card(
        elevation = 10.dp,
        modifier = Modifier
            .padding(10.dp)
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .padding(15.dp),
        ) {
            Text(
                text = "SignOut",
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp,
                modifier = Modifier
                    .clickable {
                        signOut()
                        Log.d("Sign Out", "Sign Out: ")
                    }
            )
            Spacer(
                modifier = Modifier
                    .weight(1f)
            )
            Text(text = "Logged In \n ${FirebaseAuth.getInstance().currentUser?.email}")
        }

    }
}