package com.sowandgrow.app.utils;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import com.sowandgrow.app.R;
import com.sowandgrow.app.adapters.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity {

    private static final int NUM_PAGES = 3; // Number of onboarding pages

    ViewPager mSlideViewPager;
    LinearLayout mDotLayout;
    Button backbtn, nextbtn, skipbtn;

    TextView[] dots;
    ViewPagerAdapter viewPagerAdapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        boolean onboardingShownBefore = sharedPreferences.getBoolean("onboardingShown", false);

        if (onboardingShownBefore) {
            // Onboarding already shown, proceed to the main activity or login screen
            startActivity(new Intent(this, MainScreenActivity.class));
            finish();
        } else {
            // Onboarding not shown yet, show onboarding screen
            setContentView(R.layout.activity_main);

            // When the user completes the onboarding, set the flag to true indicating it has been shown
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("onboardingShown", true);
            editor.apply();

            initializeViews(); // Move view initialization to a separate method
        }
    }

    private void initializeViews() {
        backbtn = findViewById(R.id.backbtn);
        nextbtn = findViewById(R.id.nextbtn);
        skipbtn = findViewById(R.id.skipButton);

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getCurrentItem() > 0) {
                    mSlideViewPager.setCurrentItem(getCurrentItem() - 1, true);
                }
            }
        });

        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int totalSlides = viewPagerAdapter.getCount();
                if (getCurrentItem() < totalSlides - 1) {
                    mSlideViewPager.setCurrentItem(getCurrentItem() + 1, true);
                } else {
                    Intent i = new Intent(MainActivity.this, MainScreenActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        });

        skipbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, MainScreenActivity.class);
                startActivity(i);
                finish();
            }
        });

        mSlideViewPager = findViewById(R.id.slideViewPager);
        mDotLayout = findViewById(R.id.indicator_layout);

        viewPagerAdapter = new ViewPagerAdapter(this);
        mSlideViewPager.setAdapter(viewPagerAdapter);

        setUpIndicator(0);
        mSlideViewPager.addOnPageChangeListener(viewListener);
    }

    private void setUpIndicator(int position) {
        dots = new TextView[NUM_PAGES];
        mDotLayout.removeAllViews();

        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(ContextCompat.getColor(this, i == position ? R.color.active : R.color.inactive));
            mDotLayout.addView(dots[i]);
        }
    }

    private int getCurrentItem() {
        return mSlideViewPager.getCurrentItem();
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override
        public void onPageSelected(int position) {
            setUpIndicator(position);
            backbtn.setVisibility(position > 0 ? View.VISIBLE : View.INVISIBLE);
        }

        @Override
        public void onPageScrollStateChanged(int state) {
        }
    };
}
