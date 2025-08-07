package com.example.notesappcompose.Screens

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.notesappcompose.Model

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun QuoteListItem(quote:Model,lamda:(quote:Model)->Unit) {
    var isexpand by remember { mutableStateOf(false) }

Card(elevation = CardDefaults.cardElevation(10.dp),
    modifier = Modifier.clickable{lamda(quote)}.padding(8.dp)
        .animateContentSize(tween(300,easing = FastOutSlowInEasing))) {

    Row(modifier = Modifier.padding(16.dp)) {
        Image(imageVector = Icons.Filled.Build,
            colorFilter = ColorFilter.tint(Color.White),
            alignment = Alignment.TopStart,
            contentDescription = "Quote",
            modifier = Modifier
                .size(40.dp)
                .rotate(90F)
                .background(Color.Black))

        Spacer(modifier = Modifier.padding(4.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(
                text= quote.quoteText,
                maxLines =  if (isexpand) Int.MAX_VALUE else 1,

                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(0.dp,0.dp,0.dp,8.dp)
            )

            Box(modifier = Modifier
                .background(Color.DarkGray)
                .fillMaxWidth(.4f)
                .height(1.dp))

            Text(
                text = quote.quoteAuthor,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.ExtraLight,
                modifier = Modifier.padding(top=4.dp)
            )

        }
        IconButton(onClick = {isexpand = !isexpand}) {
            Icon(imageVector = if(isexpand) Icons.Filled.KeyboardArrowUp
            else Icons.Filled.KeyboardArrowDown,
                contentDescription = "Expanded and  Collapsed")
        }


    }
} }

/*@Composable
fun ExpandableCard(title: String, expandedContent: @Composable () -> Unit) {
    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { expanded = !expanded },
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = title, style = MaterialTheme.typography.titleMedium)
                Icon(
                    imageVector = if (expanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                    contentDescription = null
                )
            }

            AnimatedVisibility(visible = expanded) {
                expandedContent()
            }
        }
    }
}*/

@Preview
@Composable
fun Preview() {
    QuoteListItem(Model("Don't believe too much, because behavior changes with time" +
            "hjvjhvhjvhjhvjvhjvhjvjhvjvjhvvvhvhjvhvj", "Dinesh")) {

//    ExpandableCard("Don't belive yourself",{})
    }
}





