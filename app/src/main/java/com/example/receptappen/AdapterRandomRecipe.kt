/*
package com.example.receptappen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


class AdapterRandomRecipe: RecyclerView.Adapter<CustomViewHolder>() {

    val recipeTitles = listOf<String>("Tomat Soppa")
    val foodCategories = listOf<String>("KÖTT","VEG","FÅGEL","FISK","DESSERT")

    override fun getItemCount(): Int {
        return recipeTitles.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.food_recipe_row, parent, false)
        return CustomViewHolder(cellForRow)


    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val recipeTitle = recipeTitles.get(position)
        holder?.view?.textView_food_recipe_title.text = recipeTitle
        holder?.view?.textView_food_catagory.text = "VEG"
        holder?.view?.textView_time_to_cook.text = "20m"




    }



}
*/

