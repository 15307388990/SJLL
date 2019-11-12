package com.ming.sjll.message.view;


import com.ming.sjll.base.view.MvpView;
import com.ming.sjll.message.viewmodel.MessageProjectCoordinationViewModel;

import java.util.List;

public interface MessageProjectCoordinationView extends MvpView {


    void onShowData(List<MessageProjectCoordinationViewModel.DataEntity> data);

    void onOperatonSuccess();
}
