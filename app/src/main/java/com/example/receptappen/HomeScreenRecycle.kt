package com.example.receptappen

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_home_screen_recycle.*

class HomeScreenRecycle : AppCompatActivity() {

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen_recycle)

        recyclerView_random_recipe.layoutManager = LinearLayoutManager(this)
        recyclerView_random_recipe.adapter = AdapterRandomRecipe()

        recyclerView_food_category.layoutManager = LinearLayoutManager(this, OrientationHelper.HORIZONTAL, false)
        recyclerView_food_category.adapter = AdapterFoodCategory()

        recyclerView_category_and_recipe.layoutManager = LinearLayoutManager(this, OrientationHelper.HORIZONTAL, false)
        recyclerView_category_and_recipe.adapter = AdapterRecipeAndCategory()

        setupNavigation()
       // changeLayout()

    }

    private fun setupNavigation() {
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        navView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_bar_home -> {
                    Toast.makeText(this, "Home selected", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_bar_profile -> {
                    Toast.makeText(this, "Photos selected", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_bar_like_button -> {
                    Toast.makeText(this, "More selected", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> true
            }
        }
    }

    fun changeLayout() {
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        navView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_bar_home -> {
                    val intent = Intent(this, HomeScreenRecycle::class.java)
                    startActivity(intent)
                }
                R.id.nav_bar_profile -> {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
                R.id.nav_bar_like_button -> {
                    val intent = Intent(this, ActivityCreateRecipe::class.java)
                    startActivity(intent)
                }
                else -> true

            } as Boolean
        }
    }
}
