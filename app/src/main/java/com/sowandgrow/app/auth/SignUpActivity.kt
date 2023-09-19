package com.sowandgrow.app.auth

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.util.Patterns
import android.widget.ImageView
import android.widget.Toast
import com.sowandgrow.app.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.sowandgrow.app.R
import com.sowandgrow.app.utils.BaseActivity

class SignUpActivity : BaseActivity() {

    private var binding: ActivitySignUpBinding? = null
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        auth = Firebase.auth

        binding?.tvLoginPage?.setOnClickListener {
            startActivity(Intent(this, SignInActivity::class.java))
            finish()
        }

        binding?.btnSignUp?.setOnClickListener { registerUser() }

        val backButton = findViewById<ImageView>(R.id.backButton)

        backButton.setOnClickListener {
            val signInIntent = Intent(this, SignInActivity::class.java)
            startActivity(signInIntent)
        }

    }

    @Deprecated("Deprecated in Java", ReplaceWith(
        "startActivity(Intent(this, SignInActivity::class.java))",
        "android.content.Intent"
    )
    )
    override fun onBackPressed() {
        startActivity(Intent(this, SignInActivity::class.java))
    }

    private fun registerUser() {
        val name = binding?.etSinUpName?.text.toString()
        val email = binding?.etSinUpEmail?.text.toString()
        val password = binding?.etSinUpPassword?.text.toString()

        if (validateForm(name, email, password)) {
            showProgressBar()
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        showToast(this, "User Id Created successfully")
                        hideProgressBar()

                        val intent = Intent(this, SignInActivity::class.java)
                        intent.putExtra("userName", name)
                        startActivity(intent)
                        finish()
                    } else {
                        val errorMessage =
                            task.exception?.message ?: "Registration Failed, Please Try Again"
                        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
                        hideProgressBar()
                        Log.e("SignUpActivity", "Error during sign-up: $errorMessage")
                    }
                }
        }
    }

    private fun validateForm(name: String, email: String, password: String): Boolean {
        return when {
            TextUtils.isEmpty(name) -> {
                binding?.tilName?.error = "Enter name"
                false
            }

            TextUtils.isEmpty(email) || !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                binding?.tilEmail?.error = "Enter valid email address"
                false
            }

            TextUtils.isEmpty(password) -> {
                binding?.tilPassword?.error = "Enter password"
                false
            }

            else -> true
        }
    }
}
