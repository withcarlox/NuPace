package com.app.nupace

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.Button
import android.widget.EditText
import com.app.sprintspace.R

class PaceCalculator : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pace_calculator)

        val btnCalcResult = findViewById<Button>(R.id.btn_calc_result)
        val edtKm = findViewById<EditText>(R.id.edt_km)
        val edtTime: EditText = findViewById(R.id.edittext_tempo)


        btnCalcResult.setOnClickListener {

            val distanceKm = edtKm.text.toString().toFloat()
            val timeMinutes = edtTime.text.toString().toFloat()

            val paceMinutesByKm = paceCalc(distanceKm, timeMinutes )
            val paceFormatted = timeFormatted(paceMinutesByKm)

        }
    }
    private fun paceCalc(distanceKm: Float, timeMinutes: Float): Float {
        return timeMinutes / distanceKm
    }

    private fun timeFormatted(pace: Float): String {
        val minutes = pace.toInt()
        val seconds = Math.round((pace - minutes) * 60)

        return String.format("%02d:%02d", minutes, seconds)
    }

}