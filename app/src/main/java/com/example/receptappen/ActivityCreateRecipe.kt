package com.example.receptappen

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.UploadTask
import kotlinx.android.synthetic.main.activity_create_recipe.*
import kotlinx.android.synthetic.main.activity_create_recipe.bottomNavigation
import kotlinx.android.synthetic.main.activity_home_screen_recycle.*
import java.io.IOException
import java.util.*
import kotlin.collections.ArrayList


class ActivityCreateRecipe : AppCompatActivity() {




    private var imagePreview: ImageView? = null
    private val PICK_IMAGE_REQUEST = 1
    private var filePath: Uri? = null
    private var firebaseStorage: FirebaseStorage? = null
    private var storageReference: StorageReference? = null


    lateinit var ingredientTextInput : EditText
    lateinit var volumeTextInput : EditText
    lateinit var titleTextInput : EditText
    lateinit var descriptionTextInput : EditText
    lateinit var imageUrl : String
    lateinit var ingredientsToRecipe : MutableList<String>
    lateinit var choosenCategory : String
    lateinit var cookTimeTextInput : String

    lateinit var ingredientsRecyclerView: RecyclerView


    val db = FirebaseFirestore.getInstance()


    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->

        when(item.itemId) {
            R.id.nav_bar_home -> {
                val intent = Intent(this, HomeScreenActivity::class.java)
                startActivity(intent)
                /* replaceFragment(HomeFragment())*/
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_bar_profile -> {
                val intent = Intent(this, HomeScreenActivity::class.java)
                startActivity(intent)
                return@OnNavigationItemSelectedListener true
            }
/*            R.id.nav_bar_add -> {
                val intent = Intent(this, ActivityCreateRecipe::class.java)
                startActivity(intent)
                return@OnNavigationItemSelectedListener true
            }*/
            R.id.nav_bar_favorite -> {
                val intent = Intent(this, HomeScreenActivity::class.java)
                startActivity(intent)
                /*replaceFragment(FavoriteFragment())*/
                return@OnNavigationItemSelectedListener true
            }


            else -> false
        }
    }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_recipe)

        cookTimeTextInput = ""



        ingredientTextInput = findViewById(R.id.text_input_ingredient)
       // volumeTextInput = findViewById(R.id.text_input_volume)
        titleTextInput = findViewById(R.id.text_input_title)
        descriptionTextInput = findViewById(R.id.text_input_description)

        val addIngrediensButton = findViewById<Button>(R.id.button_add_ingrediens)
        val categoryList = arrayOf("VEG", "KÖTT" , "FÅGEL", "FISK", "DESSERT")




        val spinnerAdapter = ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, categoryList)

        spinner_category.adapter = spinnerAdapter

        spinner_category.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                choosenCategory = categoryList[position]
            }

        }






        addIngrediensButton.setOnClickListener {

            addNewIngredient()
            ingredientsRecyclerView.adapter?.notifyDataSetChanged()


        }






        val saveRecipeButton = findViewById<Button>(R.id.save_recipe_button) as Button
        ingredientsRecyclerView = findViewById<RecyclerView>(R.id.recyclerView_ingredients)

        ingredientsRecyclerView.layoutManager = LinearLayoutManager(this)
        ingredientsRecyclerView.adapter = AdapterAddIngrediens(this, DataStorage.ingredients)

        imagePreview = findViewById<ImageView>(R.id.add_photo_image) as ImageView

        firebaseStorage = FirebaseStorage.getInstance()
        storageReference = FirebaseStorage.getInstance().reference






        add_photo_image.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {

                    val permissions = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE);


                    requestPermissions(permissions, PERMISSION_CODE);
                }
                else {
                    pickImageFromGallery()

                }
            }
            else {

                pickImageFromGallery()

            }
        }

        saveRecipeButton.setOnClickListener {
            uploadImage()


        }

        bottomNavigation.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

    }


    fun addNewIngredient() {
        val ingredient = ingredientTextInput.text.toString()
        //val volume = volumeTextInput.text.toString()

        val newIngredient = ingredient
        DataStorage.ingredients.add(newIngredient)
       // ingredientsToRecipe.add(ingredient)
    }

    private fun pickImageFromGallery() {

        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, PICK_IMAGE_REQUEST)
    }

    companion object {
        private val IMAGE_PICK_CODE = 1000
        private val PERMISSION_CODE = 1001
    }


    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when(requestCode){
            PERMISSION_CODE -> {
                if (grantResults.size >0 && grantResults[0] ==
                    PackageManager.PERMISSION_GRANTED){

                    pickImageFromGallery()
                }
                else{

                    Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == PICK_IMAGE_REQUEST){
            add_photo_image.setImageURI(data?.data)


            if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK) {
                if(data == null || data.data == null){
                    return
                }

                filePath = data?.data
                try {
                    val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, filePath)
                    imagePreview?.setImageBitmap(bitmap)
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
        }
    }


    private fun uploadImage(){
        if(filePath != null){
            val ref = storageReference?.child("uploads/" + UUID.randomUUID().toString())
            ref?.putFile(filePath!!)?.addOnSuccessListener(OnSuccessListener<UploadTask.TaskSnapshot> {
                imageUrl = ref.downloadUrl.toString()
                uploadRecipe()

                Toast.makeText(this, "Image Uploaded", Toast.LENGTH_SHORT).show()
            })?.addOnFailureListener(OnFailureListener { e ->
                Toast.makeText(this, "Image Uploading Failed " + e.message, Toast.LENGTH_SHORT).show()
            })
        }else{
            Toast.makeText(this, "Please Select an Image", Toast.LENGTH_SHORT).show()
        }
    }

    private fun uploadRecipe() {
        val recipe = Recipe(titleTextInput?.text.toString(), choosenCategory,  cookTimeTextInput,imageUrl, DataStorage.ingredients?.toString(), descriptionTextInput?.text.toString() )

        db.collection("recipes").add(recipe)
    }


}





