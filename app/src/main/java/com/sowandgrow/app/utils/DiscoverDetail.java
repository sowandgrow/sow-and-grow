package com.sowandgrow.app.utils;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sowandgrow.app.R;

public class DiscoverDetail extends AppCompatActivity {

    ImageView discoverPlantImage, backbtn;
    TextView discoverBotanicalName, discoverPlantName, discoverPlantType, discoverBloomTime, discoverPlantColor,
            discoverNativeArea, discoverToxicity, discoverSunExposure, discoverCare, discoverWater, discoverSun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discover_detail);

        discoverPlantImage = findViewById(R.id.discoverPlantImage);
        discoverBotanicalName = findViewById(R.id.discoverBotanicalName);
        discoverPlantName = findViewById(R.id.discoverPlantName);
        discoverPlantType = findViewById(R.id.discoverPlantType);
        discoverBloomTime = findViewById(R.id.discoverBloomTime);
        discoverPlantColor = findViewById(R.id.discoverPlantColor);
        discoverNativeArea = findViewById(R.id.discoverNativeArea);
        discoverToxicity = findViewById(R.id.discoverToxicity);
        discoverSunExposure = findViewById(R.id.discoverSunExposure);
        discoverCare = findViewById(R.id.discoverCare);
        discoverWater = findViewById(R.id.discoverWater);
        discoverSun = findViewById(R.id.discoverSun);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            discoverPlantName.setText(bundle.getString("DiscoverPlantName"));
            Glide.with(this).load(bundle.getString("DiscoverImage")).placeholder(R.drawable.sowandgrowlogo).into(discoverPlantImage);
            discoverBotanicalName.setText(bundle.getString("DiscoverPlantBotanical"));
            discoverPlantType.setText(bundle.getString("DiscoverPlantType"));
            discoverBloomTime.setText(bundle.getString("DiscoverBloomTime"));
            discoverPlantColor.setText(bundle.getString("DiscoverPlantColor"));
            discoverNativeArea.setText(bundle.getString("DiscoverNativeArea"));
            discoverToxicity.setText(bundle.getString("DiscoverPlantToxicity"));
            discoverCare.setText(bundle.getString("DiscoverCare"));
            discoverSunExposure.setText(bundle.getString("DiscoverSunExposure"));
            discoverWater.setText(bundle.getString("DiscoverPlantWater"));
            discoverSun.setText(bundle.getString("DiscoverPlantSun"));
        }

        backbtn = findViewById(R.id.backbtn);

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}