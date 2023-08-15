package com.app.nupace

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.app.sprintspace.R

class PaceResult : AppCompatActivity() {
    companion object{
        fun start(context: Context, paceFormatted: String) : Intent{
            return Intent(context, PaceResult::class.java).apply {
                putExtra("EXTRA_PACE_RESULT", paceFormatted)
            }
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pace_result)

        val finalResult = intent.getStringExtra("EXTRA_PACE_RESULT")

       val tvResult= findViewById<TextView>(R.id.tv_result)
        tvResult.text = finalResult.toString()
    }
}