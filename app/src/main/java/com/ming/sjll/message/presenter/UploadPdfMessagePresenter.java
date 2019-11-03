package com.ming.sjll.message.presenter;

import com.ming.sjll.api.ApiService;
import com.ming.sjll.base.exp.RetrofitManager;
import com.ming.sjll.base.http.ApiObserver;
import com.ming.sjll.base.presenter.MvpPresenter;
import com.ming.sjll.message.view.UploadPdfMessageView;
import com.ming.sjll.message.viewmodel.ActivityUploadMessageViewModel;

public class UploadPdfMessagePresenter extends MvpPresenter<UploadPdfMessageView> {
    public static final String PROJECT_ID = "project_id";
    @Override
    protected void onViewAttached() {
        super.onViewAttached();
        getProjectInfo();
    }

    public void getProjectInfo() {
        String projectId = getBundle().getString(PROJECT_ID);
        getNetData(RetrofitManager.get().create(ApiService.class).getProjectInfo(getToken(), projectId),
                new ApiObserver<ActivityUploadMessageViewModel>() {
                    @Override
                    public void onSuccess(ActivityUploadMessageViewModel bean) {
                        getView().onShowData(bean);
                    }

                    @Override
                    public void onFailure(int code, String msg) {
                        getView().showError(msg);
                    }
                });
    }
}
