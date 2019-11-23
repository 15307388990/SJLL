package com.ming.sjll.my.presenter;

import android.os.Bundle;

import com.ming.sjll.api.ApiService;
import com.ming.sjll.base.exp.RetrofitManager;
import com.ming.sjll.base.http.ApiObserver;
import com.ming.sjll.base.presenter.MvpPresenter;
import com.ming.sjll.my.bean.ColletionGoodsBean;
import com.ming.sjll.my.bean.ColletionPersenterBean;
import com.ming.sjll.my.view.ColletionGoodslView;
import com.ming.sjll.my.view.ColletionPersonnelView;

public class ColletionGoodsPresenter extends MvpPresenter<ColletionGoodslView> {

    @Override
    public void attachView(ColletionGoodslView view, Bundle bundle) {
        super.attachView(view, bundle);
        goodsList();
    }

    public void goodsList() {

        getNetData(RetrofitManager.get().create(ApiService.class).goodsList(getToken()),
                new ApiObserver<ColletionGoodsBean>() {
                    @Override
                    public void onSuccess(ColletionGoodsBean bean) {
                        getView().ShowData(bean);
                    }

                    @Override
                    public void onFailure(int code, String msg) {
                        getView().showError(msg);
                    }
                });
    }
}
