package com.example.receptappen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val logInButton = findViewById<View>(R.id.log_in_button)

        logInButton.setOnClickListener {
           val intent = Intent(this, HomeScreenRecycle::class.java)
           startActivity(intent)
        }
    }




}
