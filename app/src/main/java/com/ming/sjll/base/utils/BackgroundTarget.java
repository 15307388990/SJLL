package com.ming.sjll.base.utils;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;

import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.target.ViewTarget;
import com.bumptech.glide.request.transition.Transition;

import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;

/**
 * Created by Nowy on 2018/5/24.
 * 设置背景图的
 */

public abstract class BackgroundTarget<T> extends ViewTarget<View, T>
        implements Transition.ViewAdapter  {


    @Nullable
    private Animatable animatable;


    public BackgroundTarget(@NonNull View view) {
        super(view);
    }

    /**
     * Sets the given {@link Drawable} on the view using {@link
     * android.widget.ImageView#setImageDrawable(Drawable)}.
     *
     * @param placeholder {@inheritDoc}
     */
    @Override
    public void onLoadStarted(@Nullable Drawable placeholder) {
        super.onLoadStarted(placeholder);
        setResourceInternal(null);
        setDrawable(placeholder);
    }

    /**
     * Sets the given {@link Drawable} on the view using {@link
     * android.widget.ImageView#setImageDrawable(Drawable)}.
     *
     * @param errorDrawable {@inheritDoc}
     */
    @Override
    public void onLoadFailed(@Nullable Drawable errorDrawable) {
        super.onLoadFailed(errorDrawable);
        setResourceInternal(null);
        setDrawable(errorDrawable);
    }

    /**
     * Sets the given {@link Drawable} on the view using {@link
     * android.widget.ImageView#setImageDrawable(Drawable)}.
     *
     * @param placeholder {@inheritDoc}
     */
    @Override
    public void onLoadCleared(@Nullable Drawable placeholder) {
        super.onLoadCleared(placeholder);
        if (animatable != null) {
            animatable.stop();
        }
        setResourceInternal(null);
        setDrawable(placeholder);
    }

    @Override
    public void onResourceReady(@NonNull T resource, @Nullable Transition<? super T> transition) {
        if (transition == null || !transition.transition(resource, this)) {
            setResourceInternal(resource);
        } else {
            maybeUpdateAnimatable(resource);
        }
    }

    @Override
    public void onStart() {
        if (animatable != null) {
            animatable.start();
        }
    }

    @Override
    public void onStop() {
        if (animatable != null) {
            animatable.stop();
        }
    }

    private void setResourceInternal(@Nullable T resource) {
        // Order matters here. Set the resource first to make sure that the Drawable has a valid and
        // non-null Callback before starting it.
        setResource(resource);
        maybeUpdateAnimatable(resource);
    }

    private void maybeUpdateAnimatable(@Nullable T resource) {
        if (resource instanceof Animatable) {
            animatable = (Animatable) resource;
            animatable.start();
        } else {
            animatable = null;
        }
    }

    @Nullable
    @Override
    public Drawable getCurrentDrawable() {
        return view.getBackground();
    }

    @Override
    public void setDrawable(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            view.setBackground(drawable);
        } else{
            view.setBackgroundDrawable(drawable);
        }

    }

    protected abstract void setResource(@Nullable T resource);

    @Override
    public void setRequest(Request request) {
        //动态获取id
        int glide_tag_id = view.getContext().getResources().getIdentifier("glide_tag_id", "id", view.getContext().getPackageName());
        view.setTag(glide_tag_id, request);
    }

    @Override
    public Request getRequest() {
        //动态获取id
        int glide_tag_id = view.getContext().getResources().getIdentifier("glide_tag_id", "id", view.getContext().getPackageName());
        return (Request) view.getTag(glide_tag_id);
    }
}
