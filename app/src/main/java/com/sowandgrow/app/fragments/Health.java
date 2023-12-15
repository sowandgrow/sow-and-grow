package com.sowandgrow.app.fragments;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.activity.OnBackPressedCallback;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.sowandgrow.app.PlantDetection;
import com.sowandgrow.app.R;

public class Health extends Fragment {

    private static final int CAMERA_PERMISSION_REQUEST = 111;

    private final OnBackPressedCallback callback = new OnBackPressedCallback(true) {
        @Override
        public void handleOnBackPressed() {
            // Handle the back button press here to exit the app
            requireActivity().finishAffinity(); // This will close the current activity and all its parent activities.
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_health, container, false);
        ImageView openCameraImageView = view.findViewById(R.id.opencamera);

        // Set an OnClickListener on the ImageView
        openCameraImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check and request camera permission
                if (checkCameraPermission()) {
                    // Camera permission granted, navigate to PlantDetection activity
                    navigateToPlantDetection();
                } else {
                    // Request camera permission
                    requestCameraPermission();
                }
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Add the callback to override the back button press
        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), callback);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        // Remove the callback when the fragment is destroyed
        callback.remove();
    }

    private boolean checkCameraPermission() {
        return ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED;
    }

    private void requestCameraPermission() {
        ActivityCompat.requestPermissions(requireActivity(), new String[]{Manifest.permission.CAMERA}, CAMERA_PERMISSION_REQUEST);
    }

    private void navigateToPlantDetection() {
        // Redirect to PlantDetection activity
        Intent intent = new Intent(requireActivity(), PlantDetection.class);
        startActivity(intent);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == CAMERA_PERMISSION_REQUEST) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Camera permission granted, navigate to PlantDetection activity
                navigateToPlantDetection();
            } else {
                // Permission denied, show a message or take appropriate action
            }
        }
    }
}
