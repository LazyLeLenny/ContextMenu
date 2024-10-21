package com.example.contextmenu

import android.graphics.Color
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    companion object {
        const val ITEM_ON = 111
        const val ITEM_OFF = 112
    }

    private lateinit var markET: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        markET = findViewById(R.id.markET)
        registerForContextMenu(markET)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menu?.add(Menu.NONE, ITEM_ON, Menu.NONE, "Цветовое качество")
        menu?.add(Menu.NONE, ITEM_OFF, Menu.NONE, "Выход из приложения")
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            ITEM_ON -> {
                when((markET.text).toString()) {
                    "1" -> markET.setBackgroundColor(Color.parseColor("#ffA500"))
                    "2" -> markET.setBackgroundColor(Color.YELLOW)
                    "3" -> markET.setBackgroundColor(Color.GREEN)
                    "4" -> markET.setBackgroundColor(Color.BLUE)
                    "5" -> markET.setBackgroundColor(Color.RED)
                }
            }
            ITEM_OFF -> {
                finish()
            }
            else -> return super.onContextItemSelected(item)
        }
        return true
    }
}