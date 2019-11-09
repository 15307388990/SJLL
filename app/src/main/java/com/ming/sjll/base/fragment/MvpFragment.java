package com.ming.sjll.base.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.ming.sjll.base.presenter.MvpPresenter;
import com.ming.sjll.base.view.MvpView;
import com.ming.sjll.base.widget.ToastShow;

import java.lang.reflect.ParameterizedType;


/**
 * MVP模式Fragment基类
 *
 * @author linjie
 * @date 2017/10/15
 */
public abstract class MvpFragment<V extends MvpView, P extends MvpPresenter<V>> extends BaseFragment
        implements MvpView {
    protected P mPresenter;

    protected   P createPresenter(){
        return null;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter = autoCreatePresenter();
        if (mPresenter!=null) {
            mPresenter.attachView((V) this, getArguments());
        }
    }

    @SuppressWarnings("unchecked")
    public P autoCreatePresenter() {
        try {
            Class<P> clz = (Class<P>) (((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1]);
            Log.i("MvpFragment", "autocreate preseter" + clz);
            return clz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return createPresenter();
    }


    @Override
    public void onDestroyView() {
        if (mPresenter != null) {
            mPresenter.detachView();
            mPresenter = null;
        }

        super.onDestroyView();
    }


    @Override
    public void showLoading(String msg) {
        ToastShow.s(msg);
    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError(String msg) {
        ToastShow.s(msg);
    }
}
