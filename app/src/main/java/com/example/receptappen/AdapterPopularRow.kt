package com.example.receptappen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class AdapterPopularRow: RecyclerView.Adapter<AdapterPopularRow.CustomViewHolder>() {



    override fun getItemCount(): Int {
        return 7
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.popular_row, parent, false)
        return CustomViewHolder(cellForRow)

    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {


    }

    class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view) {

    }



}

