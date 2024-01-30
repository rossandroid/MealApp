package com.rm.model

import com.rm.model.response.MealCategoriesResponses

class MealRepository {
    fun getMeals(): MealCategoriesResponses = MealCategoriesResponses(arrayListOf())
}