package com.ming.sjll.base.activity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.text.TextUtils;

import com.ming.sjll.base.manager.LoadManager;
import com.ming.sjll.base.widget.ToastShow;

/**
 * @author luoming
 *created at 2019/8/6 10:33 AM
*/

public class BaseLoadDialogAty extends AppCompatActivity {
    private LoadManager mLoadManager;

    //适配矢量图
    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//竖屏
        initLoadManager();
    }


    public void showTips(String msg){
        if(!TextUtils.isEmpty(msg))
            ToastShow.s(msg);
    }

    public void showTips(@StringRes int msg){
        ToastShow.s(msg);
    }

    private void initLoadManager() {
        mLoadManager = new LoadManager(this);
    }

    public void showLoadDialog() {
        if (mLoadManager != null)
            mLoadManager.showLoadDialog();
    }


    public void dismissDialog(){
        if (mLoadManager != null)
            mLoadManager.dismissDialog();
    }

    @Override
    protected void onDestroy() {
        if (mLoadManager != null){
            mLoadManager.onDestroy();
        }
        super.onDestroy();
    }
}
