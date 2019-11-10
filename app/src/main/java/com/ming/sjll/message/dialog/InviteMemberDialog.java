package com.ming.sjll.message.dialog;

import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.view.View;

import com.ming.sjll.R;
import com.ming.sjll.base.dialog.BaseDialog;
import com.ming.sjll.databinding.DialogInviteMemberBinding;

public class InviteMemberDialog extends BaseDialog {


    public static InviteMemberDialog newInstance() {

        Bundle args = new Bundle();
        InviteMemberDialog fragment = new InviteMemberDialog();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.dialog_invite_member;
    }

    @Override
    public void initView(ViewDataBinding dataBinding) {
        DialogInviteMemberBinding binding = (DialogInviteMemberBinding) dataBinding;

        binding.ivClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        binding.tvSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //发送邀请
                if (onClickListener != null){
                    onClickListener.onClick(v);
                }
                dismiss();
            }
        });
    }

    private View.OnClickListener onClickListener;

    public InviteMemberDialog setOnClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
        return this;
    }

    @Override
    public boolean isBottom() {
        return true;
    }
}
