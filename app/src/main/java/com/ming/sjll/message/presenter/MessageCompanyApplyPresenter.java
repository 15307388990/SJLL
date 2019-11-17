package com.ming.sjll.message.presenter;

import com.ming.sjll.api.ApiService;
import com.ming.sjll.base.exp.RetrofitManager;
import com.ming.sjll.base.http.ApiObserver;
import com.ming.sjll.base.presenter.MvpPresenter;
import com.ming.sjll.message.view.MessageCompanyApplyView;
import com.ming.sjll.message.viewmodel.CompanyApplyBean;
import com.ming.sjll.message.viewmodel.CompanyPassBean;

public class MessageCompanyApplyPresenter extends MvpPresenter<MessageCompanyApplyView> {


    @Override
    protected void onViewAttached() {
        super.onViewAttached();

        getData();
    }

    private void getData() {
        String pageIndex = "1";
        String pageSize = "20";

        getNetData(RetrofitManager.get().create(ApiService.class).companyApply(getToken(), pageIndex, pageSize),
                new ApiObserver<CompanyApplyBean>() {
                    @Override
                    public void onSuccess(CompanyApplyBean bean) {
                        getView().onShowData(bean.getData());
                    }

                    @Override
                    public void onFailure(int code, String msg) {
                        getView().showError(msg);
                    }
                });
    }
    public void companyPass(int applyId, boolean isReceive) {
        String status = isReceive ? "1" : "0";
        getNetData(RetrofitManager.get().create(ApiService.class).companyPass(getToken(), applyId + "", status + ""),
                new ApiObserver<CompanyPassBean>() {
                    @Override
                    public void onSuccess(CompanyPassBean bean) {
                        getData();
                    }

                    @Override
                    public void onFailure(int code, String msg) {
                        getView().showError(msg);
                    }
                });
    }



}
