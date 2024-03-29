package com.ming.sjll.message.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.ming.sjll.R;
import com.ming.sjll.base.activity.MvpActivity;
import com.ming.sjll.base.viewmodel.ToolbarViewModel;
import com.ming.sjll.databinding.ActivityUploadPdfBinding;
import com.ming.sjll.message.presenter.UploadPdfMessagePresenter;
import com.ming.sjll.message.view.UploadPdfMessageView;
import com.ming.sjll.message.viewmodel.MessageChatViewModel;
import com.ming.sjll.message.viewmodel.ProjectChatViewModel;

public class UploadPdfMessageActivity extends MvpActivity<UploadPdfMessageView, UploadPdfMessagePresenter> implements UploadPdfMessageView {
    private ActivityUploadPdfBinding viewDataBinding;
    private MessageChatViewModel viewModel;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_upload_pdf);
        viewDataBinding.setTitleViewModel(new ToolbarViewModel("方案上传"));
        viewModel = new MessageChatViewModel();
        viewDataBinding.setViewModel(viewModel);
    }

    @Override
    public void onShowData(ProjectChatViewModel projectChatViewModel) {
       viewModel.setProjectChatViewModel(projectChatViewModel);
    }
}
