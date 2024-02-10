package com.rm.model

import com.rm.model.api.ApiManager
import com.rm.model.response.MealCategoriesResponses
import com.rm.model.response.MealResponse

class MealRepository(private val webService: ApiManager = ApiManager()) {

    private var cachedMeals = listOf<MealResponse>()
    suspend fun getMeals(): MealCategoriesResponses {
        val response = webService.getMeals()
        cachedMeals = response.categories
        return response
    }

    fun getMeal(id: String): MealResponse? {
        return cachedMeals.firstOrNull {
            it.id == id
        }
    }

    companion object {
        @Volatile
        private var instance: MealRepository? = null

        fun getInstance() = instance?: synchronized(this) {
            instance ?: MealRepository().also { instance = it }
        }
    }
}