package com.ming.sjll.base.presenter;


import android.support.annotation.IntDef;

import com.ming.sjll.base.view.MvpView;

import java.lang.ref.WeakReference;



/**
 * MVP模式Presenter基类
 *
 * @author luoming
 * created at 2019/8/8 3:14 PM
 */
public class MvpPresenter<V extends MvpView> extends BaseNetPresenter {
    protected final String TAG = getClass().getSimpleName();
    private WeakReference<V> viewRef;

    protected static final int REFRESH = 0x01;      // 刷新数据
    protected static final int LOAD_MORE = 0x02;    // 加载更多数据

    protected int nowPage = 0;      // 当前页面
    protected int pageRows = 10;    // 每页数量
    protected int totalPages = 0;   // 总页数

    @IntDef({REFRESH, LOAD_MORE})
    protected @interface LoadType {
    }

    /**
     * 获取view接口
     *
     * @return view接口
     */
    public V getView() {
        return viewRef == null ? null : viewRef.get();
    }

    /**
     * 初始化
     *
     * @param view view接口
     */
    public void attachView(V view) {
        viewRef = new WeakReference<V>(view);
        onViewAttached();
    }

    /**
     * 销毁
     */
    public void detachView() {
        // 清理RxJava观察
        compositeDisposable.clear();
        compositeDisposable.dispose();

        onViewDetached();


        if (viewRef != null) {
            viewRef.clear();
            viewRef = null;
        }
    }


    /**
     * 判断是否还有下一页数据
     *
     * @return 是否还有下一页
     */
    protected boolean hasMore() {
        return totalPages > nowPage;
    }

    /**
     * presenter与view绑定回调方法，应该在这里进行一些初始化操作
     */
    protected void onViewAttached() {

    }

    /**
     * presenter与view绑定回调方法，应该在这里进行一些清理操作
     */
    protected void onViewDetached() {

    }
}
