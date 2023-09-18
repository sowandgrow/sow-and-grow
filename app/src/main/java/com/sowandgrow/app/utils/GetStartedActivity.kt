package com.sowandgrow.app.utils

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sowandgrow.app.databinding.ActivityGetStartedBinding
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.sowandgrow.app.auth.SignInActivity

class GetStartedActivity : AppCompatActivity() {
    private var binding: ActivityGetStartedBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGetStartedBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.cvGetStarted?.setOnClickListener {
            startActivity(Intent(this, SignInActivity::class.java))
            finish()
        }
        val auth = Firebase.auth
        if (auth.currentUser != null){
            startActivity(Intent(this, MainActivity::class.java))
        finish()
        }
    }
}
