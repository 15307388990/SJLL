package com.ming.sjll.base.widget;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ming.sjll.appication.SJLLApplication;


/**
 * Toast统一管理类
 * @author luoming
 *created at 2019/8/6 10:42 AM
*/
public class ToastShow {
	// Toast
	private static Toast toast;
	private static Toast mCToast;
	private static TextView mTvMsg;

	/**
     *  debug状态L.debug=true的时候才吐司
     */

    public static void ds( CharSequence message) {
        if (null == toast) {
            toast = Toast.makeText(SJLLApplication.getInstance(), message, Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 0, 0);

        } else {
            toast.setText(message);
        }
        if (SJLLApplication.DEBUG) {
            toast.show();
        }
    }
    /**
     *  短时间显示Toast
     */

	public static void s( CharSequence message) {
		if (null == toast) {
			toast = Toast.makeText(SJLLApplication.getInstance(), message, Toast.LENGTH_SHORT);
//			toast.setGravity(Gravity.CENTER, 0, 0);
		} else {
			toast.setText(message);
		}
		toast.show();

	}

	public static void s(int resMsg) {
		if (null == toast) {
			toast = Toast.makeText(SJLLApplication.getInstance(), resMsg, Toast.LENGTH_SHORT);
//			toast.setGravity(Gravity.CENTER, 0, 0);
		} else {
			toast.setText(resMsg);
		}
		toast.show();
	}

	/**
	 * 短时间显示Toast
	 * 
	 * @param message
	 */
	public static void showShort( int message) {
		if (null == toast) {
			toast = Toast.makeText(SJLLApplication.getInstance(), message, Toast.LENGTH_SHORT);
			// toast.setGravity(Gravity.CENTER, 0, 0);
		} else {
			toast.setText(message);
		}
		toast.show();
	}

	/**
	 * 长时间显示Toast
	 * 
	 * @param message
	 */
	public static void showLong( CharSequence message) {
		if (null == toast) {
			toast = Toast.makeText(SJLLApplication.getInstance(), message, Toast.LENGTH_LONG);
			// toast.setGravity(Gravity.CENTER, 0, 0);
		} else {
			toast.setText(message);
		}
		toast.show();
	}

	/**
	 * 长时间显示Toast
	 * @param message
	 */
	public static void showLong( int message) {
		if (null == toast) {
			toast = Toast.makeText(SJLLApplication.getInstance(), message, Toast.LENGTH_LONG);
			// toast.setGravity(Gravity.CENTER, 0, 0);
		} else {
			toast.setText(message);
		}
		toast.show();
	}

	/**
	 * 自定义显示Toast时间
	 * 
	 * @param message
	 * @param duration
	 */
	public static void show(CharSequence message, int duration) {
		if (null == toast) {
			toast = Toast.makeText(SJLLApplication.getInstance(), message, duration);
			// toast.setGravity(Gravity.CENTER, 0, 0);
		} else {
			toast.setText(message);
		}
		toast.show();
	}

	/**
	 * 自定义显示Toast时间
	 * 
	 * @param message
	 * @param duration
	 */
	public static void show( int message, int duration) {
		if (null == toast) {
			toast = Toast.makeText(SJLLApplication.getInstance(), message, duration);
			// toast.setGravity(Gravity.CENTER, 0, 0);
		} else {
			toast.setText(message);
		}
		toast.show();
	}

	/** Hide the toast, if any. */
	public static void hideToast() {
		if (null != toast) {
			toast.cancel();
		}
	}

    /**
     * 带图片消息提示
     * @param context
     * @param ImageResourceId
     * @param text
     */
    public static void ImageToast(Context context, int ImageResourceId, CharSequence text){
        //创建一个Toast提示消息
        toast = Toast.makeText(context.getApplicationContext(), text, Toast.LENGTH_LONG);
        //设置Toast提示消息在屏幕上的位置
        toast.setGravity(Gravity.CENTER, 0, 0);
        //获取Toast提示消息里原有的View
        View toastView = toast.getView();
        //创建一个ImageView
        ImageView img = new ImageView(context);
        img.setImageResource(ImageResourceId);
        //创建一个LineLayout容器
        LinearLayout ll = new LinearLayout(context);
        //向LinearLayout中添加ImageView和Toast原有的View
        ll.addView(img);
        ll.addView(toastView);
        //将LineLayout容器设置为toast的View
        toast.setView(ll);
        //显示消息
        toast.show();
    }


    public static void s(String msg){
		if (null == toast) {
			toast = Toast.makeText(SJLLApplication.getInstance(), msg, Toast.LENGTH_SHORT);
//			toast.setGravity(Gravity.CENTER, 0, 0);
		} else {
			toast.setText(msg);
		}
		toast.show();

	}

}
