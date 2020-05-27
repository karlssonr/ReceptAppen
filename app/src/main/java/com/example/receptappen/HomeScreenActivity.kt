package com.example.receptappen

import android.content.Intent
import android.os.Bundle
import android.view.View
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


        val recipeList = mutableListOf<Recipe>()
        val recipeRef = db.collection("recipes")

        recipeRef.get().addOnSuccessListener { documentSnapshot ->
            for (document in documentSnapshot.documents) {
                val newRecipe = document.toObject(Recipe::class.java)
                if (newRecipe != null)
                    recipeList.add(newRecipe!!)
                println("!!! : ${newRecipe}")
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
        replaceFragment(HomeFragment())

    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer, fragment)
        fragmentTransaction.commit()

    }

}
