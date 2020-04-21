package com.example.receptappen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_home_screen_recycle.*

class HomeScreenRecycle : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen_recycle)

        recyclerView_homeScreen.layoutManager = LinearLayoutManager(this)
        recyclerView_homeScreen.adapter = MainAdapter()
    }
}
