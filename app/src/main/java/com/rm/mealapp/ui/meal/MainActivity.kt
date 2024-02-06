package com.rm.mealapp.ui.meal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.rm.mealapp.ui.theme.MealAppTheme
import com.rm.model.response.MealResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MealAppTheme {
               MealCategoriesScreen()
            }
        }
    }
}

@Composable
fun MealCategoriesScreen() {
    val viewModel: MealCategoriesViewModel = viewModel()
    val rememberedMeals: MutableState<List<MealResponse>> = remember {mutableStateOf(emptyList<MealResponse>())}
    val coroutineScope = rememberCoroutineScope()
    LaunchedEffect(key1 = "GET_MEALS"){
        coroutineScope.launch(Dispatchers.IO) {
            val meals = viewModel.getMealList()
            rememberedMeals.value = meals
        }
    }


    LazyColumn {
        items(rememberedMeals.value) { meal->
            Text(text = meal.name)
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MealAppTheme {
        MealCategoriesScreen()
    }
}