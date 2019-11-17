package com.ming.sjll.message.presenter;

import com.ming.sjll.api.ApiService;
import com.ming.sjll.base.exp.RetrofitManager;
import com.ming.sjll.base.http.ApiObserver;
import com.ming.sjll.base.presenter.MvpPresenter;
import com.ming.sjll.message.view.MessageProjectInviteView;
import com.ming.sjll.message.viewmodel.InvitePassBean;
import com.ming.sjll.message.viewmodel.ProjectInviteBean;

public class MessageProjectInvitePresenter extends MvpPresenter<MessageProjectInviteView> {


    @Override
    protected void onViewAttached() {
        super.onViewAttached();

        getData();
    }

    private void getData() {
        String pageIndex = "1";
        String pageSize = "20";

        getNetData(RetrofitManager.get().create(ApiService.class).projectInvite(getToken(), pageIndex, pageSize),
                new ApiObserver<ProjectInviteBean>() {
                    @Override
                    public void onSuccess(ProjectInviteBean bean) {
                        getView().onShowData(bean.getData());
                    }

                    @Override
                    public void onFailure(int code, String msg) {
                        getView().showError(msg);
                    }
                });
    }
    public void invitePass(String applyId, boolean isReceive) {
        String status = isReceive ? "1" : "0";
        getNetData(RetrofitManager.get().create(ApiService.class).invitePass(getToken(), applyId + "", status + ""),
                new ApiObserver<InvitePassBean>() {
                    @Override
                    public void onSuccess(InvitePassBean bean) {
                        getData();
                    }

                    @Override
                    public void onFailure(int code, String msg) {
                        getView().showError(msg);
                    }
                });
    }



}
