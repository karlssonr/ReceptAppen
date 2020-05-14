package com.example.receptappen

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore


class MainActivity : AppCompatActivity() {

    val mAuth = FirebaseAuth.getInstance()
    val db = FirebaseFirestore.getInstance()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val logInButton = findViewById<View>(R.id.log_in_button)



/*                val recipe = Recipe("Tomat Soppa", "VEG", "20min","@drawable/tomatsoppa", "Smör, Gul lök, Tomater/Krossade tomater Vatten Vispgrädde/Mjölk, Svartpeppar",
            "Hacka den gula löken fint. Hetta upp smöret\n" +
                    "i en kastrul," +
                    "" )

        db.collection("recipes").add(recipe)*/





        logInButton.setOnClickListener(View.OnClickListener {
                view -> login() })
    }


    private fun login() {
        val emailText = findViewById<View>(R.id.emailText) as EditText
        val passwordText = findViewById<View>(R.id.passwordText) as EditText

        var email = emailText.text.toString()
        var password = passwordText.text.toString()

        if (!email.isEmpty() && !password.isEmpty()) {

            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                val intent = Intent(this, HomeScreenActivity::class.java)
                if (task.isSuccessful) {
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Fel användarnamn eller lösenord", Toast.LENGTH_LONG).show()
                }
            }

        } else {
            Toast.makeText(this, "Fyll i inloggnings uppgifter", Toast.LENGTH_LONG).show()
        }
    }

}












/*
        db.collection("users")
            .get()
            .addOnCompleteListener(OnCompleteListener<QuerySnapshot> { task ->
                if (task.isSuccessful) {
                    for (document in task.result!!) {
                        Log.d(
                            "!!!",
                            document.id + " => " + document.data
                        )
                    }
                } else {
                    Log.w("!!!", "Error getting documents.", task.exception)
                }
            })*/


/*       logInButton.setOnClickListener {
          val intent = Intent(this, HomeScreenActivity::class.java)
          startActivity(intent)
       }*/