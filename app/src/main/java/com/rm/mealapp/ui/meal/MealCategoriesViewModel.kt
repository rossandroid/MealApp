package com.rm.mealapp.ui.meal

import androidx.lifecycle.ViewModel
import com.rm.model.MealRepository
import com.rm.model.response.MealCategoriesResponses
import com.rm.model.response.MealResponse

class MealCategoriesViewModel (private val repository: MealRepository = MealRepository()): ViewModel() {
    fun getMealList(successCalback: (response: MealCategoriesResponses?) -> Unit){
        return repository.getMeals{ response ->
            successCalback(response)
        }
    }
}