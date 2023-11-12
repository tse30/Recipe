package com.example.recipe.data.network

import com.example.recipe.data.model.Meal
import com.example.recipe.data.model.MealList
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json

object MealApiClient {
    private const val BASE_URL = "https://www.themealdb.com/api/json/v1/1"

    private val apiClient = HttpClient(Android) {
        install(ContentNegotiation) {
            json()
        }
    }

    suspend fun getRandomRecipe(): List<Meal> {
        val url = "$BASE_URL/random.php"
        val response = apiClient.get(url).body() as MealList
        return response.meals
    }

    suspend fun getSearchedRecipe(query: String): List<Meal> {
        val url = "$BASE_URL/search.php?s=$query"
        val response = apiClient.get(url).body() as MealList
        return response.meals
    }

}