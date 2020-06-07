/*
package com.example.receptappen

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class ChoosenRecipeActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choosen_recipe)

        val choosenRecipeImage = findViewById<ImageView>(R.id.imageView_choosen_recipe)
        val choosenRecipeTitle = findViewById<TextView>(R.id.textView_choosen_recipe_title)
        val choosenRecipeTime = findViewById<TextView>(R.id.textView_choosen_recipe_time)
        val choosenRecipeCategory = findViewById<TextView>(R.id.textView_choosen_recipe_category)
        val choosenRecipeIngrediens = findViewById<TextView>(R.id.textView_choosen_recipe_ingrediens)
        val choosenRecipeDescription = findViewById<TextView>(R.id.textView_choosen_recipe_description)

        var intent = intent

        val allRecipeImage = intent.getStringExtra("allRecipeImage")
        val allRecipeTitle = intent.getStringExtra("allRecipeTitle")
        val allRecipeCategory = intent.getStringExtra("allRecipeCategory")
        val allRecipeDescription = intent.getStringExtra("allRecipeDescription")
        val allRecipeIngrediens = intent.getStringExtra("allRecipeIngrediens")
        val allRecipeTime = intent.getStringExtra("allRecipeCooktime")


        Picasso.with(this).load(allRecipeImage).into(choosenRecipeImage)
        choosenRecipeCategory.text = allRecipeCategory
        choosenRecipeDescription.text = allRecipeDescription
        choosenRecipeIngrediens.text = allRecipeIngrediens
        choosenRecipeTime.text = allRecipeTime
        choosenRecipeTitle.text = allRecipeTitle

        if (choosenRecipeCategory.text == "KÖTT") {
            choosenRecipeCategory.setBackgroundResource(R.drawable.round_corner_meat)
        }

        if (choosenRecipeCategory.text == "VEG") {
            choosenRecipeCategory.setBackgroundResource(R.drawable.round_corner_veg)
        }

        if (choosenRecipeCategory.text == "FÅGEL") {
            choosenRecipeCategory.setBackgroundResource(R.drawable.round_corner_chicken)
        }

        if (choosenRecipeCategory.text == "FISK") {
            choosenRecipeCategory.setBackgroundResource(R.drawable.round_corner_fish)
        }

        if (choosenRecipeCategory.text == "DESSERT") {
            choosenRecipeCategory.setBackgroundResource(R.drawable.round_corner_dessert)
        }







    }
}*/
