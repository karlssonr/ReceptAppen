package com.example.receptappen

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore

class AdapterVegRow(private val context: Context, private val vegitarianRecipes: List<Recipe>): RecyclerView.Adapter<AdapterVegRow.CustomViewHolder>() {



    private val layoutInflator = LayoutInflater.from(context)






    override fun getItemCount() = vegitarianRecipes.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {

        val itemView = layoutInflator.inflate(R.layout.veg_row, parent, false)
        return CustomViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {

        val vegRecipeImage = holder.view.findViewById<ImageView>(R.id.imageView_veg_row)
        val vegRecipeTitle = holder.view.findViewById<TextView>(R.id.textView_veg_row_title)
        val vegRecipeCategory = holder.view.findViewById<TextView>(R.id.textView_veg_row_category)
        val vegRecipeTime = holder.view.findViewById<TextView>(R.id.textView_veg_row_time)

        /*vegRecipeCategory = vegitarianReci*/



        }




    class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view) {

    }



    }




