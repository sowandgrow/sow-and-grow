package com.sowandgrow.app.utils;

import android.content.Context;
import android.util.AttributeSet;
import com.airbnb.lottie.LottieAnimationView;

public class TransparentLottieAnimationView extends LottieAnimationView {

    public TransparentLottieAnimationView(Context context) {
        super(context);
        init();
    }

    public TransparentLottieAnimationView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TransparentLottieAnimationView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        // Set the background to transparent
        setBackgroundColor(getResources().getColor(android.R.color.transparent));
    }
}