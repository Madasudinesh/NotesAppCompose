package com.example.notesappcompose.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.notesappcompose.Model


@Composable
fun ListScreen(data: Array<Model>, lamda:()->Unit){
    LazyColumn(content ={
        items(data){
       QuoteListItem(it){
            lamda
       }
        }
    } )
}

@Preview( showSystemUi = true)
@Composable
fun Previews(){
    Column(
        modifier = Modifier.height(200.dp)) {

        Text( text = "Quote app",
            modifier = Modifier.padding(PaddingValues(10.dp))
                .height(50.dp)
                .fillMaxWidth(1f),
            textAlign = TextAlign.Center)


        QuoteListItem(Model("Don't believe too much, because behavior changes with time","Dinesh")){
        }
    }
}
