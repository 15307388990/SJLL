package com.ming.sjll.message.presenter;

import com.ming.sjll.R;
import com.ming.sjll.api.ApiService;
import com.ming.sjll.base.exp.RetrofitManager;
import com.ming.sjll.base.http.ApiObserver;
import com.ming.sjll.base.presenter.MvpPresenter;
import com.ming.sjll.message.view.MessageNotificationListView;
import com.ming.sjll.message.viewmodel.MessageNotifyBean;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class MessageNotificationListPresenter extends MvpPresenter<MessageNotificationListView> {

    @Override
    protected void onViewAttached() {
        super.onViewAttached();

        getView().onShowData(getDefaultData(new MessageNotifyBean.DataBean()));

        unReadmsg();
    }

    public void unReadmsg() {
        getNetData(RetrofitManager.get().create(ApiService.class).unReadmsg(getToken()),
                new ApiObserver<MessageNotifyBean>() {
                    @Override
                    public void onSuccess(MessageNotifyBean bean) {
                        MessageNotifyBean.DataBean dataViewModel = bean.getData();
                        ArrayList<MessageNotifyBean> data = getDefaultData(dataViewModel);
                        getView().onShowData(data);
                    }

                    @Override
                    public void onFailure(int code, String msg) {
                        getView().showError(msg);
                    }
                });
    }

    @NotNull
    private ArrayList<MessageNotifyBean> getDefaultData(MessageNotifyBean.DataBean dataViewModel) {
        ArrayList<MessageNotifyBean> data = new ArrayList<>();
        MessageNotifyBean viewModel = new MessageNotifyBean();
        viewModel.setContent("项目统筹");
        viewModel.setCount(dataViewModel.getProjectApply() + "");
        viewModel.setUrl(R.mipmap.message_notify_1);


        MessageNotifyBean viewModel1 = new MessageNotifyBean();
        viewModel1.setContent("项目参与确认");
        viewModel1.setCount(dataViewModel.getProjectInvite() + "");
        viewModel1.setUrl(R.mipmap.message_notify_2);


        MessageNotifyBean viewModel2 = new MessageNotifyBean();
        viewModel2.setContent("公司申请");
        viewModel2.setCount(dataViewModel.getCompanyApply() + "");
        viewModel2.setUrl(R.mipmap.message_notify_3);


        data.add(viewModel);
        data.add(viewModel1);
        data.add(viewModel2);
        return data;
    }
}
