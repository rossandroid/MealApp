package com.rm.mealapp.ui.details

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.rm.model.response.MealResponse

@Composable
fun MealDetailsScreen(meal: MealResponse?) {
    var profilePictureState by remember { mutableStateOf(MealProfilePictureState.Normal) }
    val transition = updateTransition(targetState = profilePictureState, label = "" )
    val imageSizeDp: Dp by transition.animateDp(targetValueByState = {it.size}, label = "")
    val imageColor: Color by transition.animateColor(targetValueByState = {it.color}, label= "")
    val imageWidth: Dp by transition.animateDp(targetValueByState = {it.borderWidth}, label = "")

    Column {
            Card(
                modifier = Modifier
                    .padding(16.dp),
                shape = CircleShape,
                border = BorderStroke(
                    width = imageWidth,
                    color = imageColor
                )
            ) {
                Image(
                    painter = rememberAsyncImagePainter(
                        ImageRequest.Builder(LocalContext.current).data(data = meal?.imageUrl)
                            .apply(block = fun ImageRequest.Builder.() {
                                transformations(CircleCropTransformation())
                            }).build()
                    ),
                    contentDescription = null,
                    modifier = Modifier
                        .size(imageSizeDp)
                        .padding(8.dp)
                )
            }
            Text(text = if(profilePictureState == MealProfilePictureState.Normal)
                meal?.name?: "default name"
                    else
                        meal?.description ?: "default description",
                modifier = Modifier
                    .padding(16.dp))

        Button(onClick = {
            profilePictureState = if(profilePictureState == MealProfilePictureState.Normal)
                MealProfilePictureState.Expanded
            else
                MealProfilePictureState.Normal
                         },
            modifier = Modifier
                .padding(16.dp)) {
            Text(if(profilePictureState == MealProfilePictureState.Normal)
               "Show More"
            else
                "Show Less")
        }
    }
}

enum class MealProfilePictureState(val color: Color, val size: Dp, val borderWidth:Dp){
    Normal(Color.Gray, 120.dp, 8.dp),
    Expanded(Color.DarkGray,200.dp, 24.dp )
}