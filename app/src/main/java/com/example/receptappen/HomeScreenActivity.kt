package com.example.receptappen

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import kotlinx.android.synthetic.main.activity_home_screen_recycle.*


class HomeScreenActivity : AppCompatActivity() {

    val db = FirebaseFirestore.getInstance()
    lateinit var randomRecipeImage : ImageView
    lateinit var randomRecipeTitle : TextView
    lateinit var randomRecipeCategory : TextView
    lateinit var randomRecipeCookTime : TextView

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->

        when(item.itemId) {
            R.id.nav_bar_home -> {
                val intent = Intent(this, HomeScreenActivity::class.java)
                startActivity(intent)
               /* replaceFragment(HomeFragment())*/
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_bar_profile -> {
                val intent = Intent(this, HomeScreenActivity::class.java)
                startActivity(intent)
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_bar_add -> {
                val intent = Intent(this, ActivityCreateRecipe::class.java)
                startActivity(intent)
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







/*        db.collection("users")
            .get()
            .addOnCompleteListener(OnCompleteListener<QuerySnapshot> { task ->
                if (task.isSuccessful) {
                    for (document in task.result!!) {
                        Log.d(
                            FragmentActivity.TAG,
                            document.id + " => " + document.data
                        )
                    }
                } else {
                    Log.w(FragmentActivity.TAG, "Error getting documents.", task.exception)
                }
            })*/

        recyclerView_food_category.layoutManager = LinearLayoutManager(this, OrientationHelper.HORIZONTAL, false)
        recyclerView_food_category.adapter = AdapterFoodCategory()

        recyclerView_category_and_recipe.layoutManager = LinearLayoutManager(this, OrientationHelper.HORIZONTAL, false)
        recyclerView_category_and_recipe.adapter = AdapterPopularRow()

        bottomNavigation.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        /*replaceFragment(HomeFragment())*/

    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer, fragment)
        fragmentTransaction.commit()

    }

}
