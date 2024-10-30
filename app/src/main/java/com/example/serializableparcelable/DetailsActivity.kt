package com.example.serializableparcelable

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailsActivity : AppCompatActivity() {
    private var person : Person? = null

    private lateinit var nameTV: TextView
    private lateinit var lastNameTV : TextView
    private lateinit var adressTV: TextView
    private lateinit var phoneTV : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_details)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        person = intent.extras?.getSerializable(Person::class.java.simpleName) as Person?

        nameTV = findViewById(R.id.nameTV)
        lastNameTV = findViewById(R.id.lastNameTV)
        adressTV = findViewById(R.id.adressTV)
        phoneTV = findViewById(R.id.phoneTV)

        nameTV.text = person?.name
        lastNameTV.text = person?.lastName
        adressTV.text = person?.adress
        phoneTV.text = person?.phone
    }
}