package com.ming.sjll.message.view;


import com.ming.sjll.base.view.MvpView;
import com.ming.sjll.message.viewmodel.ProjectChatViewModel;

public interface MessageChatView extends MvpView {
    void onShowData(ProjectChatViewModel viewModel);

    void changeProject();

    void uploadPdf();

    void confirmCooperation();

    void complain();

    void onAddMemberInfo();

}
