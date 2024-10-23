package com.example.lifecycle

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var inputHeightET : EditText
    private lateinit var inputWeightET : EditText
    private lateinit var countBTN : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        inputHeightET = findViewById(R.id.inputHeightET)
        inputWeightET = findViewById(R.id.inputWeightET)
        countBTN = findViewById(R.id.countBTN)

        countBTN.setOnClickListener {
            val intentHeight = Intent(this, SecondScreen::class.java)
                .putExtra("height", inputHeightET.text.toString())
            val intentWeight = Intent(this, SecondScreen::class.java)
                .putExtra("weight", inputWeightET.text.toString())
            if (inputHeightET.text.isEmpty() || inputWeightET.text.isEmpty()) {
                Toast.makeText(this, "Заполните оба поля!", Toast.LENGTH_LONG).show()
            } else {
                startActivity(intentWeight)
                startActivity(intentHeight)
            }
        }
    }
}