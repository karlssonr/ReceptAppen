package com.example.receptappen

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class AdapterDessertRow(private val context: Context, private val dessertRecipes : List<Recipe>): RecyclerView.Adapter<AdapterDessertRow.CustomViewHolder>() {

    private val layoutInflator = LayoutInflater.from(context)

    override fun getItemCount() = dessertRecipes.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {

        val itemView = layoutInflator.inflate(R.layout.dessert_row, parent, false)
        return CustomViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {

        val recipe = dessertRecipes[position]

        Picasso.with(context).load(recipe.image).into(holder.dessertRecipeImage)
        holder.dessertRecipeCategory.text = recipe.category
        holder.dessertRecipeTime.text = recipe.cookTime
        holder.dessertRecipeTitle.text = recipe.title

    }

    inner class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view) {

        var dessertRecipeImage = view.findViewById<ImageView>(R.id.imageView_dessert_row)
        var dessertRecipeTitle = view.findViewById<TextView>(R.id.textView_dessert_row_title)
        var dessertRecipeCategory = view.findViewById<TextView>(R.id.textView_dessert_row_category)
        var dessertRecipeTime = view.findViewById<TextView>(R.id.textView_dessert_row_time)

    }

}
