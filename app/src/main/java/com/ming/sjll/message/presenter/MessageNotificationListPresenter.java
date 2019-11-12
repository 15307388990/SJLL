package com.ming.sjll.message.presenter;

import com.ming.sjll.api.ApiService;
import com.ming.sjll.base.exp.RetrofitManager;
import com.ming.sjll.base.http.ApiObserver;
import com.ming.sjll.base.presenter.MvpPresenter;
import com.ming.sjll.message.view.MessageNotificationListView;
import com.ming.sjll.message.viewmodel.MessageNotifyViewModel;

public class MessageNotificationListPresenter extends MvpPresenter<MessageNotificationListView> {

    @Override
    protected void onViewAttached() {
        super.onViewAttached();
        unReadmsg();
    }

    public void unReadmsg() {
        getNetData(RetrofitManager.get().create(ApiService.class).unReadmsg(getToken()),
                new ApiObserver<MessageNotifyViewModel>() {
                    @Override
                    public void onSuccess(MessageNotifyViewModel bean) {
                        getView().onShowData(bean);
                    }

                    @Override
                    public void onFailure(int code, String msg) {
                        getView().showError(msg);
                    }
                });
    }
}
