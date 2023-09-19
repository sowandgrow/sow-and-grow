package com.sowandgrow.app.auth

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.view.View
import android.widget.ImageView
import com.sowandgrow.app.databinding.ActivityForgetPasswordBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.sowandgrow.app.R
import com.sowandgrow.app.utils.BaseActivity

class ForgetPasswordActivity : BaseActivity() {
    private var binding: ActivityForgetPasswordBinding? = null
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityForgetPasswordBinding.inflate(layoutInflater)

        setContentView(binding?.root)

        auth = Firebase.auth

        binding?.btnForgotPasswordSubmit?.setOnClickListener {
            resetPassword()
        }

        val backButton = findViewById<ImageView>(R.id.backButton)
        backButton.setOnClickListener {
            val signInIntent = Intent(this, SignInActivity::class.java)
            startActivity(signInIntent)
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        startActivity(Intent(this, SignInActivity::class.java))
        finish()
    }

    private fun resetPassword() {
        val email = binding?.etForgotPasswordEmail?.text.toString()
        if (validateEmail(email)) {
            showProgressBar()
            auth.sendPasswordResetEmail(email).addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    binding?.tilEmailForgetPassword?.visibility = View.GONE
                    binding?.tvSubmitMsg?.visibility = View.VISIBLE
                    binding?.btnForgotPasswordSubmit?.visibility = View.GONE
                    hideProgressBar()
                } else {
                    hideProgressBar()
                    showToast(this, "Reset password failed, try again latter")
                }
            }
        }
    }

    private fun validateEmail(email: String): Boolean {
        return if (TextUtils.isEmpty(email) && !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding?.tilEmailForgetPassword?.error = "Enter valid email address"
            false
        } else {
            binding?.tilEmailForgetPassword?.error = null
            true
        }
    }
}