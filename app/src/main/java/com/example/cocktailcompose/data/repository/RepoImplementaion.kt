package com.example.cocktailmynewproject.data.repository

import com.example.cocktailcompose.data.model.DrinkModelX
import com.example.cocktailcompose.data.model.NewDrinkModel
import com.example.cocktailcompose.data.repository.Repository
import com.example.cocktailmynewproject.data.remote.ApiRequest
import javax.inject.Inject

class RepoImplementaion @Inject constructor(
    val apiRequest: ApiRequest
): Repository {

    override suspend fun getBase_Url(): NewDrinkModel = apiRequest.getBase_Url()

    }



