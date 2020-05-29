package com.example.receptappen

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {

    val db = FirebaseFirestore.getInstance()
    lateinit var randomRecipeImage : ImageView
    lateinit var randomRecipeTitle : TextView
    lateinit var randomRecipeCategory : TextView
    lateinit var randomRecipeCookTime : TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val activity = activity as Context

        val foodCategoryRecyclerview = view.findViewById<RecyclerView>(R.id.recyclerView_food_category)
        val popularRowRecyclerview = view.findViewById<RecyclerView>(R.id.recyclerView_popular_row)

        randomRecipeImage = view.findViewById<ImageView>(R.id.imageView_random_recipe)
        randomRecipeCategory = view.findViewById(R.id.textView_random_recipe_catagory)
        randomRecipeCookTime = view.findViewById(R.id.textView_random_recipe_time_to_cook)
        randomRecipeTitle = view.findViewById(R.id.textView_random_recipe_title)

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

        foodCategoryRecyclerview.layoutManager = LinearLayoutManager(activity, OrientationHelper.HORIZONTAL, false)
        foodCategoryRecyclerview.adapter = AdapterFoodCategory()

        popularRowRecyclerview.layoutManager = LinearLayoutManager(activity, OrientationHelper.HORIZONTAL, false)
        popularRowRecyclerview.adapter = AdapterPopularRow()

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}
