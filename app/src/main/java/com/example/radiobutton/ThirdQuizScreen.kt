package com.example.radiobutton

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ThirdQuizScreen : AppCompatActivity() {
    private var result = 0
    private lateinit var oneRB : RadioButton
    private lateinit var twoRB : RadioButton
    private lateinit var threeRB : RadioButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_third_quiz_screen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        oneRB = findViewById(R.id.oneRB)
        twoRB = findViewById(R.id.twoRB)
        threeRB = findViewById(R.id.threeRB)

        oneRB.setOnClickListener(radioButtonClickListener)
        twoRB.setOnClickListener(radioButtonClickListener)
        threeRB.setOnClickListener(radioButtonClickListener)
    }

    private val radioButtonClickListener =
        View.OnClickListener { view ->
            val radioButton = view as RadioButton
            when(radioButton.id) {
                R.id.twoRB -> {
                    result = intent.getIntExtra("resultTwo", 0) + 100
                    Toast.makeText(this, "Верно! $result", Toast.LENGTH_LONG).show()
                    startActivity(
                        Intent(this, FourthQuizScreen::class.java)
                            .putExtra("resultThree", result))
                } else -> {
                result = intent.getIntExtra("resultTwo", 0)
                Toast.makeText(this, "Неверно!", Toast.LENGTH_LONG).show()
                startActivity(
                    Intent(this, FourthQuizScreen::class.java)
                        .putExtra("resultThree", result))
            }
            }
        }
}