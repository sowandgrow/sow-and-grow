package com.example.sowandgrow

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import android.app.AlertDialog
import android.widget.Button
import com.google.firebase.FirebaseApp
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ProfileActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var userRef: DatabaseReference

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        auth = Firebase.auth
        val user = auth.currentUser
        FirebaseApp.initializeApp(this)

        val nameEditText = findViewById<EditText>(R.id.name)
        val emailEditText = findViewById<EditText>(R.id.email)
        val profileImageView = findViewById<ImageView>(R.id.profile_image)
        val locationInput = findViewById<TextInputEditText>(R.id.location)

        val database = FirebaseDatabase.getInstance()
        userRef = database.reference.child("users").child(auth.currentUser?.uid ?: "")

        // Fetch and display profile picture
        if (user?.photoUrl != null) {
            Glide.with(this@ProfileActivity)
                .load(user.photoUrl)
                .into(profileImageView)
        } else {
            // Set a default image or handle missing profile picture
        }

        userRef.child("hemisphere").addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val selectedHemisphere = snapshot.getValue(String::class.java)
                if (!selectedHemisphere.isNullOrEmpty()) {
                    locationInput.setText(selectedHemisphere)
                    Log.d("ProfileActivity", "Retrieved selected hemisphere: $selectedHemisphere")
                } else {
                    Log.d("ProfileActivity", "No selected hemisphere found in database")
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("ProfileActivity", "Database error: ${error.message}")
            }
        })

        locationInput.setOnClickListener {
            showHemisphereDialog(locationInput)
        }

        val signOutButton = findViewById<Button>(R.id.button)

        nameEditText.setText(user?.displayName)
        emailEditText.setText(user?.email)

        signOutButton.setOnClickListener {
            if (auth.currentUser != null) {
                auth.signOut()
                val googleSignInClient = GoogleSignIn.getClient(
                    this@ProfileActivity,
                    GoogleSignInOptions.DEFAULT_SIGN_IN
                )
                googleSignInClient.signOut().addOnCompleteListener {
                    startActivity(Intent(this@ProfileActivity, SignInActivity::class.java))
                    finish()
                }
            }
        }
    }

    private fun showHemisphereDialog(locationInput: TextInputEditText) {
        val options = arrayOf("Northern Hemisphere", "Southern Hemisphere")
        var selectedItem = -1 // No selection initially

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Choose a Hemisphere")
        builder.setSingleChoiceItems(options, selectedItem) { _, which ->
            selectedItem = which
        }
        builder.setPositiveButton("OK") { dialog, _ ->
            if (selectedItem != -1) {
                val selectedHemisphere = options[selectedItem]
                locationInput.setText(selectedHemisphere)

                Log.d("ProfileActivity", "Saving selected hemisphere: $selectedHemisphere")

                // Update selected hemisphere in Firebase Database
                userRef.child("hemisphere").setValue(selectedHemisphere)
            }
            dialog.dismiss()
        }
        builder.setNegativeButton("Cancel") { dialog, _ ->
            dialog.dismiss()
        }

        builder.show()
    }
}
