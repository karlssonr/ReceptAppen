package com.example.receptappen

import android.media.Image
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.StorageReference
import kotlinx.android.synthetic.main.activity_create_recipe.*
import kotlinx.android.synthetic.main.activity_home_screen_recycle.*



class ActivityCreateRecipe : AppCompatActivity() {

    var db = FirebaseFirestore.getInstance()
    lateinit var alertDialog: AlertDialog
    lateinit var storageReference: StorageReference



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_recipe)

        val addPhotoImage = findViewById<View>(R.id.add_photo_image)

        recycler_view_add_photo.layoutManager = LinearLayoutManager(this)
        recycler_view_add_photo.adapter = AdapterAddPhoto()

        alertDialog =

        addPhotoImage.setOnClickListener()




    }
}
