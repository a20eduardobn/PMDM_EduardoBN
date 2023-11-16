package com.example.ud6_3guessgame

import androidx.lifecycle.ViewModel
class GameViewModel: ViewModel() {

    val words= listOf<String>("Android","Fragment", "Kotlin", "Model")
    var secretWord = words.random().uppercase()
}