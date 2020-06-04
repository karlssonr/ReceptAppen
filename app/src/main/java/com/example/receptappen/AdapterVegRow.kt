package com.example.receptappen

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class AdapterVegRow(private val context: Context, private val vegitarianRecipes: List<Recipe>): RecyclerView.Adapter<AdapterVegRow.CustomViewHolder>() {



    private val layoutInflator = LayoutInflater.from(context)






    override fun getItemCount() = vegitarianRecipes.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {

        val itemView = layoutInflator.inflate(R.layout.veg_row, parent, false)
        return CustomViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {

        val recipe = vegitarianRecipes[position]

        Picasso.with(context).load(recipe.image).into(holder.vegRecipeImage)
        holder.vegRecipeCategory.text = recipe.category
        holder.vegRecipeTime.text = recipe.cookTime
        holder.vegRecipeTitle.text = recipe.title



        }




    class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view) {

        var vegRecipeImage = view.findViewById<ImageView>(R.id.imageView_veg_row)
        var vegRecipeTitle = view.findViewById<TextView>(R.id.textView_veg_row_title)
        var vegRecipeCategory = view.findViewById<TextView>(R.id.textView_veg_row_category)
        var vegRecipeTime = view.findViewById<TextView>(R.id.textView_meat_row_time)

    }



    }




