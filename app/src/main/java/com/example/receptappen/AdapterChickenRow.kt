package com.example.receptappen

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class AdapterChickenRow(private val context : Context, private val chickenRecipes : List<Recipe>) : RecyclerView.Adapter<AdapterChickenRow.CustomViewHolder>() {

    private val layoutInflator = LayoutInflater.from(context)

    override fun getItemCount() = chickenRecipes.size



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val itemView = layoutInflator.inflate(R.layout.chicken_row, parent , false)
        return  CustomViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {

        val recipe = chickenRecipes[position]

        Picasso.with(context).load(recipe.image).into(holder.chickenRecipeImage)
        holder.chickenRecipeCategory.text = recipe.category
        holder.chickenRecipeTime.text = recipe.cookTime
        holder.chickenRecipeTitle.text = recipe.title

    }

    inner class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view) {

        var chickenRecipeImage = view.findViewById<ImageView>(R.id.imageView_chicken_row)
        var chickenRecipeTitle = view.findViewById<TextView>(R.id.textView_chicken_row_title)
        var chickenRecipeCategory = view.findViewById<TextView>(R.id.textView_chicken_row_category)
        var chickenRecipeTime = view.findViewById<TextView>(R.id.textView_chicken_row_time)

    }
}