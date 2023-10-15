package com.example.android.basiccompose

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MainScreenViewModel:ViewModel() {

    var count by  mutableStateOf(0)

    fun increment(){
        ++count
    }

}