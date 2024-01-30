package com.rm.mealapp.ui.meal

import androidx.lifecycle.ViewModel
import com.rm.model.MealRepository
import com.rm.model.response.MealResponse

class MealCategoriesViewModel (private val repository: MealRepository = MealRepository()): ViewModel() {
    fun getMealList(): List<MealResponse>{
        return repository.getMeals().categories
    }
}