package com.example.notesappcompose.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.notesappcompose.Model

@Composable
fun QuoteScreen(quote:Model){
    Box(contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize(1f)
            .background(Brush.sweepGradient(
                colors = listOf(Color(0xFFF00000),
                    Color(0xFF000000))
            ))) {

        Card(elevation = CardDefaults.cardElevation(7.dp),
            modifier = Modifier.padding(32.dp),
            colors = CardDefaults.cardColors(Color.DarkGray)) {

            Column(verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(16.dp,24.dp)) {
                Image(imageVector = Icons.Filled.Info,
                    colorFilter = ColorFilter.tint(Color.LightGray),
                    contentDescription = "Quote",
                    modifier = Modifier
                        .size(80.dp)
                        .rotate(180F)
                )

                Text(text=quote.quoteText,
                    style = MaterialTheme.typography.titleLarge)

                Spacer(Modifier.height(16.dp))

                Text(
                    text = quote.quoteAuthor,
                    style = MaterialTheme.typography.labelMedium
                )
            }


        }

    }
}

@Preview
@Composable
fun Review(){
    QuoteScreen(Model("Lamdi na koduka","Dinesh"))
}