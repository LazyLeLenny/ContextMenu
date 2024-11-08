package com.example.customlistview

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.io.IOException

class StoreCreationActivity : AppCompatActivity() {
    private val GALLERY_REQUEST = 2004
    private var bitmap: Bitmap? = null
    private var productList: MutableList<Product> = mutableListOf()

    private lateinit var listViewLV : ListView
    private lateinit var addBTN : Button
    private lateinit var productNameET : EditText
    private lateinit var priceET : EditText
    private lateinit var setImageIV : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_store_creation)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        listViewLV = findViewById(R.id.listViewLV)
        addBTN = findViewById(R.id.addBTN)
        productNameET = findViewById(R.id.productNameET)
        priceET = findViewById(R.id.priceET)
        setImageIV = findViewById(R.id.setImageIV)

        setImageIV.setOnClickListener{
            val photoSelectIntent = Intent(Intent.ACTION_PICK)
            photoSelectIntent.type = "image/*"
            startActivityForResult(photoSelectIntent, GALLERY_REQUEST)
        }

        addBTN.setOnClickListener {
            val productName = productNameET.text.toString()
            val price = priceET.text.toString()
            val image = bitmap
            val product = Product(productName, price, image)
            productList.add(product)

            val listAdapter = ListAdapter(this@StoreCreationActivity, productList)
            listViewLV.adapter = listAdapter
            listAdapter.notifyDataSetChanged()
            productNameET.text.clear()
            priceET.text.clear()
            setImageIV.setImageResource(R.drawable._710414)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        setImageIV = findViewById(R.id.setImageIV)
        when(requestCode) {
            GALLERY_REQUEST -> if (resultCode === RESULT_OK) {
                val selectedImage : Uri? = data?.data
                try {
                    bitmap = MediaStore.Images.Media.getBitmap(contentResolver, selectedImage)
                } catch (e: IOException) {
                    e.printStackTrace()
                }
                setImageIV.setImageBitmap(bitmap)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.store_creation_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.exit -> finish()
        }
        return super.onOptionsItemSelected(item)
    }
}