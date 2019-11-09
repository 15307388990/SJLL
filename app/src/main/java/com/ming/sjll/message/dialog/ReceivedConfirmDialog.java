package com.ming.sjll.message.dialog;

import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.view.View;

import com.ming.sjll.R;
import com.ming.sjll.base.dialog.BaseDialog;
import com.ming.sjll.databinding.DialogReceiveConfirmBinding;

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
        DialogReceiveConfirmBinding binding = (DialogReceiveConfirmBinding) dataBinding;
        binding.setContent(getArguments().getString(CONTENT));

        binding.tvNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        binding.tvYes.setOnClickListener(confirmListener);
    }

    View.OnClickListener confirmListener;

    public ReceivedConfirmDialog setConfirmListener(View.OnClickListener confirmListener) {
        this.confirmListener = confirmListener;
        return this;
    }

    @Override
    public boolean isBottom() {
        return false;
    }
}
