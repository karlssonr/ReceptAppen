package com.example.receptappen

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_home_screen_recycle.*


class HomeScreenActivity : AppCompatActivity() {

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->

        when(item.itemId) {
            R.id.nav_bar_home -> {
                val intent = Intent(this, HomeScreenActivity::class.java)
                startActivity(intent)
                replaceFragment(HomeFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_bar_profile -> {
                val intent = Intent(this, HomeScreenActivity::class.java)
                startActivity(intent)
                replaceFragment(ProfileFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_bar_favorite -> {
                val intent = Intent(this, HomeScreenActivity::class.java)
                startActivity(intent)
                replaceFragment(FavoriteFragment())
                return@OnNavigationItemSelectedListener true
            }


            else -> false
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen_recycle)

        val goToCreateRecipeActivityButton = findViewById<View>(R.id.go_to_create_recipe_activity)

        goToCreateRecipeActivityButton.setOnClickListener {
            val intent = Intent(this, ActivityCreateRecipe::class.java)
            startActivity(intent)
        }



/*

        // Create a new user with a first and last name
        val user: MutableMap<String, Any> = HashMap()
        user["first"] = "Ada"
        user["last"] = "Lovelace"
        user["born"] = 1815



// Add a new document with a generated ID
        db.collection("users")
            .add(user)
            .addOnSuccessListener { documentReference ->
                Log.d(
                    "!!!",
                    "DocumentSnapshot added with ID: " + documentReference.id
                )
            }
            .addOnFailureListener { e -> Log.w("!!!", "Error adding document", e) }
*/




        recyclerView_random_recipe.layoutManager = LinearLayoutManager(this)
        recyclerView_random_recipe.adapter = AdapterRandomRecipe()

        recyclerView_food_category.layoutManager = LinearLayoutManager(this, OrientationHelper.HORIZONTAL, false)
        recyclerView_food_category.adapter = AdapterFoodCategory()

        recyclerView_category_and_recipe.layoutManager = LinearLayoutManager(this, OrientationHelper.HORIZONTAL, false)
        recyclerView_category_and_recipe.adapter = AdapterPopularRow()

        bottomNavigation.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        replaceFragment(HomeFragment())

    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer, fragment)
        fragmentTransaction.commit()

    }

}
