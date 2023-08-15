package com.app.nupace

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.Button
import android.widget.EditText
import com.app.sprintspace.R
import kotlin.math.roundToInt

class PaceCalculator : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pace_calculator)

        val btnCalcResult = findViewById<Button>(R.id.btn_calc_result)

        btnCalcResult.setOnClickListener {

            val distanceKm = findViewById<EditText>(R.id.edt_km).text.toString().toDouble()
            val timeMinutes = findViewById<EditText>(R.id.edittext_tempo).text.toString().toDouble()


            val paceMinutesByKm = paceCalc(distanceKm, timeMinutes )
            val paceFormatted = timeFormatted(paceMinutesByKm)

            val intent = PaceResult.start(this, paceFormatted)
            startActivity(intent)

        }
    }
    private fun paceCalc(distanceKm: Double, timeMinutes: Double): Double {
        return timeMinutes / distanceKm
    }

    private fun timeFormatted(pace: Double): String {
        val minutes = pace.toInt()
        val seconds = ((pace - minutes) * 60).roundToInt()

        return String.format("%02d:%02d", minutes, seconds)
    }

}