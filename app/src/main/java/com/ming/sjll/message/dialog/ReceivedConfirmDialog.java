package com.ming.sjll.message.dialog;

import android.databinding.ViewDataBinding;
import android.os.Bundle;

import com.ming.sjll.R;
import com.ming.sjll.base.dialog.BaseDialog;

public class ReceivedConfirmDialog extends BaseDialog {

    private static final String CONTENT = "content";

    public static ReceivedConfirmDialog newInstance(String content) {
        
        Bundle args = new Bundle();
        args.putString(CONTENT,content);
        ReceivedConfirmDialog fragment = new ReceivedConfirmDialog();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public int getLayoutId() {
        return R.layout.dialog_receive_confirm;
    }

    @Override
    public void initView(ViewDataBinding dataBinding) {

    }

    @Override
    public boolean isBottom() {
        return false;
    }
}
