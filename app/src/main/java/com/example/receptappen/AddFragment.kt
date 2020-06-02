package com.example.receptappen

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.content.ContextCompat.checkSelfPermission
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.UploadTask
import kotlinx.android.synthetic.main.fragment_add.*
import java.io.IOException
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AddFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var imagePreview: ImageView? = null
    private val PICK_IMAGE_REQUEST = 1
    private var filePath: Uri? = null
    private var firebaseStorage: FirebaseStorage? = null
    private var storageReference: StorageReference? = null


    lateinit var ingredientTextInput: EditText
    lateinit var volumeTextInput: EditText
    lateinit var titleTextInput: EditText
    lateinit var descriptionTextInput: EditText
    lateinit var imageUrl: String
    lateinit var ingredientsToRecipe: MutableList<String>
    lateinit var choosenCategory: String
    lateinit var cookTimeTextInput: EditText
    lateinit var spinnerCategory : Spinner

    lateinit var ingredientsRecyclerView: RecyclerView


    val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add, container, false)
        val activity = activity as Context

        cookTimeTextInput = view.findViewById(R.id.text_input_cook_time)
        ingredientTextInput = view.findViewById(R.id.text_input_ingredient)
        titleTextInput = view.findViewById(R.id.text_input_title)
        descriptionTextInput = view.findViewById(R.id.text_input_description)
        spinnerCategory = view.findViewById(R.id.spinner_category)

        val addIngrediensButton = view.findViewById<Button>(R.id.button_add_ingrediens)
        val categoryList = arrayOf("VEG", "KÖTT", "FÅGEL", "FISK", "DESSERT")

        val spinnerAdapter = ArrayAdapter(activity, R.layout.support_simple_spinner_dropdown_item, categoryList)

        spinnerCategory.adapter = spinnerAdapter

        spinnerCategory.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
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

        val saveRecipeButton = view.findViewById<Button>(R.id.save_recipe_button) as Button
        ingredientsRecyclerView = view.findViewById<RecyclerView>(R.id.recyclerView_ingredients)

        ingredientsRecyclerView.layoutManager = LinearLayoutManager(activity)
        ingredientsRecyclerView.adapter = AdapterAddIngrediens(activity, DataStorage.ingredients)

        imagePreview = view.findViewById<ImageView>(R.id.add_photo_image) as ImageView

        firebaseStorage = FirebaseStorage.getInstance()
        storageReference = FirebaseStorage.getInstance().reference

        imagePreview!!.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (requireContext().checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {

                    val permissions = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE);


                    requestPermissions(permissions, PERMISSION_CODE);
                } else {
                    pickImageFromGallery()

                }
            } else {

                pickImageFromGallery()

            }
        }

        saveRecipeButton.setOnClickListener {

            if( titleTextInput.text.toString() == "" ) {
                Toast.makeText(activity, "Ange titel", Toast.LENGTH_SHORT).show()

            }

            if( ingredientTextInput.text.toString() == "" ) {
                Toast.makeText(activity, "Ange ingrediens", Toast.LENGTH_SHORT).show()

            }

            if( descriptionTextInput.text.toString() == "" ) {
                Toast.makeText(activity, "Ange beskrivning", Toast.LENGTH_SHORT).show()

            }

            if( cookTimeTextInput.text.toString() == "" ) {
                Toast.makeText(activity, "Ange tid", Toast.LENGTH_SHORT).show()

            }


            else {

                uploadImage()
                println("!!!! :  ${titleTextInput.text}")

            }




        }

        return view
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
    


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            PERMISSION_CODE -> {
                if (grantResults.size > 0 && grantResults[0] ==
                    PackageManager.PERMISSION_GRANTED
                ) {

                    pickImageFromGallery()
                } else {

                    Toast.makeText(activity, "Permission denied", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == PICK_IMAGE_REQUEST) {
            add_photo_image.setImageURI(data?.data)


            if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK) {
                if (data == null || data.data == null) {
                    return
                }

                filePath = data?.data
                try {
                    val bitmap = MediaStore.Images.Media.getBitmap(requireContext().contentResolver, filePath)
                    imagePreview?.setImageBitmap(bitmap)
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
        }
    }


    private fun uploadImage() {
        if (filePath != null) {
            val ref = storageReference?.child("uploads/" + UUID.randomUUID().toString())
            ref?.putFile(filePath!!)
                ?.addOnSuccessListener(OnSuccessListener<UploadTask.TaskSnapshot> {
                    imageUrl = ref.downloadUrl.toString()
                    uploadRecipe()

                    Toast.makeText(activity, "Image Uploaded", Toast.LENGTH_SHORT).show()
                })?.addOnFailureListener(OnFailureListener { e ->
                Toast.makeText(activity, "Image Uploading Failed " + e.message, Toast.LENGTH_SHORT)
                    .show()
            })
        } else {
            Toast.makeText(activity, "Please Select an Image", Toast.LENGTH_SHORT).show()
        }
    }

    private fun uploadRecipe() {
        val recipe = Recipe(
            titleTextInput?.text.toString(),
            choosenCategory,
            cookTimeTextInput?.text.toString(),
            imageUrl,
            DataStorage.ingredients?.toString(),
            descriptionTextInput?.text.toString()
        )

        db.collection("recipes").add(recipe)
    }



    companion object {

        private val IMAGE_PICK_CODE = 1000
        private val PERMISSION_CODE = 1001
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AddFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AddFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
