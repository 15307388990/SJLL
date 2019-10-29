package com.ming.sjll.base.activity;

import android.os.Bundle;

import com.ming.sjll.MainActivity;
import com.ming.sjll.R;
import com.ming.sjll.base.presenter.MvpPresenter;
import com.ming.sjll.base.utils.AppUtils;
import com.ming.sjll.base.utils.SavePreferencesData;
import com.ming.sjll.base.utils.StatusBarUtil;
import com.ming.sjll.base.view.MvpView;

import org.greenrobot.eventbus.EventBus;

import androidx.annotation.Nullable;


/**
 * @author luoming
 * created at 2019/8/8 11:40 AM
 * MVP模式Activity基类
 */
public abstract class MvpActivity<V extends MvpView, P extends MvpPresenter<V>>
        extends BaseActivity implements MvpView {
    protected P mPresenter;
    public SavePreferencesData mSavePreferencesData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (useEventBus()) {
            EventBus.getDefault().register(this);
        }
        // 初始化presenter并绑定view
        mPresenter = createPresenter();
        mPresenter.attachView((V) this);
        mSavePreferencesData = new SavePreferencesData(this);
        StatusBarUtil.setColor(MvpActivity.this, AppUtils.getColor(R.color.white));
        StatusBarUtil.setDarkMode(this);

    }

    @Override
    protected void onStart() {
        super.onStart();

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

    protected abstract P createPresenter();


}
