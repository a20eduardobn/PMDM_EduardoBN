package com.example.ud6_3guessgame

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {

    val words = listOf("Android", "Fragment", "Kotlin", "Model")
    var secretWord = words.random().uppercase()

    //Palabra que voy a mostrar
    var secretWordDisplay = MutableLiveData<String>()

    //Num de vidas
    var lives = MutableLiveData<Int>(5)

    //Intentos del usuario. Caracteres
    var guesses = mutableListOf<Char>()

    init {
        secretWordDisplay.value = generateWordDisplay()
    }
    fun generateWordDisplay() =
        secretWord.map {
            if (it in guesses) it
            else "_"
        }.joinToString("")

    fun game(guess : Char){
        //Añado caracter a lista de intentos
        guesses.add(guess)
        //Actualizo palabra visible
        secretWordDisplay.value = generateWordDisplay()
        //Actualizando vidas
        if (!secretWord.contains(guess)) lives.value= lives.value?.minus(1)
    }

    fun win() = secretWord.equals(secretWordDisplay)
    fun lost() = (lives.value ?: 0) <= 0

    fun resultMessage()=
        if (win()) "Ganaste, la palabra secreta era $secretWord"
        else "Oops, perdiste. La palabra secreta era $secretWord"


    fun restart(){
        guesses.clear()
        lives.value = 5
        secretWord = words.random().uppercase()
        generateWordDisplay()
    }

}