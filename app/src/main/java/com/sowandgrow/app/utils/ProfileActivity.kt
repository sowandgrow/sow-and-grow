package com.sowandgrow.app.utils

import android.app.AlertDialog
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Bitmap
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.sowandgrow.app.R
import com.sowandgrow.app.auth.SignInActivity
import com.sowandgrow.app.notifications.NotificationScheduler
import de.hdodenhof.circleimageview.CircleImageView


class ProfileActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var profileImage: CircleImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        profileImage = findViewById(R.id.profile_image)

        auth = Firebase.auth
        val user = auth.currentUser
        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)
        val nameEditText = findViewById<EditText>(R.id.name)
        val emailEditText = findViewById<EditText>(R.id.email)
        val profileImageView = findViewById<CircleImageView>(R.id.profile_image)
        val locationInput = findViewById<TextInputEditText>(R.id.location)

        // Retrieve user's name from intent extras
        val userName = intent.getStringExtra("userName")

        // Set the retrieved name in the nameEditText
        nameEditText.setText(userName)
        // Set the display name from Firebase user data
        nameEditText.setText(user?.displayName)

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

        // Set an OnEditorActionListener to nameEditText
        nameEditText.setOnEditorActionListener { _, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE || (event?.keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_DOWN)) {
                val newName = nameEditText.text.toString()
                updateUserDisplayName(newName)
                return@setOnEditorActionListener true
            }
            false
        }

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

        val backButton = findViewById<ImageView>(R.id.backButton)

        backButton.setOnClickListener {
            finish()
        }


        val notificationReminder = findViewById<ImageView>(R.id.notificationReminder)

        notificationReminder.setOnClickListener {
            startActivity(Intent(this, NotificationScheduler::class.java))
        }
    }

    private fun updateUserDisplayName(newName: String) {
        val user = auth.currentUser
        if (user != null) {
            val profileUpdates = UserProfileChangeRequest.Builder()
                .setDisplayName(newName)
                .build()

            user.updateProfile(profileUpdates)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        showToast("Display name updated")
                    } else {
                        showToast("Failed to update display name")
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

    private fun showToast(message: String) {
        Toast.makeText(this@ProfileActivity, message, Toast.LENGTH_SHORT).show()
    }
}