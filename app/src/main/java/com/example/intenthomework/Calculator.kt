package com.example.intenthomework

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Calculator : AppCompatActivity() {
    private lateinit var firstVarET : EditText
    private lateinit var secondVarBTN : EditText
    private lateinit var plusBTN : Button
    private lateinit var minusBTN : Button
    private lateinit var multBTN : Button
    private lateinit var divideBTN : Button
    private lateinit var dataTransmitBTN : Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_calculator)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        firstVarET = findViewById(R.id.firstVar)
        secondVarBTN = findViewById(R.id.secondVar)
        plusBTN = findViewById(R.id.plusBTN)
        minusBTN = findViewById(R.id.minusBTN)
        multBTN = findViewById(R.id.multBTN)
        divideBTN = findViewById(R.id.divideBTN)
        dataTransmitBTN = findViewById(R.id.dataTransmitBTN)

        var result = 0

        plusBTN.setOnClickListener {
            if (firstVarET.text.isEmpty() || secondVarBTN.text.isEmpty()) {
                Toast.makeText(this, "Введите обе переменные!" , Toast.LENGTH_LONG).show()
            } else result = firstVarET.text.toString().toInt() + secondVarBTN.text.toString().toInt()
        }

        minusBTN.setOnClickListener {
            if (firstVarET.text.isEmpty() || secondVarBTN.text.isEmpty()) {
                Toast.makeText(this, "Введите обе переменные!" , Toast.LENGTH_LONG).show()
            } else result = firstVarET.text.toString().toInt() - secondVarBTN.text.toString().toInt()
        }

        multBTN.setOnClickListener {
            if (firstVarET.text.isEmpty() || secondVarBTN.text.isEmpty()) {
                Toast.makeText(this, "Введите обе переменные!" , Toast.LENGTH_LONG).show()
            } else result = firstVarET.text.toString().toInt() * secondVarBTN.text.toString().toInt()
        }

        divideBTN.setOnClickListener {
            if (firstVarET.text.isEmpty() || secondVarBTN.text.isEmpty()) {
                Toast.makeText(this, "Введите обе переменные!" , Toast.LENGTH_LONG).show()
            } else result = firstVarET.text.toString().toInt() / secondVarBTN.text.toString().toInt()
        }

        dataTransmitBTN.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("result", result)
            startActivity(intent)
        }
    }
}