package com.sowandgrow.app.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.sowandgrow.app.R;

import pl.droidsonroids.gif.GifImageView;

public class ViewPagerAdapter extends PagerAdapter {

    Context context;

    int gifs[] = {
            R.drawable.search,
            R.drawable.garden,
            R.drawable.healthcare
    };

    int headings[] = {
            R.string.heading_one,
            R.string.heading_two,
            R.string.heading_three
    };

    int description[] = {
            R.string.desc_one,
            R.string.desc_two,
            R.string.desc_three
    };

    public ViewPagerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return gifs.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.slider_layout, container, false);

        GifImageView gifImageView = view.findViewById(R.id.gifImageView);
        TextView slideHeading = view.findViewById(R.id.texttitle);
        TextView slideDescription = view.findViewById(R.id.textdeccription);

        Glide.with(context).asGif().load(gifs[position]).into(gifImageView);
        slideHeading.setText(headings[position]);
        slideDescription.setText(description[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}


