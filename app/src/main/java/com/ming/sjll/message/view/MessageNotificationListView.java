package com.ming.sjll.message.view;


import com.ming.sjll.base.view.MvpView;
import com.ming.sjll.message.viewmodel.MessageNotifyBean;

import java.util.ArrayList;

public interface MessageNotificationListView extends MvpView {
    void onShowData( ArrayList<MessageNotifyBean> viewModel);
}
