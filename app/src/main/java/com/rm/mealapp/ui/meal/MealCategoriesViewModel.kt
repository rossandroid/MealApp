package com.rm.mealapp.ui.meal

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rm.model.MealRepository
import com.rm.model.response.MealResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MealCategoriesViewModel (private val repository: MealRepository = MealRepository.getInstance()): ViewModel() {

    init{
        viewModelScope.launch(Dispatchers.IO) {
            val meals = getMealList()
            mealsState.value = meals
        }

    }

    val mealsState: MutableState<List<MealResponse>> =  mutableStateOf(emptyList<MealResponse>())

    private suspend fun getMealList(): List<MealResponse>{
        return repository.getMeals().categories
    }

}