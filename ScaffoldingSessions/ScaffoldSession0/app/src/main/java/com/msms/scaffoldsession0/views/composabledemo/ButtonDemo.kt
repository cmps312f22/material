package com.msms.scaffoldsession0.views.composabledemo

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue

/*
The concept of stateful and stateless composable
The concept of state hoisting
 */

@Composable
fun ButtonDemo() {
    Column {
//        var clicked = false
//        var message = "Click me"
        var clicked by rememberSaveable { mutableStateOf(false) }
        var message  by rememberSaveable { mutableStateOf("Click me") }
        Button(
            onClick = {
                clicked = !clicked
                message = if (clicked) "You clicked me" else "Click me"
            }
        ) {
            Text(text = message)
        }
    }
}

@Composable
fun ButtonDemo1() {
    var clicked by rememberSaveable { mutableStateOf(false) }
    var message by rememberSaveable { mutableStateOf("Click me") }

    fun onClick(): Unit {
        clicked = !clicked
        message = if (clicked) "You clicked me" else "Click me"
    }
    val onClick: () -> Unit = {
        clicked = !clicked
        message = if (clicked) "You clicked me" else "Click me"
    }
//    val onClick = {
//        clicked = !clicked
//        message = if (clicked) "You clicked me" else "Click me"
//    }


    ButtonDemo1Content(
        message = message,
//        onClick = ::onClick,
//        onClick = onClick,
        onClick = {
            clicked = !clicked
            message = if (clicked) "You clicked me" else "Click me"
        }
    )
}

@Composable
fun ButtonDemo1Content(message: String, onClick: () -> Unit) {
    Column {
        Button(
            onClick = onClick
        ) {
            Text(text = message)
        }
    }
}