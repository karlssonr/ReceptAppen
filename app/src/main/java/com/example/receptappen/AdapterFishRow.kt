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

class AdapterFishRow(private val context: Context, private val fishRecipes: List<Recipe>, private val homeFragment: HomeFragment): RecyclerView.Adapter<AdapterFishRow.CustomViewHolder>() {

    private val layoutInflator = LayoutInflater.from(context)

    override fun getItemCount() = fishRecipes.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {

        val itemView = layoutInflator.inflate(R.layout.fish_row, parent, false)
        return CustomViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {



        val recipe = fishRecipes[position]

        Picasso.with(context).load(recipe.image).into(holder.fishRecipeImage)
        holder.fishRecipeCategory.text = recipe.category
        holder.fishRecipeTime.text = recipe.cookTime
        holder.fishRecipeTitle.text = recipe.title

        holder.fishRecipeCardview.setOnClickListener {
            holder.bundle.putString("fishRecipeImage" , recipe.image )
            holder.bundle.putString("fishRecipeTitle" , recipe.title )
            holder.bundle.putString("fishRecipeCategory" , recipe.category )
            holder.bundle.putString("fishRecipeTime" , recipe.cookTime )
            holder.bundle.putString("fishRecipeDescription" , recipe.description )
            holder.bundle.putString("fishRecipeIngrediens" , recipe.ingredients )

            holder.choosenRecipeFragment.arguments = holder.bundle
            homeFragment.activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.fragment_container, holder.choosenRecipeFragment)?.commit()

        }



    }




    inner class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view) {

        var fishRecipeImage = view.findViewById<ImageView>(R.id.imageView_fish_row)
        var fishRecipeTitle = view.findViewById<TextView>(R.id.textView_fish_row_title)
        var fishRecipeCategory = view.findViewById<TextView>(R.id.textView_fish_row_category)
        var fishRecipeTime = view.findViewById<TextView>(R.id.textView_fish_row_time)

        val fishRecipeCardview = view.findViewById<CardView>(R.id.cardview_fish_row)


        val bundle = Bundle()
        val choosenRecipeFragment = ChoosenRecipeFragment()

    }

}