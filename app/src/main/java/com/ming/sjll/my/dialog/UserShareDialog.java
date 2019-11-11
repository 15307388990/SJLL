package com.ming.sjll.my.dialog;

import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.view.View;

import com.ming.sjll.R;
import com.ming.sjll.base.dialog.BaseDialog;
import com.ming.sjll.databinding.DialogInviteShareBinding;
import com.ming.sjll.message.dialog.InviteMemberDialog;
/**
 * @author luoming
 *created at 2019-11-09 22:49
 * 用户分享
*/

public class UserShareDialog extends BaseDialog {


    public static UserShareDialog newInstance() {

        Bundle args = new Bundle();
        UserShareDialog fragment = new UserShareDialog();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.dialog_user_share;
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
                InviteMemberDialog.newInstance().show(getActivity());
            }
        });
    }


    @Override
    public boolean isBottom() {
        return true;
    }
}
