package com.ming.sjll.my.dialog;

import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.view.View;

import com.ming.sjll.R;
import com.ming.sjll.base.dialog.BaseDialog;
import com.ming.sjll.databinding.DialogHomePageBinding;
import com.ming.sjll.databinding.DialogMyEditorBinding;

public class HomePageDialog extends BaseDialog {
    /**
     * 主页弹框
     */
    private OnClickListener onClickListener;

    public static HomePageDialog newInstance() {

        Bundle args = new Bundle();
        HomePageDialog fragment = new HomePageDialog();
        fragment.setArguments(args);
        return fragment;
    }

    public HomePageDialog setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
        return this;
    }


    @Override
    public int getLayoutId() {
        return R.layout.dialog_home_page;
    }

    @Override
    public void initView(ViewDataBinding dataBinding) {
        DialogHomePageBinding editorBinding = (DialogHomePageBinding) dataBinding;
        editorBinding.tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        editorBinding.tvEditor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                if (onClickListener != null) {
                    onClickListener.Collection();
                }

            }
        });
        editorBinding.tvDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                if (onClickListener != null) {
                    onClickListener.Report();
                }

            }
        });


    }

    @Override
    public boolean isBottom() {
        return true;
    }

    public interface OnClickListener {
        //收藏
        void Collection();

        //举报
        void Report();
    }
}
