package com.ming.sjll.base.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Priority;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.ming.sjll.R;

import java.io.File;


/**
 * Created by Nowy on 2018/5/24.
 * 在app项目中做个代理，解耦点业务和功能
 */

public class ImageHelper {


    public static int BG_DEF = android.R.color.white;
    public static int USER_EEF = R.mipmap.ic_launcher;
    public static int BT_EEF = android.R.color.white;
    public static int BG_DEF_1VS1 =android.R.color.white ;
    public static int BG_BEF_4VS3 = android.R.color.white;



    public static void display(ImageView iv, String url){
        ImageLoaderUtil.display(iv,url);
    }

    /**
     * 加载用户头像
     * @param iv
     * @param url
     */
    public static void displayUser(ImageView iv, String url){
        ImageLoaderUtil.display(iv,url,
                ImageLoaderUtil.getDefOption()
                        .priority(Priority.HIGH)
                        .centerCrop()
                        .error(USER_EEF).dontAnimate());
    }

    /**
     * 加载美容师头像
     * @param iv
     * @param url
     */
    public static void displayBt(ImageView iv, String url){
        ImageLoaderUtil.display(iv,url,
                ImageLoaderUtil.getDefOption()
                        .priority(Priority.HIGH)
                        .centerCrop()
                        .error(BT_EEF).dontAnimate());
    }

    /**
     * 加载1:1的图片
     * @param iv
     * @param url
     */
    public static void display1Vs1(ImageView iv, String url){
        ImageLoaderUtil.display(iv,url,ImageLoaderUtil.getDefOption()
                .error(BG_DEF_1VS1).centerCrop());
    }


    /**
     * 加载图片(CenterCrop)
     * @param iv
     * @param url
     */
    public static void displayCenterCrop(ImageView iv, String url, int def){
        ImageLoaderUtil.display(iv,url,
                ImageLoaderUtil.getDefOption()
                        .centerCrop()
                        .error(def));
    }

    /**
     * 显示背景
     * @param iv
     * @param url
     */
    public static void displayBackground1Vs1(ImageView iv, String url){
        ImageLoaderUtil.displayBackground(iv,url,BG_DEF_1VS1);
    }

    /**
     * 加载4:3的图片(宽高)
     * @param iv
     * @param url
     */
    public static void display4Vs3(ImageView iv, String url){
        ImageLoaderUtil.display(iv,url,BG_BEF_4VS3);
    }

    /**
     * 显示背景
     * @param iv
     * @param url
     */
    public static void displayBackground4Vs3(ImageView iv, String url){
        ImageLoaderUtil.displayBackground(iv,url,BG_BEF_4VS3);
    }

    /**
     * 加载图片，默认图
     * @param iv
     * @param url
     */
    public static void displayDef(ImageView iv, String url, @DrawableRes int defRes){
        ImageLoaderUtil.display(iv,url,defRes);
    }


    /**
     * 显示图片
     * @param imageView
     * @param file
     * @param imgDef
     */
    public static void display(ImageView imageView, File file, @DrawableRes int imgDef){
        ImageLoaderUtil.display(imageView,file,imgDef);
    }


    /**
     * 显示背景
     * @param iv
     * @param url
     * @param defRes
     */
    public static void displayBackground(ImageView iv, String url, @DrawableRes int defRes){
        ImageLoaderUtil.displayBackground(iv,url,defRes);
    }


    /**
     * 下载图片，异步方法，可以做在UI线程中调用
     * @param context
     * @param url
     * @param listener
     */
    public static  void downloadAsync(Context context, String url, final DownloadListener listener){
        ImageLoaderUtil.downloadDrawableAsync(context,url,new SimpleTarget<Drawable>(){
            @Override
            public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                if(listener != null) listener.onDownloadSuccess(resource);
            }

            @Override
            public void onLoadFailed(@Nullable Drawable errorDrawable) {
                super.onLoadFailed(errorDrawable);
                if(listener != null) listener.onDownloadError(errorDrawable);
            }
        });
    }


    public static Bitmap download(Context context, String url, int width, int height){
        return ImageLoaderUtil.download(context,url,width,height);
    }


    /**
     * 下载监听
     */
    public interface DownloadListener{
        void onDownloadSuccess(Drawable drawable);
        void onDownloadError(Drawable drawable);
    }
}

