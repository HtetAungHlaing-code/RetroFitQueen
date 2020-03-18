package com.example.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.voting_item.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        var a=intent.getStringExtra("a")
        var b=intent.getStringExtra("IMAGE")
        txt1.text=a

        Glide.with(applicationContext)
            .load(b)
            .placeholder(R.drawable.ic_launcher_background)
            .into(image_queen)
    }
}
