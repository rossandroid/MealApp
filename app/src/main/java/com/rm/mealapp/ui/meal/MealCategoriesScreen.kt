package com.rm.mealapp.ui.meal

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import com.rm.mealapp.ui.theme.MealAppTheme
import com.rm.model.response.MealResponse


@Composable
fun MealCategoriesScreen() {
    val viewModel: MealCategoriesViewModel = viewModel()
    val meals = viewModel.mealsState.value

    LazyColumn(contentPadding = PaddingValues(16.dp)) {
        items(meals) { meal->
            MealCategory(meal)
        }
    }

}
@Composable
fun MealCategory(meal: MealResponse){
    ElevatedCard(shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)) {
        Row {
            Image(painter = rememberAsyncImagePainter(model = meal.imageUrl),
                contentDescription = null,
                modifier = Modifier
                    .size(88.dp)
                    .padding(4.dp))
            Column(modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(16.dp)) {
                Text(text = meal.name,
                    style = MaterialTheme.typography.bodyMedium)
            }
        }

    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MealAppTheme {
        MealCategoriesScreen()
    }
}
