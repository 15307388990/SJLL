package com.ming.sjll.appication;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import com.ming.sjll.base.callback.SimpleActivityLifecycleCallbacks;
import com.ming.sjll.base.manager.AppManager;
import com.ming.sjll.base.netstate.NetChangeObserver;
import com.ming.sjll.base.netstate.NetworkStateReceiver;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;


/**
 * Created by Nowy on 2017/12/20.
 */

public class BaseApplication extends Application {
    public static final String TAG = BaseApplication.class.getSimpleName();
    public static BaseApplication instance;
    public static boolean DEBUG = true;//控制日志的输出
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        initLogger();
        registerActivityLifecycle();


    }

    public static BaseApplication getInstance() {
        return instance;
    }
    /**
     * 日志初始化
     */
    private void initLogger(){
        Logger.addLogAdapter(new AndroidLogAdapter(){
            @Override
            public boolean isLoggable(int priority, String tag) {
                return DEBUG;
            }
        });
    }

    /**
     * 绑定监听activity的生命周期
     * AppManager管理activity
     * NetworkStateReceiver管理网络监听
     * *有什么问题可以联系我：15307388990
     */
    private void registerActivityLifecycle(){
        ActivityLifecycleCallbacks lifecycleCallbacks = new SimpleActivityLifecycleCallbacks(){
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                super.onActivityCreated(activity, savedInstanceState);
                AppManager.getAppManager().addActivity(activity);
                if(activity instanceof NetChangeObserver)
                    NetworkStateReceiver.registerObserver((NetChangeObserver) activity);

                Logger.t(TAG).i("lifecycleCallbacks "
                        +"\n当前创建的activity：  "+activity
                        +"\n当前堆栈的大小:"+AppManager.getAppManager().size()
                        +"\n当前网络监听集合的大小:"+ NetworkStateReceiver.size());
            }

            @Override
            public void onActivityDestroyed(Activity activity) {
                super.onActivityDestroyed(activity);
                AppManager.getAppManager().removeActivity(activity);
                if(activity instanceof NetChangeObserver)
                    NetworkStateReceiver.removeRegisterObserver((NetChangeObserver) activity);

                Logger.t(TAG).i("lifecycleCallbacks "
                        +"\n当前移除的activity："+activity
                        +"\n当前堆栈大小:"+AppManager.getAppManager().size()
                        +"\n当前网络监听集合的大小:"+NetworkStateReceiver.size());
            }

        };


        registerActivityLifecycleCallbacks(lifecycleCallbacks);
    }

}
