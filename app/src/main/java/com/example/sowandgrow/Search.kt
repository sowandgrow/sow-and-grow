package com.example.sowandgrow;

import android.Manifest
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.sowandgrow.DiscoverPlant
import com.example.sowandgrow.R
import com.google.android.material.textfield.TextInputEditText

class Search : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_search, container, false)

        // Find the TextInputEditText
        val nameEditText: TextInputEditText = view.findViewById(R.id.searchBox)
        nameEditText.keyListener = null

        // Set up the click listener for TextInputEditText
        nameEditText.setOnClickListener {
            //Create an Intent to navigate to MyPlantFragments
            val intent = Intent(activity, DiscoverPlant::class.java)

            // Optionally, you can add extras to the intent if needed
            // intent.putExtra("key", "value")

            // Start the activity with the intent
            startActivity(intent)
        }

        // Find the ImageView
        val imageView: ImageView = view.findViewById(R.id.imageView)
        imageView.setOnClickListener {
            showImagePickerDialog()
        }

        return view
    }

    private fun showImagePickerDialog() {
        val options = arrayOf("Take Photo", "Choose from Gallery", "Cancel")

        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Choose an option")
        builder.setItems(options) { dialog: DialogInterface, item: Int ->
            when (options[item]) {
                "Take Photo" -> {
                    // Check camera permission
                    if (ContextCompat.checkSelfPermission(
                            requireContext(),
                            Manifest.permission.CAMERA
                        ) == PackageManager.PERMISSION_GRANTED
                    ) {
                        // Launch camera intent
                        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                        startActivity(takePictureIntent)
                    } else {
                        // Request camera permission
                        ActivityCompat.requestPermissions(
                            requireActivity(),
                            arrayOf(Manifest.permission.CAMERA),
                            CAMERA_PERMISSION_REQUEST
                        )
                    }
                }
                "Choose from Gallery" -> {
                    // Launch gallery intent
                    val pickPhotoIntent =
                        Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                    startActivity(pickPhotoIntent)
                }
                "Cancel" -> {
                    dialog.dismiss()
                }
            }
        }
        builder.show()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == CAMERA_PERMISSION_REQUEST) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted, launch camera intent
                val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivity(takePictureIntent)
            }
        }
    }

    companion object {
        private const val ARG_PARAM1 = "param1"
        private const val ARG_PARAM2 = "param2"
        private const val CAMERA_PERMISSION_REQUEST = 1001
    }
}
