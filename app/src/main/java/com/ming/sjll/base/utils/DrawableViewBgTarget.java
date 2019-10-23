package com.ming.sjll.base.utils;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;

import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;

/**
 * Created by Nowy on 2018/5/24.
 */

public class DrawableViewBgTarget extends BackgroundTarget<Drawable> {
    public DrawableViewBgTarget(@NonNull View view) {
        super(view);
    }

    @Override
    protected void setResource(@Nullable Drawable resource) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            view.setBackground(resource);
        } else{
            view.setBackgroundDrawable(resource);
        }

    }
}
