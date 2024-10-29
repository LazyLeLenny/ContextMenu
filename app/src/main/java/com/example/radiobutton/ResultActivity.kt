package com.example.radiobutton

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultActivity : AppCompatActivity() {
    private lateinit var resultTV : TextView
    private lateinit var resultDescTV : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        resultTV = findViewById(R.id.resultTV)
        resultDescTV = findViewById(R.id.resultDescTV)

        resultTV.text = "Ваш балл:\n${intent.getIntExtra("resultFinal", 0)}"
        resultDescTV.text =
            when(intent.getIntExtra("resultFinal", 0)) {
                500 -> "Ваша оценка: отлично\n Поздравляю! Вы отлично знаете историю России XIX века."
                400 -> "Ваша оценка: хорошо\n Вы знаете многие исторические факты, но вам есть что изучить!"
                300 -> "Ваша оценка: удовлетворительно\n Вам определённо интересна история, но многое ещё предстоит узнать!"
                200 -> "Ваша оценка: неудовлетворительно\n Вас нельзя назвать человеком хорошо знающим историю :)"
                in 0..100 -> "Ваша оценка: плохо\n Полагаю, вы открыли не ту викторину XD"
                else -> {""}
            }
    }
}