package com.sowandgrow.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.sowandgrow.app.ml.Detection3;

import org.tensorflow.lite.DataType;
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer;

import java.io.IOException;
import java.nio.ByteBuffer;

public class PlantDetection extends AppCompatActivity {

        Button selectBtn, predictBtn, captureBtn;
        TextView result;
        ImageView imageView;
        Bitmap bitmap;
        Camera camera; // Declare a Camera object

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_detection);

            // Permission
            getPermission();

            String[] labels = {
                    "Healthy Plants",
                    "Apple Black Rot",
                    "Corn Grey Leaf Spot",
                    "Grape Black Rot",
                    "Huanglongbing",
                    "Peach Bacterial Spot",
                    "Pepper Bell Bacterial Spot",
                    "Early Blight Of Potato",
                    "Potato Late Blight",
                    "Rice Leaf Blast",
                    "Rose Black Spot",
                    "Squash Powdery Mildew",
                    "Leaf Scorch Of Strawberry",
                    "Early Blight Of Tomato"
            };

            selectBtn = findViewById(R.id.selectBtn);
            predictBtn = findViewById(R.id.predictBtn);
            captureBtn = findViewById(R.id.captureBtn);
            result = findViewById(R.id.result);
            imageView = findViewById(R.id.imageView);

            // Initialize the Camera object
            camera = Camera.open();

            selectBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_GET_CONTENT);
                    intent.setType("image/*");
                    startActivityForResult(intent, 10);
                }
            });

            captureBtn.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent, 12);
                }
            });

            predictBtn.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){

                    try {
                        Detection3 model = Detection3.newInstance(PlantDetection.this);

                        if (bitmap == null) {
                            result.setText("Please select or capture an image.");
                            return;
                        }

                        // Create inputs for the model
                        TensorBuffer inputFeature0 = TensorBuffer.createFixedSize(new int[]{1, 224, 224, 3}, DataType.FLOAT32);

                        // Ensure the bitmap is valid and scaled to the desired dimensions
                        Bitmap scaledBitmap = Bitmap.createScaledBitmap(bitmap, 224, 224, true);

                        // Convert the scaled bitmap to a ByteBuffer
                        ByteBuffer byteBuffer = convertBitmapToByteBuffer(scaledBitmap);

                        // Load the ByteBuffer into inputFeature0
                        inputFeature0.loadBuffer(byteBuffer);

                        // Run model inference and get the result
                        Detection3.Outputs outputs = model.process(inputFeature0);
                        TensorBuffer outputFeature0 = outputs.getOutputFeature0AsTensorBuffer();

                        int predictedLabelIndex = getMax(outputFeature0.getFloatArray());
                        String predictedLabel = labels[predictedLabelIndex];

                        // Display the result
                        result.setText(predictedLabel);

                        // Open Google search or Wikipedia link based on the prediction
                        openLink(predictedLabel);

                        // Release model resources
                        model.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        int getMax(float[] arr){
            int max=0;
            for(int i=0; i<arr.length; i++){
                if(arr[i] > arr[max]) max=i;
            }
            return max;
        }

        void getPermission(){
            if(checkSelfPermission(android.Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(PlantDetection.this, new String[]{Manifest.permission.CAMERA}, 11);
            }
        }

        @Override
        public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
            if(requestCode==11){
                if(grantResults.length>0){
                    if(grantResults[0]!=PackageManager.PERMISSION_GRANTED){
                        this.getPermission();
                    }
                }
            }
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }

        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            if (requestCode == 10 && resultCode == RESULT_OK && data != null) {
                Uri uri = data.getData();
                try {
                    bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri);
                    imageView.setImageBitmap(bitmap);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else if (requestCode == 12 && resultCode == RESULT_OK && data != null) {
                bitmap = (Bitmap)data.getExtras().get("data");
                imageView.setImageBitmap(bitmap);
            }

            super.onActivityResult(requestCode, resultCode, data);
        }

        private ByteBuffer convertBitmapToByteBuffer(Bitmap bitmap) {
            int size = 224 * 224 * 3 * 4; // Assuming FLOAT32 data type
            ByteBuffer byteBuffer = ByteBuffer.allocateDirect(size);
            byteBuffer.order(java.nio.ByteOrder.nativeOrder());

            int[] pixels = new int[224 * 224];
            bitmap.getPixels(pixels, 0, 224, 0, 0, 224, 224);

            for (int pixelValue : pixels) {
                // Extract the RGB values from the pixelValue
                float r = ((pixelValue >> 16) & 0xFF) / 255.0f;
                float g = ((pixelValue >> 8) & 0xFF) / 255.0f;
                float b = (pixelValue & 0xFF) / 255.0f;

                // Add the RGB values to the ByteBuffer
                byteBuffer.putFloat(r);
                byteBuffer.putFloat(g);
                byteBuffer.putFloat(b);
            }

            return byteBuffer;
        }

        private void openLink(String predictedLabel) {
            // Create a Google search or Wikipedia link based on the predicted label
            String searchQuery = "https://www.google.com/search?q=" + predictedLabel;
            String wikipediaLink = "https://en.wikipedia.org/wiki/" + predictedLabel.replace(" ", "_");

            // Choose either Google search or Wikipedia link based on your preference
            String linkToOpen = searchQuery; // You can change this to wikipediaLink if needed

            // Open the link in a web browser
            Intent browserIntent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(linkToOpen));
            startActivity(browserIntent);
        }

        @Override
        protected void onDestroy() {
            super.onDestroy();
            // Release the camera resource when the activity is destroyed
            if (camera != null) {
                camera.release();
            }
        }
    }