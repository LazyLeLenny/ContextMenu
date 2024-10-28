package com.example.myapplication

import android.content.Context
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AlertDialog
import com.example.myapplication.MainActivity.Person

class MyDialog {
    companion object {
        fun createDialog(context: Context, adapter: ArrayAdapter<Person>) =
            AdapterView.OnItemClickListener { parent, v, position, id ->
                val builder = AlertDialog.Builder(context)
                builder.setTitle("Внимание")
                    .setMessage("Удалить пользователя?")
                    .setCancelable(true)
                    .setNegativeButton("Нет") { dialog, which ->
                        dialog.cancel()
                    }
                    .setPositiveButton("Да") { dialog, which ->
                        val user = adapter.getItem(position)
                        adapter.remove(user)
                    }.create()
                builder.show()
            }
    }
}