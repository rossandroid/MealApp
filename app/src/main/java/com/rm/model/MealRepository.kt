package com.rm.model

import com.rm.model.api.ApiManager
import com.rm.model.response.MealCategoriesResponses
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MealRepository(private val webService: ApiManager = ApiManager()) {
    fun getMeals(successCalback: (response: MealCategoriesResponses?) -> Unit) {
        return webService.getMeals().enqueue(object : Callback<MealCategoriesResponses>{
            override fun onResponse(
                call: Call<MealCategoriesResponses>,
                response: Response<MealCategoriesResponses>
            ) {
                if(response.isSuccessful)
                    successCalback(response.body())
            }

            override fun onFailure(call: Call<MealCategoriesResponses>, t: Throwable) {

            }
        })
    }
}