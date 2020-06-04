/*
package com.example.receptappen

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class AdapterMeatRow(private val context: Context, private val meatRecipes: List<Recipe>): RecyclerView.Adapter<AdapterMeatRow.CustomViewHolder>() {

    private val layoutInflator = LayoutInflater.from(context)






    override fun getItemCount() = meatRecipes.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {

        val itemView = layoutInflator.inflate(R.layout.veg_row, parent, false)
        return CustomViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {

        val recipe = meatRecipes[position]

        println("!!! ${recipe.image}")

        Picasso.with(context).load(recipe.image).into(holder?.meatRecipeImage)
        holder?.meatRecipeTitle?.text = recipe.category
        holder?.meatRecipeCategory?.text = recipe.cookTime
        holder?.meatRecipeTime?.text = recipe.title



    }




   inner class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view) {

        var meatRecipeImage = view.findViewById<ImageView>(R.id.imageView_meat_row)
        var meatRecipeTitle = view.findViewById<TextView>(R.id.textView_meat_row_title)
        var meatRecipeCategory = view.findViewById<TextView>(R.id.textView_meat_row_category)
        var meatRecipeTime = view.findViewById<TextView>(R.id.textView_meat_row_time)

    }



}
*/
