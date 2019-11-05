package com.ming.sjll.my.dialog;

import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.view.View;

import com.ming.sjll.R;
import com.ming.sjll.base.dialog.BaseDialog;
import com.ming.sjll.databinding.DialogMyEditorBinding;

public class EditorDialog extends BaseDialog {

    private OnClickListener onClickListener;

    public static EditorDialog newInstance() {

        Bundle args = new Bundle();
        EditorDialog fragment = new EditorDialog();
        fragment.setArguments(args);
        return fragment;
    }

    public EditorDialog setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
        return this;
    }


    @Override
    public int getLayoutId() {
        return R.layout.dialog_my_editor;
    }

    @Override
    public void initView(ViewDataBinding dataBinding) {
        DialogMyEditorBinding editorBinding = (DialogMyEditorBinding) dataBinding;
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
                    onClickListener.Editor();
                }

            }
        });
        editorBinding.tvDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                if (onClickListener != null) {
                    onClickListener.Delete();
                }

            }
        });


    }

    @Override
    public boolean isBottom() {
        return true;
    }

   public interface OnClickListener {
        void Editor();

        void Delete();
    }
}
