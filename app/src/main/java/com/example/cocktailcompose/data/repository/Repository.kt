package com.example.cocktailcompose.data.repository

import com.example.cocktailcompose.data.model.DrinkModelX
import com.example.cocktailcompose.data.model.NewDrinkModel

interface Repository {
   // Repository class that uses Retrofit  to fetch data from  API.
    suspend fun getBase_Url(): NewDrinkModel
}