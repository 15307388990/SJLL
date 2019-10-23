package com.ming.sjll.supplier.presenter;

import com.ming.sjll.api.ApiService;
import com.ming.sjll.base.exp.RetrofitManager;
import com.ming.sjll.base.http.ApiObserver;
import com.ming.sjll.base.presenter.MvpPresenter;
import com.ming.sjll.supplier.bean.ComprehenBean;
import com.ming.sjll.supplier.view.ComprehensiveView;

public class NoticePresenter extends MvpPresenter<ComprehensiveView> {
    public void getNotice() {
        getNetData(RetrofitManager.get().create(ApiService.class).getNotice("2e9f39acab38ffd042c4baf9f8c75cb7f5cecb26"),
                new ApiObserver<ComprehenBean>() {
                    @Override
                    public void onSuccess(ComprehenBean bean) {
                        getView().setProjectIntegrated(bean);
                    }

                    @Override
                    public void onFailure(int code, String msg) {
                        getView().showError(msg);
                    }
                });

    }

}
