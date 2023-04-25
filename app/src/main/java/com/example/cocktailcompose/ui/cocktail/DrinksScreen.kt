package com.example.cocktailcompose.ui.cocktail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.example.cocktailcompose.data.model.DrinkModelX
import com.example.cocktailcompose.data.model.NewDrinkModel
import kotlinx.coroutines.flow.observeOn


@Composable
fun DrinksScreen(

    mainScreenViewModel: HomeViewModel = hiltViewModel()

){

    // Collect the state of drinksList from the viewModel
    val drinksList by mainScreenViewModel.drinksList.collectAsState()

// Call getBaseUrl() when the composable is first launched
    LaunchedEffect(Unit) {
        mainScreenViewModel.getBaseUrl()
    }
// Render the list of drinks using LazyColumn


    LazyColumn{

        items(drinksList){drink ->
            DrinkItem(drink)

        }

        }
    }



@Composable
fun DrinkItem(drink: DrinkModelX) {
    // wrapping the row with a Surface instead /

        Row(
            modifier = Modifier
                .fillMaxSize()
                .height(100.dp)

                .wrapContentSize(align = Alignment.Center),

            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = rememberAsyncImagePainter("${drink.strDrinkThumb}"),
                contentDescription = null,
                modifier = Modifier
                    .size(height = 90.dp, width = 60.dp)
                    .weight(0.5f)
                    .padding(5.dp)
            )
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 10.dp)
                    .align(alignment = Alignment.CenterVertically)
                    .wrapContentSize(align = Alignment.Center)
            ) {
                Text(

                    text = "${drink.strDrink}",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,

                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Text(
                    text = "${drink.strCategory}",
                    color = Color.Black,
                    fontSize = 16.sp,
                    maxLines = 1,
                    textAlign = TextAlign.Center,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }










