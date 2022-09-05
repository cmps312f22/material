package com.msms.scaffoldsession0.views.composabledemo

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

@Composable
fun ButtonsDemo() {
    var clicked by rememberSaveable { mutableStateOf(false) }
    var clickedLike by rememberSaveable { mutableStateOf(false) }
    var message by rememberSaveable { mutableStateOf("Click me") }


    val onClickLike = {
        clickedLike = !clickedLike
    }
    var checked: Boolean by remember { mutableStateOf(false) }
//    fun onCheckedChange(status: Boolean): Unit {
//        checked = status
//    }
//    val onCheckedChange: (Boolean) -> Unit = { status: Boolean -> checked = status}
//    val onCheckedChange: (Boolean) -> Unit = { status -> checked = status }
    val onCheckedChange: (Boolean) -> Unit = { checked = it}
//    val onCheckedChange = { status: Boolean -> checked = status}

    ButtonsDemoContent(
        message = message,
        onClick = {
            clicked = !clicked
            message = if (clicked) "You clicked me" else "Click me"
        },
        onClickLike = {
            clickedLike = !clickedLike
        },
        clickedLike = clickedLike,
        checked = checked,
//        onCheckedChange= ::onCheckedChange
        onCheckedChange=onCheckedChange
//        onCheckedChange= {checked = it}
//        onCheckedChange = { status ->
//            checked = status
//        }
    )
}


@Composable
fun ButtonsDemoContent(
    message: String,
    onClick: () -> Unit,
    onClickLike: () -> Unit,
    clickedLike: Boolean,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit

) {
    Column {
        Column {
            Button(
                onClick = onClick
            ) {
                Text(text = message)
            }
        }
        Button(onClick = onClickLike) {
            val tint by animateColorAsState(if (clickedLike) Color(0xFFEC407A) else Color(0xFFB0BEC5))
            Icon(
                Icons.Filled.Favorite,
                contentDescription = null,
                modifier = Modifier.size(ButtonDefaults.IconSize),
                tint = tint
            )
            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
            Text("Like")
        }
        IconButton(onClick = { /* doSomething() */ }) {
            Icon(Icons.Filled.Favorite, contentDescription = "Localized description")
        }
        IconToggleButton(checked = checked, onCheckedChange = onCheckedChange) {
            val tint by animateColorAsState(if (checked) Color(0xFFEC407A) else Color(0xFFB0BEC5))
            Icon(Icons.Filled.Favorite, contentDescription = "Localized description", tint = tint)
        }
        OutlinedButton(onClick = { /* Do something! */ }) {
            Text("Outlined Button")
        }
        TextButton(onClick = { /* Do something! */ }) {
            Text("Text Button")
        }
    }
}