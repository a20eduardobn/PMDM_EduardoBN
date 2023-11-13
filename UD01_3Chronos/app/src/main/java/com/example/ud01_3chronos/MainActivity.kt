package com.example.ud01_3chronos

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.widget.Button
import android.widget.Chronometer
import com.example.ud01_3chronos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var chrono: Chronometer
    var running=false
    var offset = 0L
    val RUNNING_KEY= "running"
    val OFFSET_KEY= "offset"
    val BASE_KEY= "base"
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        chrono= binding.myChrono
        if (savedInstanceState!=null){
            offset= savedInstanceState.getLong(OFFSET_KEY)
            running= savedInstanceState.getBoolean(RUNNING_KEY)

            if (running){
                chrono.base= savedInstanceState.getLong(BASE_KEY)
                chrono.start()
            } else {
                chrono.base= SystemClock.elapsedRealtime()- offset
            }

        }

        binding.BotonStart.setOnClickListener {
            if (!running){
                chrono.base = SystemClock.elapsedRealtime()-offset
                chrono.start()
                running=true
            }
        }

        binding.BotonPause.setOnClickListener {
            if (running){
                offset= SystemClock.elapsedRealtime()-chrono.base
                chrono.stop()
                running=false
            }
        }

        binding.BotonRestart.setOnClickListener {
            offset=0L
            chrono.base = SystemClock.elapsedRealtime()
        }
    }
    override fun onSaveInstanceState(outState: Bundle) {
        outState.putBoolean(RUNNING_KEY,running)
        outState.putLong(OFFSET_KEY,offset)
        outState.putLong(BASE_KEY,chrono.base)
        super.onSaveInstanceState(outState)
    }

    override fun onStop() {
        stopChrono()
        super.onStop()
    }

    override fun onRestart() {
        startChrono()
        super.onRestart()
    }

    override fun onPause() {
        stopChrono()
        super.onPause()
    }

    override fun onResume() {
        startChrono()
        super.onResume()
    }

    fun stopChrono(){
        if (running){
            offset= SystemClock.elapsedRealtime()-chrono.base
            chrono.stop()
        }
    }

    fun startChrono(){
        if (running){
            chrono.base = SystemClock.elapsedRealtime()-offset
            chrono.start();
        }
    }
}