package com.ming.sjll.message.dialog;

import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.view.View;

import com.ming.sjll.R;
import com.ming.sjll.base.dialog.BaseDialog;
import com.ming.sjll.databinding.DialogInviteShareBinding;

public class InviteMemberShareDialog extends BaseDialog {


    public static InviteMemberShareDialog newInstance() {

        Bundle args = new Bundle();
        InviteMemberShareDialog fragment = new InviteMemberShareDialog();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.dialog_invite_share;
    }

    @Override
    public void initView(ViewDataBinding dataBinding) {
        DialogInviteShareBinding binding = (DialogInviteShareBinding) dataBinding;

        binding.ivClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        binding.tvSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        binding.tvWechat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        binding.tvMoment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        binding.tvColleague.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InviteMemberDialog.newInstance().setOnClickListener(onClickListener).show(getActivity());
            }
        });
    }
    private View.OnClickListener onClickListener;

    public InviteMemberShareDialog setOnClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
        return this;
    }


    @Override
    public boolean isBottom() {
        return true;
    }
}
