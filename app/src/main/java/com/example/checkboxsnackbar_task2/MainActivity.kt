package com.example.checkboxsnackbar_task2

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.CheckBox
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var checkboxCB : CheckBox
    private lateinit var textViewTV : TextView
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        checkboxCB = findViewById(R.id.checkboxCB)
        textViewTV = findViewById(R.id.rulesTV)

        checkboxCB.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                checkboxCB.text = "Правила дорожного движения"
                textViewTV.text = "1. Общие положения\n" +
                        "2. Общие обязанности водителей\n" +
                        "3. Применение специальных сигналов\n" +
                        "4. Обязанности пешеходов\n" +
                        "5. Обязанности пассажиров"
            } else {
                checkboxCB.text = "Информация"
                textViewTV.text = ""
            }
        }
    }
}