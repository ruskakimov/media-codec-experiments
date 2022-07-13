package com.kakimov.mediacodecexperiments

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.time.LocalTime

class MainActivity : AppCompatActivity() {

    lateinit var digitalClockView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        digitalClockView = findViewById(R.id.digital_clock)
    }

    fun currentTimeString(): String {
        val time = LocalTime.now()
        return time.toString()
    }
}