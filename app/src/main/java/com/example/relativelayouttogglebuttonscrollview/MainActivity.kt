package com.example.relativelayouttogglebuttonscrollview

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var poemTV : TextView
    private lateinit var loadBTN : Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        poemTV = findViewById(R.id.poemTV)
        loadBTN = findViewById(R.id.loadBTN)
    }

    private val database = Database()

    private fun loadBook(text: String) : List<String> {
        return text.split(" ")
    }

    fun loadOnClick(v : View) {
        poemTV.text = ""
        for (i in loadBook(database.text)) {
            poemTV.append("$i ")
        }
    }
}