package com.ming.sjll.message.dialog;

import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.view.View;

import com.ming.sjll.R;
import com.ming.sjll.base.dialog.BaseDialog;
import com.ming.sjll.databinding.DialogManagerMemberBinding;
import com.ming.sjll.message.viewmodel.ManagerMemberInfoViewModel;

public class ManagerMemberInfoDialog extends BaseDialog {

    private DialogManagerMemberBinding binding;
    private ManagerMemberInfoViewModel viewModel;

    public static ManagerMemberInfoDialog newInstance(ManagerMemberInfoViewModel viewModel) {

        Bundle args = new Bundle();
        args.putParcelable("info", viewModel);
        ManagerMemberInfoDialog fragment = new ManagerMemberInfoDialog();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.dialog_manager_member;
    }

    @Override
    public void initView(ViewDataBinding dataBinding) {
        binding = (DialogManagerMemberBinding) dataBinding;

        if (getArguments() != null) {
            viewModel = getArguments().getParcelable("info");
            if (viewModel != null) {
                binding.nsPosition.setText(viewModel.getPosition());
                binding.tvRemark.setText(viewModel.getName());
            }

        }


        binding.tvSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //保存
            }
        });
        binding.ivClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });


    }


}
