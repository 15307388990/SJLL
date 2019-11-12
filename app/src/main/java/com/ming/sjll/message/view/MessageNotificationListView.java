package com.ming.sjll.message.view;


import com.ming.sjll.base.view.MvpView;
import com.ming.sjll.message.viewmodel.MessageNotifyViewModel;

public interface MessageNotificationListView extends MvpView {
    void onShowData(MessageNotifyViewModel viewModel);
}
