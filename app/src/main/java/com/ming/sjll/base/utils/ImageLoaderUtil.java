package com.ming.sjll.base.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.request.FutureTarget;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;

import java.io.File;
import java.util.concurrent.ExecutionException;

import androidx.annotation.DrawableRes;
import androidx.fragment.app.Fragment;

/**
 * Created by Nowy on 2018/5/24.
 * 基于Glide 4.X的图片工具类基础版
 */

public class ImageLoaderUtil {
    public static int IMG_PRE_DEF = android.R.color.white; //加载前默认图片
    public static int IMG_ERROR_DEF = android.R.color.white;//加载失败默认图片


    /**
     * 获得原始配置实例
     *
     * @return
     */
    public static RequestOptions getOriginalOption() {
        RequestOptions options = new RequestOptions();
        return options;
    }


    /**
     * 获取默认的配置
     *
     * @return
     */
    public static RequestOptions getDefOption() {
        return new RequestOptions()
                .placeholder(IMG_PRE_DEF)
                .error(IMG_ERROR_DEF)
                // 缓存原始数据
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE);
    }


    /**
     * 显示图片
     *
     * @param imageView
     * @param path      图片路径
     */
    public static void display(ImageView imageView, String path) {
        display(imageView, path, getDefOption());
    }

    /**
     * 显示GIF第一帧。
     *
     * @param imageView
     * @param path
     * @ToDo 还没测试
     */
    public static void displayGifFirstFrame(ImageView imageView, String path) {
        Glide.with(imageView).asBitmap().load(path).into(imageView);
    }


    /**
     * 显示背景
     *
     * @param view
     * @param url
     */
    public static void displayBackground(ImageView view, String url) {
        displayBackground(view, url, getDefOption());
    }


    /**
     * 显示图片
     *
     * @param imageView
     * @param file
     */
    public static void display(ImageView imageView, File file) {
        display(imageView, file, getDefOption());
    }

    /**
     * 显示背景
     *
     * @param view
     * @param file
     */
    public static void displayBackground(View view, File file) {
        displayBackground(view, file, getDefOption());
    }


    /**
     * 显示图片
     *
     * @param imageView
     * @param path
     * @param imgDef    默认图片
     */
    public static void display(ImageView imageView, String path, @DrawableRes int imgDef) {
        display(imageView, path, getDefOption().error(imgDef));
    }


    /**
     * 显示图片
     *
     * @param imageView
     * @param file
     * @param imgDef
     */
    public static void display(ImageView imageView, File file, @DrawableRes int imgDef) {
        display(imageView, file, getDefOption().error(imgDef));
    }


    /**
     * 显示图片，作为背景
     *
     * @param view
     * @param url
     * @param imgDef
     */
    public static void displayBackground(ImageView view, String url, @DrawableRes int imgDef) {
        displayBackground(view, url, getDefOption().error(imgDef));
    }

    /**
     * 显示图片，作为背景
     *
     * @param view
     * @param file
     * @param imgDef
     */
    public static void displayBackground(View view, File file, @DrawableRes int imgDef) {
        displayBackground(view, file, getDefOption().error(imgDef));
    }


    /**
     * 显示图片
     * 因为这种会比较少用，所以用到RequestOptions，替换其他图片库时，这个方法都需要修改
     * 所以，尽量把常用的显示方式采用简单参数的方式进行调用
     *
     * @param imageView
     * @param path
     * @param options   配置
     */
    public static void display(ImageView imageView, String path, RequestOptions options) {
        Glide.with(imageView)
                .applyDefaultRequestOptions(options)
                .load(path).into(imageView);
    }

    /**
     * 显示图片
     *
     * @param imageView
     * @param file
     * @param options
     */
    public static void display(ImageView imageView, File file, RequestOptions options) {

        Glide.with(imageView)
                .applyDefaultRequestOptions(options)
                .load(file).into(imageView);
    }

    /**
     * 显示背景
     *
     * @param view
     * @param url
     * @param options
     */
    public static void displayBackground(ImageView view, String url, RequestOptions options) {
        Glide.with(view)
                .applyDefaultRequestOptions(options)
                .load(url)
                .into(view);
    }

    /**
     * 显示背景
     *
     * @param view
     * @param file
     * @param options
     */
    public static void displayBackground(View view, File file, RequestOptions options) {
        Glide.with(view)
                .applyDefaultRequestOptions(options)
                .load(file)
                .into(new DrawableViewBgTarget(view));
    }


    /**
     * 重启当前页面的图片加载，会自动查找顶级的activity或者fragment
     *
     * @param context
     */
    public static void resumeRequests(Context context) {
        Glide.with(context).resumeRequestsRecursive();
    }


    /**
     * 暂停当前页面的图片加载，会自动查找顶级的activity或者fragment
     *
     * @param context
     */
    public static void pauseRequest(Context context) {
        Glide.with(context).pauseRequestsRecursive();
    }


    /**
     * 暂停全部图片加载，通常在APP被置于后台使用
     *
     * @param context
     */
    public static void pauseAll(Context context) {
        Glide.with(context).pauseAllRequests();
    }


    /**
     * 图片加载是被否被暂停
     *
     * @param context
     * @return
     */
    public static boolean isPaused(Context context) {
        return Glide.with(context).isPaused();
    }


    /**
     * 是否动画资源
     *
     * @param drawable
     * @return
     */
    public static boolean isAnim(Drawable drawable) {
        return drawable instanceof Animatable;
    }


    public static void displayNativePath(Context context, String path, SimpleTarget<Bitmap> target) {
        Glide.with(context)
                .asBitmap()
                .apply(new RequestOptions()
                        .placeholder(android.R.color.transparent)
                        .error(android.R.color.transparent)
                        .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                        .fitCenter()
                        .priority(Priority.HIGH))
                .load(new File(path))
                .into(target);
    }


    /**
     * 下载BMP，同步方法，需要在子线程中调用
     *
     * @param context
     * @param url
     * @param width   图片宽度
     * @param height  图片高度
     * @return
     */
    public static Bitmap download(Context context, String url, int width, int height) {
        try {
            FutureTarget<Bitmap> futureTarget =
                    Glide.with(context)
                            .asBitmap()
                            .load(url)
                            .submit(width, height);
            Bitmap bitmap = futureTarget.get();

            Glide.with(context).clear(futureTarget);
            return bitmap;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return null;
    }


    /**
     * 下载图片，异步方法，可以做在UI线程中调用
     *
     * @param context
     * @param url
     * @param target
     */
    public static void downloadAsync(Context context, String url, SimpleTarget<Bitmap> target) {
        Glide.with(context)
                .asBitmap()
                .apply(new RequestOptions()
                        .placeholder(android.R.color.transparent)
                        .error(android.R.color.transparent)
                        .diskCacheStrategy(DiskCacheStrategy.RESOURCE).priority(Priority.HIGH))

                .load(url)
                .into(target);
    }

    public static void downloadDrawableAsync(Context context, String url, SimpleTarget<Drawable> target) {
        Glide.with(context)
                .asDrawable()
                .load(url)
                .into(target);
    }


    /**
     * 取消加载图片
     *
     * @param aty
     * @param view
     */
    public static void clear(Activity aty, View view) {
        Glide.with(aty).clear(view);
    }


    /**
     * 取消加载图片
     *
     * @param view
     * @param view
     */
    public static void clear(Fragment fragment, View view) {
        Glide.with(fragment).clear(view);
    }


    /**
     * 取消加载图片
     *
     * @param aty
     * @param target
     */
    public static void clear(Activity aty, Target target) {
        Glide.with(aty).clear(target);
    }

    /**
     * 取消加载图片
     *
     * @param fragment
     * @param target
     */
    public static void clear(Fragment fragment, Target target) {
        Glide.with(fragment).clear(target);
    }


    /**
     * 获取图片缓存文件目录
     *
     * @param context
     * @return
     */
    public static File getCacheDir(Context context) {
        return new File(context.getCacheDir(), DiskCache.Factory.DEFAULT_DISK_CACHE_DIR);
    }

    /**
     * 清除缓存，同时清除内存和磁盘缓存
     * 必须在UI线程中调用
     *
     * @param context
     */
    public static void clearCache(Context context) {
        Glide.get(context.getApplicationContext()).clearDiskCache();
        Glide.get(context.getApplicationContext()).clearMemory();
    }

    /**
     * 清除磁盘缓存
     * 必须在UI线程中调用
     *
     * @param context
     */
    public static void clearDiskCache(Context context) {
        Glide.get(context.getApplicationContext()).clearDiskCache();
    }


    /**
     * 清除内存缓存
     * 必须在UI线程中调用
     *
     * @param context
     */
    public static void clearMemoryCache(Context context) {
        Glide.get(context.getApplicationContext()).clearMemory();
    }


//    Crop
//            CropTransformation, CropCircleTransformation, CropSquareTransformation, RoundedCornersTransformation
//
//    Color
//            ColorFilterTransformation, GrayscaleTransformation
//
//    Blur
//            BlurTransformation
//
//    Mask
//            MaskTransformation


    // ----------------------GPU-------------------------------

    //ToonFilterTransformation
    //SepiaFilterTransformation
    //ContrastFilterTransformation
    //InvertFilterTransformation
    //PixelationFilterTransformation
    //SketchFilterTransformation
    //SwirlFilterTransformation
    //BrightnessFilterTransformation
    //KuwaharaFilterTransformation
    //VignetteFilterTransformation

}
