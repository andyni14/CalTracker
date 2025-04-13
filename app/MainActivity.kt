package com.example.caltrack

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val chartImage: ImageView = findViewById(R.id.chartImage)
        Glide.with(this).load(R.drawable.sample_chart).into(chartImage)
    }
}
