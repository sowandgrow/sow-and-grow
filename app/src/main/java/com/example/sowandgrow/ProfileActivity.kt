package com.example.sowandgrow

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class ProfileActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        auth = Firebase.auth
        val user = auth.currentUser

        val nameEditText = findViewById<EditText>(R.id.name)
        val emailEditText = findViewById<EditText>(R.id.email)
        val signOutButton = findViewById<Button>(R.id.button)

        nameEditText.setText(user?.displayName)
        emailEditText.setText(user?.email)

        signOutButton.setOnClickListener {
            if (auth.currentUser != null) {
                auth.signOut()
                val googleSignInClient = GoogleSignIn.getClient(this@ProfileActivity, GoogleSignInOptions.DEFAULT_SIGN_IN)
                googleSignInClient.signOut().addOnCompleteListener {
                    startActivity(Intent(this@ProfileActivity, SignInActivity::class.java))
                    finish()
                }
            }
        }
    }
}
