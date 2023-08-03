package com.example.sowandgrow

import android.content.Intent
import android.os.Bundle
import android.view.View
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
    private lateinit var nameTextView: TextView
    private lateinit var locationTextView: TextView
    private lateinit var emailTextView: TextView
    private lateinit var nameEditText: EditText
    private lateinit var locationEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var editButton: Button
    private lateinit var saveButton: Button
    private lateinit var signOutButton: Button

    private lateinit var auth: FirebaseAuth
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var googleSignInClient: GoogleSignInClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // Initialize views
        profilePictureImageView = findViewById(R.id.profile_picture_image_view)
        nameTextView = findViewById(R.id.name_text_view)
        locationTextView = findViewById(R.id.location_text_view)
        emailTextView = findViewById(R.id.email_text_view)
        nameEditText = findViewById(R.id.name_edit_text)
        locationEditText = findViewById(R.id.location_edit_text)
        emailEditText = findViewById(R.id.email_edit_text)
        editButton = findViewById(R.id.edit_button)
        saveButton = findViewById(R.id.save_button)
        signOutButton = findViewById(R.id.sign_out_button)

        firebaseAuth = FirebaseAuth.getInstance()
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        googleSignInClient = GoogleSignIn.getClient(this, gso)

        // Fetch user data from Firebase and populate views
        val user: FirebaseUser? = firebaseAuth.currentUser
        user?.let {
            val name = user.displayName ?: getString(R.string.default_name)
            val email = user.email ?: getString(R.string.default_email)
            val profilePictureUrl = user.photoUrl?.toString() ?: ""

            nameTextView.text = name
            emailTextView.text = email

            // Load profile picture using an image loading library like Glide or Picasso
            Glide.with(this).load(profilePictureUrl).into(profilePictureImageView)
        }

        // Set click listeners
        editButton.setOnClickListener {
            // Show edit mode
            nameEditText.setText(nameTextView.text)
            locationEditText.setText(locationTextView.text)
            emailEditText.setText(emailTextView.text)

            // Toggle visibility
            nameTextView.visibility = View.GONE
            locationTextView.visibility = View.GONE
            emailTextView.visibility = View.GONE

            nameEditText.visibility = View.VISIBLE
            locationEditText.visibility = View.VISIBLE
            emailEditText.visibility = View.VISIBLE

            editButton.visibility = View.GONE
            saveButton.visibility = View.VISIBLE
        }

        saveButton.setOnClickListener {
            // Get the edited values from the input boxes
            val editedName = nameEditText.text.toString()
            val editedLocation = locationEditText.text.toString()
            val editedEmail = emailEditText.text.toString()

            // TODO: Update the corresponding Firebase database nodes with the edited information

            // Hide input boxes and show text views
            nameTextView.text = editedName
            locationTextView.text = editedLocation
            emailTextView.text = editedEmail

            nameEditText.visibility = View.GONE
            locationEditText.visibility = View.GONE
            emailEditText.visibility = View.GONE

            nameTextView.visibility = View.VISIBLE
            locationTextView.visibility = View.VISIBLE
            emailTextView.visibility = View.VISIBLE

            editButton.visibility = View.VISIBLE
            saveButton.visibility = View.GONE
        }
        auth = Firebase.auth
        signOutButton.setOnClickListener {
            // Sign out the user from Firebase
            if(auth.currentUser != null){
                firebaseAuth.signOut()
            // Sign out the user from Google
            googleSignInClient.signOut().addOnCompleteListener {
                // Go back to the SignInActivity after successfully signing out
                startActivity(Intent(this, SignInActivity::class.java))
                finish()
                }
            }
        }
    }
}



