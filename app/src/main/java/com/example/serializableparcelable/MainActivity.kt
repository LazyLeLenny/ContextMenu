package com.example.serializableparcelable

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var nameET : EditText
    private lateinit var lastNameET : EditText
    private lateinit var adressET : EditText
    private lateinit var phoneET : EditText
    private lateinit var saveBTN : Button
    private lateinit var listViewLV : ListView

    private val list = mutableListOf<Person>()
    private val nameList = mutableListOf<Pair<String, String>>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        nameET = findViewById(R.id.nameET)
        lastNameET = findViewById(R.id.lastNameET)
        adressET = findViewById(R.id.adressET)
        phoneET = findViewById(R.id.phoneET)
        saveBTN = findViewById(R.id.saveBTN)
        listViewLV = findViewById(R.id.listViewLV)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, nameList)
        listViewLV.adapter = adapter

        saveBTN.setOnClickListener{
            val person = Person(nameET.text.toString(), lastNameET.text.toString(), adressET.text.toString(), phoneET.text.toString())
            list.add(person)
            nameList.add(Pair(person.name, person.lastName))
            adapter.notifyDataSetChanged()
            nameET.text.clear()
            lastNameET.text.clear()
            adressET.text.clear()
            phoneET.text.clear()
        }

        listViewLV.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val person = list[position]
            startActivity(Intent(this, DetailsActivity::class.java)
                .putExtra(Person::class.java.simpleName, person))}
    }
}