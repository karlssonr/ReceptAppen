package com.example.receptappen

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterAddIngrediens(private val context: Context, private val ingredients: List<String>) : RecyclerView.Adapter<AdapterAddIngrediens.ViewHolder>() {


    private val layoutInflator = LayoutInflater.from(context)








    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = layoutInflator.inflate(R.layout.ingredients_recycler_view, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount() = ingredients.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ingredient = ingredients[position]

        holder.textIngrediens.text = ingredient
       // holder.textVolume.text = ingredient.volume
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val textIngrediens = itemView.findViewById<TextView>(R.id.textView_ingredient)
        /*val textVolume = itemView.findViewById<TextView>(R.id.textView_volume)*/


    }

}