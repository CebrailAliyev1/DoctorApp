package com.example.doctortask

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.doctortask.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        textView = findViewById(R.id.textView)
        val text = "Find your doctor"



        val data = listOf("dr. Gilang Segara Bening", "dr. Shabil Chan", "dr. Mustakim", "dr. Suprihatini", "dr. Suprihatini") // Replace with your actual data
        val images = listOf(R.drawable.img_2, R.drawable.img_9, R.drawable.img_10, R.drawable.img_10, R.drawable.img_10) // Replace with your actual image resources


        val myadapter = Adapter(data, images) { selectedItem ->
            val selectedIndex = data.indexOf(selectedItem)
            val selectedImage = images[selectedIndex]

            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("selectedItem", selectedItem)
            intent.putExtra("selectedImage", selectedImage)
            startActivity(intent)
        }
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = myadapter

    }


}