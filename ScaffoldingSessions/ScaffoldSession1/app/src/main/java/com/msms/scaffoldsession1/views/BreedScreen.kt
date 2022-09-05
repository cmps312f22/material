package com.msms.scaffoldsession1.views

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.platform.LocalContext
import com.msms.scaffoldsession1.models.Breed
import com.msms.scaffoldsession1.models.BreedRepository

@Composable
fun BreedScreen() {
    val breeds = BreedRepository.getBreeds(LocalContext.current)
    var _breeds = rememberSaveable { mutableListOf(breeds) }
    BreedScreenContents(breeds)
}

@Composable
fun BreedScreenContents(breeds: List<Breed>) {

    if (breeds.isEmpty()) {
        Text("Loading stadiums failed.")
    } else {
        LazyColumn {
            items(breeds) {
                BreedCard(it)
            }
        }
    }
}

