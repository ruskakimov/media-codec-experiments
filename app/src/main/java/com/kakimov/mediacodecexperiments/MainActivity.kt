package com.kakimov.mediacodecexperiments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import java.time.LocalTime

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun currentTimeString(): String {
        val time = LocalTime.now()
        return time.toString()
    }
}