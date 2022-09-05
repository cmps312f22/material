package com.msms.scaffoldsession0.views.composabledemo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.Icons.Filled
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.*
import androidx.compose.ui.unit.dp

@Composable
fun TextFieldsDemo(){
    var text1 by rememberSaveable { mutableStateOf("") }
    var text2 by rememberSaveable { mutableStateOf("") }
    var text3 by rememberSaveable { mutableStateOf("") }
    var text4 by rememberSaveable { mutableStateOf("") }
    var text5 by rememberSaveable { mutableStateOf("") }
    var text6 by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var passwordHidden by rememberSaveable { mutableStateOf(true) }

    val onValueChange1: (String) -> Unit = {text1=it}
    val onValueChange2: (String) -> Unit = {text2=it}
    val onValueChange3: (String) -> Unit = {text3=it}
    val onValueChange4: (String) -> Unit = {text4=it}
    val onValueChange5: (String) -> Unit = {text5=it}
    val onValueChange6: (String) -> Unit = {text6=it}
    val onPasswordChange: (String) -> Unit = {password=it}
    val onPasswordHiddenClick: () -> Unit = {passwordHidden =!passwordHidden}


    TextFieldsDemoContent(
        text1=text1,
        onValueChange1 = onValueChange1,
        text2=text2,
        onValueChange2 = onValueChange2,
        text3=text3,
        onValueChange3 = onValueChange3,
        text4=text4,
        onValueChange4 = onValueChange4,
        text5=text5,
        onValueChange5 = onValueChange5,
        text6=text6,
        onValueChange6 = onValueChange6,
        password=password,
        onPasswordChange = onPasswordChange,
        passwordHidden=passwordHidden,
        onPasswordHiddenClick=onPasswordHiddenClick
    )
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun TextFieldsDemoContent(
    text1: String,
    onValueChange1: (String) -> Unit,
    text2: String,
    onValueChange2: (String) -> Unit,
    text3: String,
    onValueChange3: (String) -> Unit,
    text4: String,
    onValueChange4: (String) -> Unit,
    text5: String,
    onValueChange5: (String) -> Unit,
    text6: String,
    onValueChange6: (String) -> Unit,
    password: String,
    onPasswordChange: (String) -> Unit,
    passwordHidden: Boolean,
    onPasswordHiddenClick: () -> Unit
){
    Column{
         TextField(
            value = text1,
            onValueChange = onValueChange1,
            label = { Text("Label") },
            singleLine = true
        )

        TextField(
            value = text2,
            onValueChange = onValueChange2,
            label = { Text("Email") },
            placeholder = { Text("example@gmail.com") }
        )

        TextField(
            value = text3,
            onValueChange = onValueChange3,
            placeholder = { Text("placeholder") },
            leadingIcon = { Icon(Filled.Favorite, contentDescription = "Localized description") },
            trailingIcon = { Icon(Filled.Info, contentDescription = "Localized description") }
        )

        TextField(
            value = text4,
            onValueChange = onValueChange4,
            label = { Text("Label") }
        )
        Text(
            text = "Helper message",
            color = MaterialTheme.colors.onSurface.copy(alpha = ContentAlpha.medium),
            style = MaterialTheme.typography.caption,
            modifier = Modifier.padding(start = 16.dp)
        )

        OutlinedTextField(
            value = text5,
            onValueChange = onValueChange5,
            label = { Text("Label") }
        )
        TextField(
            value = password,
            onValueChange = onPasswordChange,
            singleLine = true,
            label = { Text("Enter password") },
            visualTransformation =
            if (passwordHidden) PasswordVisualTransformation() else VisualTransformation.None,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                IconButton(onClick = onPasswordHiddenClick) {
                    val visibilityIcon =
                        if (passwordHidden) Filled.Visibility else Filled.VisibilityOff
                    // Please provide localized description for accessibility services
                    val description = if (passwordHidden) "Show password" else "Hide password"
                    Icon(imageVector = visibilityIcon, contentDescription = description)
                }
            }
        )
        val keyboardController = LocalSoftwareKeyboardController.current
        TextField(
            value = text6,
            onValueChange = onValueChange6,
            label = { Text("Label") },
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(
                onDone = {
                    keyboardController?.hide()
                    // do something here
                }
            )
        )
    }
}
