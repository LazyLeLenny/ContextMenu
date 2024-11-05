package com.example.calculator

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    private lateinit var toolbarMain : Toolbar

    private lateinit var inputET : EditText

    private lateinit var oneBTN : Button
    private lateinit var twoBTN : Button
    private lateinit var threeBTN : Button
    private lateinit var fourBTN : Button
    private lateinit var fiveBTN : Button
    private lateinit var sixBTN : Button
    private lateinit var sevenBTN : Button
    private lateinit var eightBTN : Button
    private lateinit var nineBTN : Button
    private lateinit var plusButton: Button
    private lateinit var minusButton: Button
    private lateinit var multBTN: Button
    private lateinit var divBTN : Button
    private lateinit var clearBTN : Button
    private lateinit var equalsBTN : Button

    private lateinit var resultTV : TextView

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
        title = "Калькулятор"
        toolbarMain.setTitleTextColor(getColor(R.color.white))
        toolbarMain.subtitle = "версия 1"
        toolbarMain.setSubtitleTextColor(getColor(R.color.white))
        toolbarMain.setLogo(R.drawable.ic_calc)

        inputET = findViewById(R.id.InputET)
        inputET.isEnabled = false


        oneBTN = findViewById(R.id.oneBTN)
        twoBTN = findViewById(R.id.twoBTN)
        threeBTN = findViewById(R.id.threeBTN)
        fourBTN = findViewById(R.id.fourBTN)
        fiveBTN = findViewById(R.id.fiveBTN)
        sixBTN = findViewById(R.id.sixBTN)
        sevenBTN = findViewById(R.id.sevenBTN)
        eightBTN = findViewById(R.id.eightBTN)
        nineBTN = findViewById(R.id.nineBTN)
        plusButton = findViewById(R.id.SumBTN)
        minusButton = findViewById(R.id.DifBTN)
        multBTN = findViewById(R.id.MultBTN)
        divBTN = findViewById(R.id.DivBTN)
        clearBTN = findViewById(R.id.clearBTN)
        equalsBTN = findViewById(R.id.equalsBTN)

        resultTV = findViewById(R.id.resultTV)

        oneBTN.setOnClickListener{inputET.setText("${inputET.text}1")}
        twoBTN.setOnClickListener{inputET.setText("${inputET.text}2")}
        threeBTN.setOnClickListener{inputET.setText("${inputET.text}3")}
        fourBTN.setOnClickListener{inputET.setText("${inputET.text}4")}
        fiveBTN.setOnClickListener{inputET.setText("${inputET.text}5")}
        sixBTN.setOnClickListener{inputET.setText("${inputET.text}6")}
        sevenBTN.setOnClickListener{inputET.setText("${inputET.text}7")}
        eightBTN.setOnClickListener{inputET.setText("${inputET.text}8")}
        nineBTN.setOnClickListener{inputET.setText("${inputET.text}9")}
        plusButton.setOnClickListener{inputET.setText("${inputET.text}+")}
        minusButton.setOnClickListener{inputET.setText("${inputET.text}-")}
        multBTN.setOnClickListener{inputET.setText("${inputET.text}*")}
        divBTN.setOnClickListener{inputET.setText("${inputET.text}/")}
        clearBTN.setOnClickListener{
            inputET.text.clear()
            resultTV.text = ""
        }
        equalsBTN.setOnClickListener{
            resultTV.text = eval(inputET.text.toString()).toString()
        }
    }

    private fun eval(expression: String): Int {
        val expr = ExpressionBuilder(expression).build()
        return expr.evaluate().toInt()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.exitMenuMain -> {
                Toast.makeText(applicationContext,
                    "Приложение закрыто",
                    Toast.LENGTH_LONG).show()
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}