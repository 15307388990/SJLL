package com.ming.sjll.message.view;


import com.ming.sjll.base.view.MvpView;
import com.ming.sjll.message.viewmodel.ActivityUploadMessageViewModel;

public interface UploadPdfMessageView extends MvpView {
    void onShowData(ActivityUploadMessageViewModel viewModel);
}
