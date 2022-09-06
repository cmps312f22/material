package com.msms.scaffoldsession1.views

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import com.msms.scaffoldsession1.models.Breed
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter.State.Empty.painter
import coil.compose.rememberAsyncImagePainter
import com.msms.scaffoldsession1.R

@Composable
fun BreedCard(breed: Breed) {
    Card(
        backgroundColor = Color.LightGray,
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(CornerSize(10.dp)),
        elevation = 18.dp
    ) {
        Row(modifier = Modifier.padding(8.dp)
        ) {
            Image(
//            painter = painterResource(R.drawable.cat) , contentDescription = "Cat Image",
            painter = rememberAsyncImagePainter(breed.image.url), contentDescription = "Cat Image",

            modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .border(1.5.dp,MaterialTheme.colors.secondaryVariant, CircleShape)
            )
            Spacer(modifier = Modifier.padding(8.dp))
            var isExpanded by remember { mutableStateOf(false) }
            val surfaceColor by animateColorAsState(targetValue = if (isExpanded) MaterialTheme.colors.primary else MaterialTheme.colors.surface)
            Column {
                Text(
                    text = "Name: ${breed.name}",
                    color = MaterialTheme.colors.secondaryVariant,
                    style = MaterialTheme.typography.subtitle1
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Origin: ${breed.origin}",
                    style = MaterialTheme.typography.subtitle2
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Wikipedia: ${breed.wikipedia_url}",
                    style = MaterialTheme.typography.subtitle2
                )
                Spacer(modifier = Modifier.height(4.dp))
                Surface(
                    shape = MaterialTheme.shapes.medium,
                    color = surfaceColor,
                    modifier = Modifier
                        .animateContentSize()
                        .padding(1.dp)
                        .clickable { isExpanded = !isExpanded }
                ) {
                    Text(
                        text = "Description: ${breed.description}",
                        modifier = Modifier.padding(4.dp),
                        maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.body2
                    )
                }
            }
        }
    }
}
