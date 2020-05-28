package com.example.receptappen

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

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
        holder.ingredientPosition = position
       // holder.textVolume.text = ingredient.volume
    }

    fun deleteIngredient(position: Int) {
        DataStorage.ingredients.removeAt(position)
        notifyDataSetChanged()
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var ingredientPosition = 0
        val textIngrediens = itemView.findViewById<TextView>(R.id.textView_ingredient)
        val deleteIngredientButton = itemView.findViewById<ImageButton>(R.id.imageButton_delete_ingredient)
        /*val textVolume = itemView.findViewById<TextView>(R.id.textView_volume)*/

        init {
            deleteIngredientButton.setOnClickListener {
                deleteIngredient(ingredientPosition)
                Snackbar.make(it, "Ingrediens borttagen", Snackbar.LENGTH_SHORT).show()
            }
        }


    }

}