package com.ming.sjll.base.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.ming.sjll.R;
import com.ming.sjll.base.presenter.MvpPresenter;
import com.ming.sjll.base.utils.AppUtils;
import com.ming.sjll.base.utils.SavePreferencesData;
import com.ming.sjll.base.utils.StatusBarUtil;
import com.ming.sjll.base.view.MvpView;

import org.greenrobot.eventbus.EventBus;

import java.lang.reflect.ParameterizedType;


/**
 * @author luoming
 * created at 2019/8/8 11:40 AM
 * MVP模式Activity基类
 */
public abstract class MvpActivity<V extends MvpView, P extends MvpPresenter<V>>
        extends BaseActivity implements MvpView {
    protected P mPresenter;
    public SavePreferencesData mSavePreferencesData;


    @SuppressWarnings("unchecked")
    public P autoCreatePresenter() {
        try {
            Class<P> clz = (Class<P>) (((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1]);
            return clz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return createPresenter();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (useEventBus()) {
            EventBus.getDefault().register(this);
        }
        // 初始化presenter并绑定view
        mPresenter = autoCreatePresenter();
        mPresenter.attachView((V) this, getIntent().getExtras());
        mSavePreferencesData = new SavePreferencesData(this);
        StatusBarUtil.setColor(MvpActivity.this, AppUtils.getColor(R.color.white));
        StatusBarUtil.setDarkMode(this);

    }


    @Override
    protected void onDestroy() {
        if (useEventBus()) {
            EventBus.getDefault().unregister(this);
        }

        if (mPresenter != null) {
            mPresenter.detachView();
            mPresenter = null;
        }
        super.onDestroy();
    }


    protected boolean useEventBus() {
        return false;
    }


    protected boolean userButterKnife() {
        return true;
    }

    protected P createPresenter() {
        return null;
    }


    @Override
    public void showLoading(String msg) {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError(String msg) {

    }
}
