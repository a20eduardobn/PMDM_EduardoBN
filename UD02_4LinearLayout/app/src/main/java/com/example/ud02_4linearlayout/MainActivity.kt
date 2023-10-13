package com.example.ud02_4linearlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.ud02_4linearlayout.R.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)
        val buttonCallAction = findViewById<Button>(id.buttonCall)
        val textLlamada = findViewById<TextView>(id.textCall)

        buttonCallAction.setOnClickListener {
            textLlamada.text=
                getString(R.string.llamadaText)+findViewById<TextView>(id.nombreContacto).text.toString()
        }
    }
}