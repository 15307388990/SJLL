package com.ming.sjll.purchaser.presenter;

import com.ming.sjll.api.ApiService;
import com.ming.sjll.base.exp.RetrofitManager;
import com.ming.sjll.base.http.ApiObserver;
import com.ming.sjll.base.presenter.MvpPresenter;
import com.ming.sjll.purchaser.view.HotAuthorView;
import com.ming.sjll.supplier.bean.HotAuthorBean;

public class HotAuthorPresenter extends MvpPresenter<HotAuthorView> {
    @Override
    public void attachView(HotAuthorView view) {
        super.attachView(view);
        getHotAuthor();
    }

    public void getHotAuthor() {

        getNetData(RetrofitManager.get().create(ApiService.class).getHotAuthor(),
                new ApiObserver<HotAuthorBean>() {
                    @Override
                    public void onSuccess(HotAuthorBean bean) {
                        getView().setHotAuthor(bean);
                    }

                    @Override
                    public void onFailure(int code, String msg) {
                        getView().showError(msg);
                    }
                });
    }


}
