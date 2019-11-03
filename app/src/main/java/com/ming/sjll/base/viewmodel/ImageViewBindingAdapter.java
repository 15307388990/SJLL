package com.ming.sjll.base.viewmodel;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ImageViewBindingAdapter {

    @BindingAdapter({"url"})
    public static void setImageUrl(ImageView imageView,String url){
        Glide.with(imageView).load(url).into(imageView);
    }
}
