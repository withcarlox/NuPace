package com.app.nupace

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.app.sprintspace.R
import kotlin.math.roundToInt

class PaceCalculator : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pace_calculator)

        val btnCalcResult : TextView = findViewById(R.id.btn_calc_result)

        btnCalcResult.setOnClickListener {
            val distanceKm = findViewById<EditText>(R.id.edt_km).text.toString()
            val timeMinutes = findViewById<EditText>(R.id.edittext_tempo).text.toString()

            if (distanceKm.isEmpty() || timeMinutes.isEmpty()){
                showToastIfFieldsIsNotCompleted()
            } else{
                val getFinalDistanceInKm = distanceKm.toDouble()
                val getFinalTimeInMinutes = timeMinutes.toDouble()
                paceCalc(getFinalDistanceInKm, getFinalTimeInMinutes)

                val intent = PaceResult.start(this, timeFormatted(paceCalc(getFinalDistanceInKm,getFinalTimeInMinutes)))
                startActivity(intent)
            }
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
    private fun showToastIfFieldsIsNotCompleted(){
        val messageIfFieldIsEmpty = "Preencha todos os campos!"
        val duration = Toast.LENGTH_SHORT
        val error = Toast.makeText(this, messageIfFieldIsEmpty, duration)
        error.show()
    }
}