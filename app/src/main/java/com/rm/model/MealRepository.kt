package com.rm.model

import com.rm.model.api.ApiManager
import com.rm.model.response.MealCategoriesResponses


class MealRepository(private val webService: ApiManager = ApiManager()) {
    suspend fun getMeals(): MealCategoriesResponses {
        return webService.getMeals()
    }
}