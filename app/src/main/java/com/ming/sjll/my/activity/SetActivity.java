package com.ming.sjll.my.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.ming.sjll.R;
import com.ming.sjll.base.activity.MvpActivity;
import com.ming.sjll.base.utils.Tools;
import com.ming.sjll.base.viewmodel.ToolbarViewModel;
import com.ming.sjll.databinding.ActivityComplainBinding;
import com.ming.sjll.databinding.ActivitySetBinding;
import com.ming.sjll.my.bean.VersionBean;
import com.ming.sjll.my.dialog.VersionUpgradeDialog;
import com.ming.sjll.my.presenter.SetPresenter;
import com.ming.sjll.my.view.SetDataView;


/**
 * @author luoming
 * created at 2019-11-09 20:54
 * 设置界面
 */

public class SetActivity extends MvpActivity<SetDataView, SetPresenter> implements SetDataView {


    private ActivitySetBinding setBinding;
    private VersionBean versionBean = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBinding = DataBindingUtil.setContentView(this, R.layout.activity_set);
        setBinding.setTitleViewModel(new ToolbarViewModel("设置"));
        setBinding.llReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Tools.jump(SetActivity.this, ResetPasswordAcitivity.class, false);
            }
        });
        setBinding.llVersion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (versionBean != null) {
                    int version = Tools.packageCode(SetActivity.this);
                    if (versionBean.getData().getVersionCode() > version) {
                        VersionUpgradeDialog.newInstance(versionBean).show(SetActivity.this);
                    }
                }

            }
        });

    }


    @Override
    public void ShowData(VersionBean pBean) {
        versionBean = pBean;
        int version = Tools.packageCode(SetActivity.this);
        if (pBean.getData().getVersionCode() > version) {
            setBinding.ivVersion.setVisibility(View.VISIBLE);
        }
        setBinding.tvVersion.setText("当前版本 v" + Tools.getVersionName(SetActivity.this));
    }
}
