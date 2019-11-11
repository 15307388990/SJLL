package com.ming.sjll.message.view;


import com.ming.sjll.base.view.MvpView;
import com.ming.sjll.message.viewmodel.ProjectChatViewModel;

public interface MessageChatView extends MvpView {
    void onShowData(ProjectChatViewModel viewModel);

    void changeProject();

    void uploadPdf();

    void sendCooperation();

    void sendCooperationApply();

    void complain();

    void shareUser();

    void shareWork();

}
