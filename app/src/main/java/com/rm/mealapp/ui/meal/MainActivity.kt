package com.rm.mealapp.ui.meal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.rm.mealapp.ui.theme.MealAppTheme

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
    val mealsList = viewModel.getMealList()
    Text(text = "Hello Compose!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MealAppTheme {
        MealCategoriesScreen()
    }
}