package com.example.receptappen

import com.google.firebase.firestore.FirebaseFirestore
import com.squareup.picasso.Picasso

object DataStorage {




    val ingredients = mutableListOf<String>()
    val listOfRecipes  = mutableListOf<Recipe>()

    val vegitarianRecipes = mutableListOf<Recipe>()
    val meatRecipes = mutableListOf<Recipe>()
    val chickenRecipes = mutableListOf<Recipe>()
    val fishRecipes = mutableListOf<Recipe>()
    val dessertRecipes = mutableListOf<Recipe>()






/*
    init {
        createMockData()
    }


    fun createMockData() {

        var ingredient = Ingredient("Morot", "2st")
        ingredients.add(ingredient)

        ingredient = Ingredient("Mjölk", "2dl")
        ingredients.add(ingredient)
    }
*/


}