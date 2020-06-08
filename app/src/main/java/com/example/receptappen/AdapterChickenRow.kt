package com.example.receptappen

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class AdapterChickenRow(private val context : Context, private val chickenRecipes : List<Recipe>, private val homeFragment: HomeFragment) : RecyclerView.Adapter<AdapterChickenRow.CustomViewHolder>() {

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

        holder.chickenRecipeCardview.setOnClickListener {

            holder.bundle.putString("chickenRecipeImage" , recipe.image )
            holder.bundle.putString("chickenRecipeTitle" , recipe.title )
            holder.bundle.putString("chickenRecipeCategory" , recipe.category )
            holder.bundle.putString("chickenRecipeTime" , recipe.cookTime )
            holder.bundle.putString("chickenRecipeDescription" , recipe.description )
            holder.bundle.putString("chickenRecipeIngrediens" , recipe.ingredients )

            holder.choosenRecipeFragment.arguments = holder.bundle
            homeFragment.activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.fragment_container, holder.choosenRecipeFragment)?.commit()





        }
    }

    inner class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view) {

        var chickenRecipeImage = view.findViewById<ImageView>(R.id.imageView_chicken_row)
        var chickenRecipeTitle = view.findViewById<TextView>(R.id.textView_chicken_row_title)
        var chickenRecipeCategory = view.findViewById<TextView>(R.id.textView_chicken_row_category)
        var chickenRecipeTime = view.findViewById<TextView>(R.id.textView_chicken_row_time)

        val chickenRecipeCardview = view.findViewById<CardView>(R.id.cardview_chicken_row)

        val bundle = Bundle()
        val choosenRecipeFragment = ChoosenRecipeFragment()

    }
}