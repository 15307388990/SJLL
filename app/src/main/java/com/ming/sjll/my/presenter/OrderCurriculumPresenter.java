package com.ming.sjll.my.presenter;

import com.ming.sjll.api.ApiService;
import com.ming.sjll.base.exp.RetrofitManager;
import com.ming.sjll.base.http.ApiObserver;
import com.ming.sjll.base.presenter.MvpPresenter;
import com.ming.sjll.my.bean.CurriculumBean;
import com.ming.sjll.my.view.CurriculumView;
import com.ming.sjll.purchaser.bean.ProjectManagementBean;
import com.ming.sjll.purchaser.view.ProjectManagementView;

public class OrderCurriculumPresenter extends MvpPresenter<CurriculumView> {

    @Override
    public void attachView(CurriculumView view) {
        super.attachView(view);
        getCurriculum();
    }

    public void getCurriculum() {
        getNetData(RetrofitManager.get().create(ApiService.class).getCurriculum(getToken()),
                new ApiObserver<CurriculumBean>() {
                    @Override
                    public void onSuccess(CurriculumBean bean) {
                        getView().ShowData(bean);
                    }

                    @Override
                    public void onFailure(int code, String msg) {
                        getView().showError(msg);
                    }
                });
    }
}
