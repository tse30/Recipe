package com.example.recipe.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MealList(
    @SerialName("meals")
    val meals: List<Meal>
)