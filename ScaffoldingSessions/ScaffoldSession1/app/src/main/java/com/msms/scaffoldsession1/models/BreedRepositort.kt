package com.msms.scaffoldsession1.models

import android.content.Context
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

object BreedRepository {
    var breeds = listOf<Breed>()
    fun getBreeds(context: Context): List<Breed> {
        if (breeds.isEmpty()) {
            val breedJson = context.assets
                .open("breeds.json")
                .bufferedReader()
                .use{
                    it.readText() }
            breeds = Json.decodeFromString(breedJson)
        }
        return breeds
    }
}