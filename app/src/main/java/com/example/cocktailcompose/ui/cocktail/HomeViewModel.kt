package com.example.cocktailcompose.ui.cocktail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cocktailcompose.data.model.DrinkModelX
import com.example.cocktailcompose.data.model.NewDrinkModel
import com.example.cocktailcompose.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
     val repository: Repository
) : ViewModel() {
    //MutableStateFlow that represents the state of the fetched data.
    private val _drinksList: MutableStateFlow<List<DrinkModelX>> = MutableStateFlow(emptyList())
    val drinksList: StateFlow<List<DrinkModelX>> = _drinksList

    init {
        getBaseUrl()
    }
   // (viewModelScope.launch) to launch a coroutine that fetches data from the API
   // using the getBase_Url function defined in the Repository class.
     fun getBaseUrl() {
        viewModelScope.launch {
            val response = repository.getBase_Url() //  API call function
            //_drinksList.value = listOf(repository.getBase_Url())// Update the state of  data
            _drinksList.value = response.drinks!!
        }


           }
       }


