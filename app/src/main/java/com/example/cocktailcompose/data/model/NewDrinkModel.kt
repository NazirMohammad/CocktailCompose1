package com.example.cocktailcompose.data.model


import com.google.gson.annotations.SerializedName

data class NewDrinkModel(
    @SerializedName("drinks")
    val drinks: List<DrinkModelX>? = listOf()
)