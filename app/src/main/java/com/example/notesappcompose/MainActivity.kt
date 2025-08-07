 package com.example.notesappcompose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.notesappcompose.Screens.ListScreen
import com.example.notesappcompose.Screens.QuoteScreen
import com.example.notesappcompose.ui.theme.NotesAppComposeTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

 class MainActivity : ComponentActivity() {
    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            CoroutineScope(Dispatchers.IO).launch {
                DataManager.loadAssetsFromFile(applicationContext)
            }

                App()

            }
        }
    }

@Composable
fun App(){
if(DataManager.isDataLoaded.value){
    if(DataManager.currentPage.value== Pages.LISTING){
        ListScreen(DataManager.data){
            DataManager.switchPages(it)
        }

    }else{
        DataManager.currentQuote?.let { QuoteScreen(it) }
    }
}
}

 enum class Pages{
     LISTING,
     DETAIL
 }



