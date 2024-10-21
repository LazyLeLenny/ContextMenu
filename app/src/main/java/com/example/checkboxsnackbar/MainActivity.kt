package com.example.checkboxsnackbar

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var textET : EditText
    private lateinit var textTV : TextView
    private lateinit var saveBTN : Button
    private lateinit var deleteBTN : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        textET = findViewById(R.id.editTextET)
        textTV = findViewById(R.id.textViewTV)
        saveBTN = findViewById(R.id.SaveBTN)
        deleteBTN = findViewById(R.id.DeleteBTN)
    }

    fun saveOnClick(view: View) {
        textTV.text = textET.text
    }

    fun deleteBTNOnClick(view: View) {
        Snackbar.make(view, "Подтвердите удаление", Snackbar.LENGTH_LONG).setAction("Удалить") {
            textTV.text = ""
            Snackbar.make(view, "Данные удалены", Snackbar.LENGTH_LONG).show()
        }.show()
    }
}