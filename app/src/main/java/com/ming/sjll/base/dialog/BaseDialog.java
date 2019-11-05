package com.ming.sjll.base.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.ming.sjll.R;
import com.ming.sjll.base.utils.Tools;

public abstract class BaseDialog extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = new Dialog(getActivity(), R.style.DialogTheme);
        if (dialog.getWindow() != null) {
            dialog.getWindow().setDimAmount(0.65f);
        }
        ViewDataBinding binding = getLayoutBind();
        View view = binding.getRoot();
        dialog.setContentView(view);
        initView(binding);
        initWindowParams(dialog);
        return dialog;
    }

    @Override
    public void show(FragmentManager manager, String tag) {
        try {
            super.show(manager, tag);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    // 设置Dialog属性
    protected void initWindowParams(Dialog dialog) {
        Window win = dialog.getWindow();
        if (win != null) {
            WindowManager.LayoutParams lp = win.getAttributes();
            if (isBottom()) {
                win.setWindowAnimations(R.style.DialogTheme_BottomAnimation);
                lp.width = Tools.getScreenWidth(getActivity());
                lp.gravity = Gravity.BOTTOM;
            } else {
                lp.gravity = Gravity.CENTER;
                lp.width = (int) (Tools.getScreenWidth(getActivity()) * 0.267f);
            }
            lp.height = WindowManager.LayoutParams.WRAP_CONTENT;

            win.setAttributes(lp);
        }
    }

    public boolean isBottom() {
        return true;
    }

    public ViewDataBinding getLayoutBind() {
        return DataBindingUtil.inflate(getActivity().getLayoutInflater(), getLayoutId(), null, false);
    }

    public abstract int getLayoutId();

    public abstract void initView(ViewDataBinding dataBinding);

    public void show(Object object) {
        show(object, this.toString());
    }

    public void show(Object object, String tag) {
        if (object instanceof Activity) {
           FragmentManager manager = ((FragmentActivity) object).getSupportFragmentManager();
            if (isAdded()) {
                dismiss();
            }
            super.show(manager, tag);
        } else if (object instanceof Fragment) {
           FragmentManager fragmentManager = ((Fragment) object).getActivity().getSupportFragmentManager();
            if (isAdded()) {
                dismiss();
            }
            super.show(fragmentManager, tag);

        }
    }

    public void showWithCommit(Object object, String tag) {
        if (object instanceof Activity) {
            FragmentManager manager = ((FragmentActivity) object).getSupportFragmentManager();
            if (isAdded()) {
                dismiss();
            }
            manager.beginTransaction().add(this, tag).commitAllowingStateLoss();
        } else if (object instanceof Fragment) {
           FragmentManager fragmentManager = ((Fragment) object).getActivity().getSupportFragmentManager();
            if (isAdded()) {
                dismiss();
            }
            fragmentManager.beginTransaction().add(this, tag).commitAllowingStateLoss();

        }
    }
}
