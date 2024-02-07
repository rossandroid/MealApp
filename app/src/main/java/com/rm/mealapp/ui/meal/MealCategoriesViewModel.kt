package com.rm.mealapp.ui.meal

import android.util.Log
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rm.model.MealRepository
import com.rm.model.response.MealResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MealCategoriesViewModel (private val repository: MealRepository = MealRepository()): ViewModel() {

    private val mealsJob = Job()
    init{
        Log.d("TAG_COROUTINES", "we are about to launch a coroutine")
        viewModelScope.launch(Dispatchers.IO) {
            Log.d("TAG_COROUTINES", "we have launched a coroutine")
            val meals = getMealList()
            Log.d("TAG_COROUTINES", "we have received the async data")
            mealsState.value = meals
        }
        Log.d("TAG_COROUTINES", "other work")

    }

    val mealsState: MutableState<List<MealResponse>> =  mutableStateOf(emptyList<MealResponse>())
    override fun onCleared() {
        super.onCleared()
        mealsJob.cancel()
    }

    suspend fun getMealList(): List<MealResponse>{
        return repository.getMeals().categories
    }
}