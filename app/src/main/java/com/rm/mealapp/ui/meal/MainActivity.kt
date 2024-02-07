package com.rm.mealapp.ui.meal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

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