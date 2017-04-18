package com.owl.example.databinding;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by Alamusi on 2017/4/18.
 */

public class DemoBindingAdapter {

    @BindingAdapter({"app:imageUri", "app:placeholder"})
    public static void loadImageFromUrl(ImageView view, String url, Drawable drawable) {
        Glide.with(view.getContext()).load(url).placeholder(drawable).into(view);
    }
}

