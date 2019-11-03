package com.ming.sjll.message.presenter;

import android.os.Bundle;

import com.ming.sjll.base.presenter.MvpPresenter;
import com.ming.sjll.base.utils.Tools;
import com.ming.sjll.message.activity.UploadPdfMessageActivity;
import com.ming.sjll.message.view.MessageView;

public class MessagePresenter extends MvpPresenter<MessageView> {


    public void jumpUploadPdfActivity(){
        Bundle bundle = new Bundle();
        bundle.putString(UploadPdfMessagePresenter.PROJECT_ID,"1");
        Tools.jump(getActivity(), UploadPdfMessageActivity.class, bundle,false);
    }
}
