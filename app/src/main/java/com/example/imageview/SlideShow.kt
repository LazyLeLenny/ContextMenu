package com.example.imageview

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SlideShow : AppCompatActivity() {
    val list = listOf(
        R.drawable.img_0693,
        R.drawable.img_68422_ps2,
        R.drawable.brettforestphoto1,
        R.drawable.cascadia_for_the_wild,
        R.drawable.nw_forest_plan_image_1_768x367
    )
    private lateinit var imageIV : ImageView
    private lateinit var nextBTN : Button
    var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_slide_show)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        imageIV = findViewById(R.id.imageIV)
        imageIV.setImageResource(list[0])

        nextBTN = findViewById(R.id.nextBTN)
        nextBTN.setOnClickListener{
            count++
            if (count in 0..list.lastIndex) {
                imageIV.setImageResource(list[count])
            } else {
                startActivity(Intent(this, EndingActivity::class.java))
                finish()
            }
        }
    }
}