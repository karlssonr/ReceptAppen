package com.example.receptappen

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


class AdapterAddPhoto(private val context: Context): RecyclerView.Adapter<AdapterAddPhoto.ViewHolder>() {

     private val layoutInflater = LayoutInflater.from(context)

    override fun getItemCount(): Int {
        return 1
    }

/*    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

*//*        val cellForRow = layoutInflater.inflate(R.layout.add_photo_row, parent, false)
        return ViewHolder(cellForRow)*//*

    }*/

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.addPhotoImage.setOnClickListener {
            println("!!!")
        }

    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val addPhotoImage = itemView.findViewById<View>(R.id.add_photo_image)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }


}

