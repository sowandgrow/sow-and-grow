package com.sowandgrow.app.auth

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import com.sowandgrow.app.databinding.ActivitySignInBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.sowandgrow.app.utils.BaseActivity
import com.sowandgrow.app.utils.MainActivity
import com.sowandgrow.app.R
import com.sowandgrow.app.utils.TransparentLottieAnimationView
import android.os.Handler


@Suppress("DEPRECATION")
class SignInActivity : BaseActivity() {
    private var binding: ActivitySignInBinding? = null
    private lateinit var auth: FirebaseAuth
    private lateinit var googleSignInClient: GoogleSignInClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        auth = Firebase.auth

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        googleSignInClient = GoogleSignIn.getClient(this, gso)
        // For Sign Up
        binding?.tvRegister?.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
            finish()
        }
        // Forgot Password Intent
        binding?.tvForgotPassword?.setOnClickListener {
            startActivity(Intent(this, ForgetPasswordActivity::class.java))
            finish()
        }

        binding?.btnSignIn?.setOnClickListener {
            signInUser()
        }

        binding?.btnSignInWithGoogle?.setOnClickListener { signInWithGoogle() }
    }


    private fun signInUser() {
        val email = binding?.etSinInEmail?.text.toString()
        val password = binding?.etSinInPassword?.text.toString()
        if (validateForm(email, password)) {
            showProgressBar()
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener{ task ->
                    if (task.isSuccessful) {
                        startActivity(Intent(this, MainActivity::class.java))
                        finish()
                        hideProgressBar()
                    } else {
                        showToast(this, "Can't login currently. Try after sometime")
                        hideProgressBar()
                    }
                }
        }
    }

    private fun signInWithGoogle() {
        val signInIntent = googleSignInClient.signInIntent
        launcher.launch(signInIntent)
    }

    private val launcher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult())
        { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
                handleResults(task)
            }
        }

    private fun handleResults(task: Task<GoogleSignInAccount>) {
        if (task.isSuccessful) {
            val account: GoogleSignInAccount? = task.result
            if (account != null) {
                updateUI(account)
            }
        } else {
            showToast(this, "Sign In Failed, Try again later!")
        }
    }

    fun updateUI(account: GoogleSignInAccount) {
        // Show the custom loading animation
        val lottieAnimationView = findViewById<TransparentLottieAnimationView>(R.id.lottie_animation_view)

        val credential = GoogleAuthProvider.getCredential(account.idToken, null)
        auth.signInWithCredential(credential).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                lottieAnimationView.visibility = View.VISIBLE
                lottieAnimationView.playAnimation()
                // Sign-in is successful, navigate to the main activity with a delay
                val intent = Intent(this, MainActivity::class.java)

                // Delay for 2 seconds (adjust as needed)
                Handler().postDelayed({
                    startActivity(intent)
                    finish()

                    // Hide the custom loading animation
                    lottieAnimationView.visibility = View.GONE
                    lottieAnimationView.cancelAnimation()
                }, 2000) // Delay for 2 seconds
            } else {
                // Sign-in encountered an error, display a message with a delay
                showToast(this, "Can't login currently. Try after sometime")

                // Hide the custom loading animation with a delay
                Handler().postDelayed({
                    lottieAnimationView.visibility = View.GONE
                    lottieAnimationView.cancelAnimation()
                }, 2000) // Delay for 2 seconds
            }
        }
    }



    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        val builder = AlertDialog.Builder(this)
        builder.setMessage("Are you sure you want to exit the app?")
            .setPositiveButton("Yes") { _, _ ->
                // If the user confirms, close the app
                finishAffinity()
            }
            .setNegativeButton("No") { _, _ ->
                // If the user cancels, do nothing
            }
            .create()
            .show()
    }

    private fun validateForm(email: String, password: String): Boolean {
        return when {
            TextUtils.isEmpty(email) && !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                binding?.tilEmail?.error = "Enter valid email address"
                false
            }

            TextUtils.isEmpty(password) -> {
                binding?.tilPassword?.error = "Enter password"
                false
            }
            else -> {
                true
            }
        }
    }
}