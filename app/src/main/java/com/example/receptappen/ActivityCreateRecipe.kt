package com.example.receptappen

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.media.Image
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import kotlinx.android.synthetic.main.activity_create_recipe.*
import kotlinx.android.synthetic.main.activity_home_screen_recycle.*
import kotlinx.android.synthetic.main.add_photo_row.*
import java.io.ByteArrayOutputStream
import java.io.IOException


class ActivityCreateRecipe : AppCompatActivity() {

    var db = FirebaseFirestore.getInstance()

    private val PICK_IMAGE_REQUEST = 71
    private var filePath: Uri? = null
    private var firebaseStore: FirebaseStorage? = null
    private var storageReference: StorageReference? = null





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_recipe)



        firebaseStore = FirebaseStorage.getInstance()
        storageReference = FirebaseStorage.getInstance().reference



        recycler_view_add_photo.layoutManager = LinearLayoutManager(this)
        recycler_view_add_photo.adapter = AdapterAddPhoto(this)






    }

    private fun launchGallery() {
            val intent = Intent()
            intent.type = "image/*"
            intent.action = Intent.ACTION_GET_CONTENT
            startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST)
        }

        private fun uploadImage(){
            TODO("Not Implemented")
        }

        override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK) {
            if(data == null || data.data == null){
                return
            }

            filePath = data.data

            try {
                add_photo_image.isDrawingCacheEnabled = true
                add_photo_image.buildDrawingCache()
                val bitmap = (add_photo_image.drawable as BitmapDrawable).bitmap
                val baos = ByteArrayOutputStream()
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos)
                val data = baos.toByteArray()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }

}
