package com.kakimov.mediacodecexperiments

import android.media.MediaCodec
import android.media.MediaCodecList
import android.media.MediaFormat
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.time.LocalTime
import java.util.*
import kotlin.concurrent.fixedRateTimer

class MainActivity : AppCompatActivity() {

    lateinit var digitalClockView: TextView

    lateinit var timer: Timer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        digitalClockView = findViewById(R.id.digital_clock)

        timer = fixedRateTimer("clock", false, 0L, 1000L) {
            this@MainActivity.runOnUiThread {
                digitalClockView.text = currentTimeString()
            }
        }

        val videoFormat = MediaFormat.createVideoFormat("video/avc", 1920, 1080)
        val codecName = MediaCodecList(MediaCodecList.REGULAR_CODECS).findEncoderForFormat(videoFormat)

        Log.i("CODEC", "codec name: $codecName")

        if (codecName != null) {
            val codec = MediaCodec.createByCodecName(codecName)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        timer.cancel()
    }

    fun currentTimeString(): String {
        val time = LocalTime.now()
        return time.toString()
    }
}