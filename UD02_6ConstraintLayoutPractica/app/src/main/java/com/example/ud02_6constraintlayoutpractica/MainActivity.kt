package com.example.ud02_6constraintlayoutpractica

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val texto = findViewById<TextView>(R.id.infoResultado)
        val boton = findViewById<Button>(R.id.botonAceptar)
        val usuarioTexto = findViewById<EditText>(R.id.campoUsuario)
        val usuarioContr = findViewById<EditText>(R.id.campoContraseña)

        boton.setOnClickListener {
            val miString=getString(R.string.infoUsuario)+usuarioTexto.text.toString()+getString(R.string.infoPasswd)+usuarioContr.text.toString()
            val stringFinal = SpannableString(miString)
            stringFinal.setSpan(UnderlineSpan(), 0, stringFinal.length, 0)
            texto.text = stringFinal
        }
    }
}