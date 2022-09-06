package com.msms.scaffoldsession0.views.composabledemo

import android.annotation.SuppressLint
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import kotlinx.coroutines.launch


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ScaffoldDemo() {

    // create a scaffold state, set it to close by default
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))

    // Create a coroutine scope. Opening of Drawer
    // and snackbar should happen in background
    // thread without blocking main thread
    val coroutineScope = rememberCoroutineScope()

    // Scaffold Composable
    Scaffold(

        // pass the scaffold state
        scaffoldState = scaffoldState,

        // pass the topbar we created
        topBar = {
            TopBar(
                // When menu is clicked open the
                // drawer in coroutine scope
                onMenuClicked = {
                    coroutineScope.launch {
                        // to close use -> scaffoldState.drawerState.close()
                        scaffoldState.drawerState.open()
                    }
                },
            )
        },

        // pass the bottomBar we created
        bottomBar = { BottomBar() },

        // pass the drawer
        drawerContent = {
            Drawer()
        },

        floatingActionButton = {
            // Create a floating action button in
            // floatingActionButton parameter of scaffold
            FloatingActionButton(
                onClick = {
                    // When clicked open Snackbar
                    coroutineScope.launch {
                        when (scaffoldState.snackbarHostState.showSnackbar(
                            // Message In the snackbar
                            message = "Snack Bar",
                            actionLabel = "Dismiss",
                        )) {
                            SnackbarResult.Dismissed -> {
                                // do something when
                                // snack bar is dismissed
                            }

                            SnackbarResult.ActionPerformed -> {
                                // when it appears
                            }

                        }
                    }
                },
            ) {
                // Simple Text inside FAB
                Text(text = "X")
            }
        },
        // Pass the body in
        // content parameter
        content ={
            Body()
        }
    )
}

// A function which will receive a
// callback to trigger to opening the drawer
@Composable
fun TopBar(onMenuClicked: () -> Unit) {
    // TopAppBar Composable
    TopAppBar(
        // Provide Title
        title = {
            Text(text = "Scaffold Demo", color = Color.White)
        },
        // Provide the navigation Icon ( Icon on the left to toggle drawer)
        navigationIcon = {
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = "Menu",

                // When clicked trigger onClick
                // Callback to trigger drawer open
                modifier = Modifier.clickable(onClick = onMenuClicked),
                tint = Color.White
            )
        },
        // background color of topAppBar
        backgroundColor = Color(0xFF0F9D58)
    )
}

@Composable
fun BottomBar() {
    // BottomAppBar Composable
    BottomAppBar(
        backgroundColor = Color(0xFF0F9D58)
    ) {
        Text(text = "Bottom App Bar", color = Color.White)
    }
}

@Composable
fun Body() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Text(text = "Body Content", color = Color(0xFF0F9D58))
    }
}


@Composable
fun Drawer() {
    var profileImage by rememberSaveable { mutableStateOf(Uri.parse("")) }
    val galleryLauncher =
        rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) {
            profileImage = it
        }

    // Column Composable
    Column(
        Modifier
            .background(Color.White)
            .fillMaxSize()
    ) {
        // Repeat is a loop which
        // takes count as argument
        Image(
            painter = rememberAsyncImagePainter(profileImage),
            contentScale = ContentScale.Crop,
            contentDescription = null,

            modifier = Modifier
                .padding(16.dp, 8.dp)
                .size(100.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colors.secondaryVariant, CircleShape)
                .clickable {
                    galleryLauncher.launch("image/*")
                }
        )
        Text(text = "Share...", color = Color.Black,
            modifier = Modifier
                .padding(8.dp)
                .clickable {

                }
        )

        repeat(3) { item ->
            Text(text = "Item number $item", modifier = Modifier.padding(8.dp), color = Color.Black)
        }
    }
}
