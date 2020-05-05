package com.example.receptappen

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

import kotlinx.android.synthetic.main.activity_home_screen_recycle.*

class HomeScreenRecycle : AppCompatActivity() {

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->

        when(item.itemId) {
            R.id.nav_bar_home -> {
                val intent = Intent(this, HomeScreenRecycle::class.java)
                startActivity(intent)
               // replaceFragment(HomeFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_bar_profile -> {
/*                val intent = Intent(this, HomeScreenRecycle::class.java)
                startActivity(intent)*/
               // replaceFragment(ProfileFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_bar_favorite -> {
                val intent = Intent(this, AdapterAddPhoto::class.java)
                startActivity(intent)
              //  replaceFragment(FavoriteFragment())
                return@OnNavigationItemSelectedListener true
            }


            else -> false
        }
    }

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

        bottomNavigation.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
     //   replaceFragment(HomeFragment())

    }

/*
    private fun replaceFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer, fragment)
        fragmentTransaction.commit()

    }
*/

}
