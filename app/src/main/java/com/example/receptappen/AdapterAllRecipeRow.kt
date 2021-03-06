package com.example.receptappen

import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class AdapterAllRecipeRow(private val context: Context, private val listOfRecipes: List<Recipe>, private val homeFragment: HomeFragment): RecyclerView.Adapter<AdapterAllRecipeRow.CustomViewHolder>() {

    private val layoutInflator = LayoutInflater.from(context)






    override fun getItemCount() = listOfRecipes.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {

        val itemView = layoutInflator.inflate(R.layout.all_recipe_row, parent, false)
        return CustomViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {



        val recipe = listOfRecipes[position]

        Picasso.with(context).load(recipe.image).into(holder.allRecipeImage)
        holder.allRecipeCategory.text = recipe.category
        holder.allRecipeTime.text = recipe.cookTime
        holder.allRecipeTitle.text = recipe.title

        if (recipe.category == "KÖTT") {
            holder.allRecipeCategory.setBackgroundResource(R.drawable.round_corner_meat)
        }

        if (recipe.category == "VEG") {
            holder.allRecipeCategory.setBackgroundResource(R.drawable.round_corner_veg)
        }

        if (recipe.category == "FÅGEL") {
            holder.allRecipeCategory.setBackgroundResource(R.drawable.round_corner_chicken)
        }

        if (recipe.category == "FISK") {
            holder.allRecipeCategory.setBackgroundResource(R.drawable.round_corner_fish)
        }

        if (recipe.category == "DESSERT") {
            holder.allRecipeCategory.setBackgroundResource(R.drawable.round_corner_dessert)
        }





        holder.allRecipeCardView.setOnClickListener {


            holder.bundle.putString("allRecipeImage" , recipe.image )
            holder.bundle.putString("allRecipeTitle" , recipe.title )
            holder.bundle.putString("allRecipeCategory" , recipe.category )
            holder.bundle.putString("allRecipeTime" , recipe.cookTime )
            holder.bundle.putString("allRecipeDescription" , recipe.description )
            holder.bundle.putString("allRecipeIngrediens" , recipe.ingredients )

                holder.choosenRecipeFragment.arguments = holder.bundle
                homeFragment.activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.fragment_container, holder.choosenRecipeFragment)?.commit()



        }



    }





    inner class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view) {

        var allRecipeImage = view.findViewById<ImageView>(R.id.imageView_all_recipe_row)
        var allRecipeTitle = view.findViewById<TextView>(R.id.textView_all_recipe_row_title)
        var allRecipeCategory = view.findViewById<TextView>(R.id.textView_all_recipe_row_category)
        var allRecipeTime = view.findViewById<TextView>(R.id.textView_all_recipe_row_time)
        val allRecipeCardView = view.findViewById<CardView>(R.id.cardView_all_recipe_row)

        val bundle = Bundle()
        val choosenRecipeFragment = ChoosenRecipeFragment()




    }


}
