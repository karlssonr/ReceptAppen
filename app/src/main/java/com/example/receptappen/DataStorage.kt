package com.example.receptappen

import com.google.firebase.firestore.FirebaseFirestore
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

object DataStorage {


    val db = FirebaseFirestore.getInstance()


    val ingredients = mutableListOf<String>()
    val listOfRecipes  = mutableListOf<Recipe>()

    val vegitarianRecipes = mutableListOf<Recipe>()
    val meatRecipes = mutableListOf<Recipe>()
    val chickenRecipes = mutableListOf<Recipe>()
    val fishRecipes = mutableListOf<Recipe>()
    val dessertRecipes = mutableListOf<Recipe>()




    init {



        }

        fun downloadMeatRecipes(callback: () -> Unit ) {


                callback.invoke()
        }
    }






