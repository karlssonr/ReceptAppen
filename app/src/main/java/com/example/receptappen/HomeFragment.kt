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
import androidx.cardview.widget.CardView
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


    val recipeRef = db.collection("recipes")
    val vegRecipeRef = db.collection("recipes").whereEqualTo("category", "VEG")
    val meatRecipeRef = DataStorage.db.collection("recipes").whereEqualTo("category", "KÖTT")
    val dessertRecipeRef = db.collection("recipes").whereEqualTo("category", "DESSERT")
    val fishRecipeRef = db.collection("recipes").whereEqualTo("category", "FISK")
    val chickenRecipeRef = db.collection("recipes").whereEqualTo("category", "FÅGEL")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val activity = activity as Context

        val foodCategoryRecyclerview = view.findViewById<RecyclerView>(R.id.recyclerView_food_category)
        val vegRowRecyclerview = view.findViewById<RecyclerView>(R.id.recyclerView_veg)
        val meatRecyclerview = view.findViewById<RecyclerView>(R.id.recyclerView_meat)
        val chickenRecyclerView = view.findViewById<RecyclerView>(R.id.recyclerView_chicken)
        val fishRecyclerview = view.findViewById<RecyclerView>(R.id.recyclerView_fish)
        val dessertRecyclerview = view.findViewById<RecyclerView>(R.id.recyclerView_dessert)
        val allRecipeRecyclerview = view.findViewById<RecyclerView>(R.id.recyclerView_all_recipe)



        randomRecipeImage = view.findViewById<ImageView>(R.id.imageView_random_recipe)
        randomRecipeCategory = view.findViewById(R.id.textView_random_recipe_catagory)
        randomRecipeCookTime = view.findViewById(R.id.textView_random_recipe_time_to_cook)
        randomRecipeTitle = view.findViewById(R.id.textView_random_recipe_title)





        recipeRef.get().addOnSuccessListener { documentSnapshot ->
            for (document in documentSnapshot.documents) {
                val newRecipe = document.toObject(Recipe::class.java)
                if (newRecipe != null)
                    DataStorage.listOfRecipes.add(newRecipe!!)

            }

        }



        vegRecipeRef.get().addOnSuccessListener { documentSnapshot ->
            for (document in documentSnapshot.documents) {
                val newRecipe = document.toObject(Recipe::class.java)
                if (newRecipe != null)
                    DataStorage.vegitarianRecipes.add(newRecipe!!)

            }

        }



        dessertRecipeRef.get().addOnSuccessListener { documentSnapshot ->
            for (document in documentSnapshot.documents) {
                val newRecipe = document.toObject(Recipe::class.java)
                if (newRecipe != null)
                    DataStorage.dessertRecipes.add(newRecipe!!)

            }

        }

        chickenRecipeRef.get().addOnSuccessListener { documentSnapshot ->
            for (document in documentSnapshot.documents) {
                val newRecipe = document.toObject(Recipe::class.java)
                if (newRecipe != null)
                    DataStorage.chickenRecipes.add(newRecipe!!)

            }

        }

        fishRecipeRef.get().addOnSuccessListener { documentSnapshot ->
            for (document in documentSnapshot.documents) {
                val newRecipe = document.toObject(Recipe::class.java)
                if (newRecipe != null)
                    DataStorage.fishRecipes.add(newRecipe!!)

            }

        }

        meatRecipeRef.get().addOnSuccessListener { documentSnapshot ->
            for (document in documentSnapshot.documents) {
                val newRecipe = document.toObject(Recipe::class.java)
                if (newRecipe != null)
                    DataStorage.meatRecipes.add(newRecipe!!)

            }

        }






        loadRecipeIntoRandomRecipeLayout()

        foodCategoryRecyclerview.layoutManager = LinearLayoutManager(activity, OrientationHelper.HORIZONTAL, false)
        foodCategoryRecyclerview.adapter = AdapterFoodCategory()

        vegRowRecyclerview.layoutManager = LinearLayoutManager(activity, OrientationHelper.HORIZONTAL, false)
        vegRowRecyclerview.adapter = AdapterVegRow(activity, DataStorage.vegitarianRecipes)

        chickenRecyclerView.layoutManager = LinearLayoutManager(activity, OrientationHelper.HORIZONTAL, false)
        chickenRecyclerView.adapter = AdapterChickenRow(activity, DataStorage.chickenRecipes)

        fishRecyclerview.layoutManager = LinearLayoutManager(activity, OrientationHelper.HORIZONTAL, false)
        fishRecyclerview.adapter = AdapterFishRow(activity, DataStorage.fishRecipes)


            meatRecyclerview.layoutManager = LinearLayoutManager(activity, OrientationHelper.HORIZONTAL, false)
            meatRecyclerview.adapter = AdapterMeatRow(activity, DataStorage.meatRecipes)

        dessertRecyclerview.layoutManager = LinearLayoutManager(activity, OrientationHelper.HORIZONTAL, false)
        dessertRecyclerview.adapter = AdapterDessertRow(activity, DataStorage.dessertRecipes)

        allRecipeRecyclerview.layoutManager = LinearLayoutManager(activity, OrientationHelper.HORIZONTAL, false)
        allRecipeRecyclerview.adapter = AdapterAllRecipeRow(activity, DataStorage.listOfRecipes)






        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val changeRecipeTimer = object: CountDownTimer(10000, 1000) {
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

/*    private fun replaceFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, fragment)
        fragmentTransaction.commit()



    }*/




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
