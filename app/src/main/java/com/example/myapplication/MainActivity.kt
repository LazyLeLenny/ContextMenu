package com.example.myapplication

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var toolbarMain : Toolbar
    private lateinit var nameInputET : EditText
    private lateinit var ageInputET : EditText
    private lateinit var saveBTN : Button


    data class Person(val name: String, val age: String)
    private val list = mutableListOf<Person>()
    private lateinit var listViewLV : ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        toolbarMain = findViewById(R.id.toolbarMain)
        setSupportActionBar(toolbarMain)
        title = "Каталог пользователей"

        listViewLV = findViewById(R.id.listViewLV)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, list)
        listViewLV.adapter = adapter

        nameInputET = findViewById(R.id.nameInputET)
        ageInputET = findViewById(R.id.ageInputET)
        saveBTN = findViewById(R.id.saveBTN)

        saveBTN.setOnClickListener {
            list.add(Person(nameInputET.text.toString(), ageInputET.text.toString()))
            adapter.notifyDataSetChanged()
            nameInputET.text.clear()
            ageInputET.text.clear()
        }
        listViewLV.onItemClickListener =
            MyDialog.createDialog(this, adapter)
    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.exitMenuMain -> finish()
        }
        return super.onOptionsItemSelected(item)
    }
}