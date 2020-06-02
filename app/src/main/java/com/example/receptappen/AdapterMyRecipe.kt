package com.example.receptappen

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

class AdapterMyRecipe(private val context: Context, private val listOfRecipes: List<Recipe>) : RecyclerView.Adapter<AdapterMyRecipe.ViewHolder>() {

    private val layoutInflator = LayoutInflater.from(context)





    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val itemView = layoutInflator.inflate(R.layout.profile_my_recipe_recyclerview, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount() = listOfRecipes.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

}

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){



        init {

        }


    }
}