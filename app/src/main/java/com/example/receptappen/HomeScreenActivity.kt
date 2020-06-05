package com.example.receptappen

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_home_screen_recycle.*
import kotlinx.android.synthetic.main.fragment_home.*


class HomeScreenActivity : AppCompatActivity() {

    val db = FirebaseFirestore.getInstance()
    lateinit var randomRecipeImage : ImageView
    lateinit var randomRecipeTitle : TextView
    lateinit var randomRecipeCategory : TextView
    lateinit var randomRecipeCookTime : TextView

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->

        when(item.itemId) {
            R.id.nav_bar_home -> {
                replaceFragment(HomeFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_bar_profile -> {
                replaceFragment(ProfileFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_bar_add -> {
                replaceFragment(AddFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_bar_favorite -> {
                replaceFragment(FavoriteFragment())
                return@OnNavigationItemSelectedListener true
            }


            else -> false
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen_recycle)


/*
        randomRecipeImage = findViewById<ImageView>(R.id.imageView_random_recipe)
        randomRecipeCategory = findViewById(R.id.textView_random_recipe_catagory)
        randomRecipeCookTime = findViewById(R.id.textView_random_recipe_time_to_cook)
        randomRecipeTitle = findViewById(R.id.textView_random_recipe_title)



        val recipeList = mutableListOf<Recipe>()
        val recipeRef = db.collection("recipes")

        recipeRef.get().addOnSuccessListener { documentSnapshot ->
            for (document in documentSnapshot.documents) {
                val newRecipe = document.toObject(Recipe::class.java)
                if (newRecipe != null)
                    recipeList.add(newRecipe!!)
                println("!!! : ${newRecipe}")
            }

            for (recipe in recipeList) {
                if (recipe.title == "test1") {
                   // randomRecipeImage = recipe.image
                    randomRecipeTitle.text = recipe.title
                    randomRecipeCookTime.text = recipe.cookTime
                    randomRecipeCategory.text = recipe.category

                }

            }


        }








        recyclerView_food_category.layoutManager = LinearLayoutManager(this, OrientationHelper.HORIZONTAL, false)
        recyclerView_food_category.adapter = AdapterFoodCategory()

        recyclerView_popular_row.layoutManager = LinearLayoutManager(this, OrientationHelper.HORIZONTAL, false)
        recyclerView_popular_row.adapter = AdapterVegRow()*/

        bottomNavigation.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        replaceFragment(HomeFragment())

    }

     fun replaceFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, fragment)
        fragmentTransaction.commit()

    }

    interface Communicator {

        fun passDataCom()
    }

}
