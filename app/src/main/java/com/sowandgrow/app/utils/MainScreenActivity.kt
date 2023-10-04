package com.sowandgrow.app.utils

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.sowandgrow.app.databinding.ActivityMainScreenBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.sowandgrow.app.R
import com.sowandgrow.app.fragments.Health
import com.sowandgrow.app.fragments.MyGarden
import com.sowandgrow.app.fragments.Discover

class MainScreenActivity : BaseActivity() {

    private lateinit var binding: ActivityMainScreenBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = Firebase.auth

        replaceFragment(Discover())

        binding.bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.search -> replaceFragment(Discover())
                R.id.health -> replaceFragment(Health())
                R.id.mygarden -> replaceFragment(MyGarden())
                else -> {
                    // Handle other menu items if needed
                }
            }
            true
        }
    }
    private fun setProfilePicture() {
        val user = firebaseAuth.currentUser
        if (user != null) {
            // User is signed in, fetch the profile picture from Firebase Auth.
            val photoUrl = user.photoUrl
            if (photoUrl != null) {
                // Load the user's profile picture into the button (using Glide, Picasso, or any other image-loading library).
                // For example, with Glide:
                // Glide.with(this).load(photoUrl).into(binding.profilePictureButton)
            } else {
                // If the user has no profile picture, you can set a default blank profile picture.
                // For example, with Glide:
                // Glide.with(this).load(R.drawable.blank_profile).into(binding.profilePictureButton)
            }
        } else {
            // User is not signed in, show the default blank profile picture.
            // For example, with Glide:
            // Glide.with(this).load(R.drawable.blank_profile).into(binding.profilePictureButton)
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }
}
