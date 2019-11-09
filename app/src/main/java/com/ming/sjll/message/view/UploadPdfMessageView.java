package com.ming.sjll.message.view;


import com.ming.sjll.base.view.MvpView;
import com.ming.sjll.message.viewmodel.MessageChatViewModel;

public interface UploadPdfMessageView extends MvpView {
    void onShowData(MessageChatViewModel viewModel);
}
