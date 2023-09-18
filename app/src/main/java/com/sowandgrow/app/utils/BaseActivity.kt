package com.sowandgrow.app.utils

import android.app.Activity
import android.app.Dialog
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.sowandgrow.app.R

open class BaseActivity : AppCompatActivity() {
    private lateinit var pb: Dialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
    }
    fun showProgressBar()
    {
        pb = Dialog(this)
        pb.setContentView(R.layout.progress_bar)
        pb.setCancelable(false)
        pb.show()
    }

    fun hideProgressBar()
    {
        pb.hide()
    }

    fun showToast(activity: Activity, msg:String)
    {
        Toast.makeText(activity,msg,Toast.LENGTH_SHORT).show()
    }
}