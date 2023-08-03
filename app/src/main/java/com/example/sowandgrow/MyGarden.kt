package com.example.sowandgrow

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton

class MyGarden : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_my_garden, container, false)

        // Find the ImageButton and set its click listener
        val profilePictureButton: ImageButton = rootView.findViewById(R.id.profilePictureButton)
        profilePictureButton.setOnClickListener {
            // Launch ProfileActivity when the button is clicked
            val intent = Intent(activity, ProfileActivity::class.java)
            startActivity(intent)
        }

        return rootView
    }

    companion object {
        @JvmStatic
        fun newInstance() = MyGarden()
    }
}
