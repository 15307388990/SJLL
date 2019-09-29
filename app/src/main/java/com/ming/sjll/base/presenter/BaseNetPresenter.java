package com.ming.sjll.base.presenter;


import com.ming.sjll.base.http.ApiObserver;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

/**
 * MVP模式请求网络的抽出BaseNetPresenter基类
 *
 * @author haojunkuang
 * @date 2018/11/13
 */
public class BaseNetPresenter {

    protected final CompositeDisposable compositeDisposable = new CompositeDisposable();

    /**
     * 获取网络数据
     *
     * @param observable 请求返回数据
     * @param observer   回调方法
     * @param <T>        返回数据
     */
    protected <T> void getNetData(final Observable<T> observable, final ApiObserver<T> observer) {
        if (observable != null) {
            observable.subscribeOn(Schedulers.io())
                    .unsubscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(observer);
            compositeDisposable.add(observer);
        }
    }


}
