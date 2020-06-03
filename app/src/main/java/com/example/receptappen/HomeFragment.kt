package com.example.receptappen

import android.content.Context
import android.os.Bundle
import android.os.CountDownTimer
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
import com.squareup.picasso.Picasso


class HomeFragment : Fragment() {

    val db = FirebaseFirestore.getInstance()
    lateinit var randomRecipeImage : ImageView
    lateinit var randomRecipeTitle : TextView
    lateinit var randomRecipeCategory : TextView
    lateinit var randomRecipeCookTime : TextView

    val vegRecipeRef = db.collection("recipes").whereEqualTo("category", "VEG")
    val recipeRef = db.collection("recipes")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val activity = activity as Context

        val foodCategoryRecyclerview = view.findViewById<RecyclerView>(R.id.recyclerView_food_category)
        val popularRowRecyclerview = view.findViewById<RecyclerView>(R.id.recyclerView_veg)

        randomRecipeImage = view.findViewById<ImageView>(R.id.imageView_random_recipe)
        randomRecipeCategory = view.findViewById(R.id.textView_random_recipe_catagory)
        randomRecipeCookTime = view.findViewById(R.id.textView_random_recipe_time_to_cook)
        randomRecipeTitle = view.findViewById(R.id.textView_random_recipe_title)




        recipeRef.get().addOnSuccessListener { documentSnapshot ->
            for (document in documentSnapshot.documents) {
                val newRecipe = document.toObject(Recipe::class.java)
                if (newRecipe != null)
                    DataStorage.listOfRecipes.add(newRecipe!!)
                println("!!! : ${newRecipe}")
            }

        }

        vegRecipeRef.get().addOnSuccessListener { documentSnapshot ->
            for (document in documentSnapshot.documents) {
                val newRecipe = document.toObject(Recipe::class.java)
                if (newRecipe != null)
                    DataStorage.vegitarianRecipes.add(newRecipe!!)
                println("!!! : ${newRecipe}")
            }



            loadRecipeIntoRandomRecipeLayout()

        }



        foodCategoryRecyclerview.layoutManager = LinearLayoutManager(activity, OrientationHelper.HORIZONTAL, false)
        foodCategoryRecyclerview.adapter = AdapterFoodCategory()

        popularRowRecyclerview.layoutManager = LinearLayoutManager(activity, OrientationHelper.HORIZONTAL, false)
        popularRowRecyclerview.adapter = AdapterVegRow(activity, DataStorage.vegitarianRecipes)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val changeRecipeTimer = object: CountDownTimer(2000, 1000) {
            override fun onTick(millisUntilFinished: Long) {

            }

            override fun onFinish() {

                DataStorage.listOfRecipes.shuffle()
                loadRecipeIntoRandomRecipeLayout()
                this.start()



                }
        }
        changeRecipeTimer.start()




    }


    private fun loadRecipeIntoRandomRecipeLayout() {

        for (recipe in DataStorage.listOfRecipes) {


            Picasso.with(activity).load(recipe.image).into(randomRecipeImage)

            randomRecipeTitle.text = recipe.title
            randomRecipeCookTime.text = recipe.cookTime
            randomRecipeCategory.text = recipe.category

            if (randomRecipeCategory.text.toString() == "VEG") {
                randomRecipeCategory.setBackgroundResource(R.drawable.round_corner_veg)
            }

            if (randomRecipeCategory.text.toString() == "KÖTT") {
                randomRecipeCategory.setBackgroundResource(R.drawable.round_corner_meat)
            }

            if (randomRecipeCategory.text.toString() == "FÅGEL") {
                randomRecipeCategory.setBackgroundResource(R.drawable.round_corner_chicken)
            }

            if (randomRecipeCategory.text.toString() == "FISK") {
                randomRecipeCategory.setBackgroundResource(R.drawable.round_corner_fish)
            }

            if (randomRecipeCategory.text.toString() == "DESSERT") {
                randomRecipeCategory.setBackgroundResource(R.drawable.round_corner_dessert)
            }





        }
    }

}
