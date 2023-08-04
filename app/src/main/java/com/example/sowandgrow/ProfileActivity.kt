package com.example.sowandgrow

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class ProfileActivity : AppCompatActivity() {

    private lateinit var profilePictureImageView: ImageView
    private lateinit var addressTextView: TextView
    private lateinit var nameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var locationEditText: EditText
    private lateinit var signOutButton: Button

    private lateinit var auth: FirebaseAuth
    private lateinit var googleSignInClient: GoogleSignInClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // Initialize views
        profilePictureImageView = findViewById(R.id.imgUser)
        addressTextView = findViewById(R.id.tv_address)
        nameEditText = findViewById(R.id.name)
        emailEditText = findViewById(R.id.email)
        locationEditText = findViewById(R.id.location)
        signOutButton = findViewById(R.id.button)

        auth = Firebase.auth
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        googleSignInClient = GoogleSignIn.getClient(this, gso)

        // Fetch user data from Firebase and populate views
        val user: FirebaseUser? = auth.currentUser
        user?.let {
            val name = user.displayName ?: getString(R.string.default_name)
            val email = user.email ?: getString(R.string.default_email)
            // The user's location is not typically stored in the FirebaseUser object, you need to store and retrieve this information separately.
            // For this example, let's assume you have a method that fetches this information:
            val location = getLocationForUser(user) ?: getString(R.string.default_location)
            val profilePictureUrl = user.photoUrl?.toString() ?: ""

            nameEditText.setText(name)
            emailEditText.setText(email)
            locationEditText.setText(location)

            // Load profile picture using an image loading library like Glide or Picasso
            Glide.with(this).load(profilePictureUrl).into(profilePictureImageView)
        }

        // Set click listeners
        signOutButton.setOnClickListener {
            // Sign out the user from Firebase
            if(auth.currentUser != null){
                auth.signOut()
                // Sign out the user from Google
                googleSignInClient.signOut().addOnCompleteListener {
                    // Go back to the SignInActivity after successfully signing out
                    startActivity(Intent(this, SignInActivity::class.java))
                    finish()
                }
            }
        }
    }

    // This method is a placeholder, you'll need to implement it with your own logic
    private fun getLocationForUser(user: FirebaseUser): String? {
        return null
    }
}










