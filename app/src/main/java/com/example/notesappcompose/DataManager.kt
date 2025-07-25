package com.example.notesappcompose

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.google.gson.Gson

object DataManager {

    var data = emptyArray<Model>()
    var isDataLoaded = mutableStateOf(false)


    suspend fun loadAssetsFromFile(context:Context){
        val inputStream = context.assets.open("quotes.json")
        val size:Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()

        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        data = gson.fromJson(json, Array<Model>::class.java)
        isDataLoaded.value = true
    }
}