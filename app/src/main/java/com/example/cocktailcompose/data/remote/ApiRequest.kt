package com.example.cocktailmynewproject.data.remote

import com.example.cocktailcompose.data.model.DrinkModelX
import com.example.cocktailcompose.data.model.NewDrinkModel
import retrofit2.http.GET

interface ApiRequest {
    @GET(ApiDetail.coktail)
    suspend fun getBase_Url(): NewDrinkModel
}