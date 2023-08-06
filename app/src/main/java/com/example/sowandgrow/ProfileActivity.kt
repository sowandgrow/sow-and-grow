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
import android.content.SharedPreferences
import android.widget.Button

class ProfileActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var sharedPreferences: SharedPreferences

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        auth = Firebase.auth
        val user = auth.currentUser
        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)

        val nameEditText = findViewById<EditText>(R.id.name)
        val emailEditText = findViewById<EditText>(R.id.email)
        val profileImageView = findViewById<ImageView>(R.id.profile_image)
        val locationInput = findViewById<TextInputEditText>(R.id.location)

        // Fetch and display profile picture
        if (user?.photoUrl != null) {
            Glide.with(this@ProfileActivity)
                .load(user.photoUrl)
                .into(profileImageView)
        } else {
            // Set a default image or handle missing profile picture
        }

        // Retrieve selected hemisphere from SharedPreferences
        val selectedHemisphere = sharedPreferences.getString("selectedHemisphere", "")
        locationInput.setText(selectedHemisphere)

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

                // Save selected hemisphere in SharedPreferences
                sharedPreferences.edit().putString("selectedHemisphere", selectedHemisphere).apply()
            }
            dialog.dismiss()
        }
        builder.setNegativeButton("Cancel") { dialog, _ ->
            dialog.dismiss()
        }

        builder.show()
    }
}
