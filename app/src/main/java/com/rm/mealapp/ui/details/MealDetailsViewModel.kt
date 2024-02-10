package com.rm.mealapp.ui.details

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.rm.model.MealRepository
import com.rm.model.response.MealResponse

class MealDetailsViewModel (
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val repository: MealRepository = MealRepository.getInstance()

    var mealState = mutableStateOf<MealResponse?>(null)

    init {
        val mealId = savedStateHandle.get<String>("meal_category_id") ?: ""
        mealState.value = repository.getMeal(mealId)
    }
}