package com.ming.sjll.projectmanage.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.ming.sjll.R;
import com.ming.sjll.base.fragment.MvpFragment;
import com.ming.sjll.base.utils.Tools;
import com.ming.sjll.projectmanage.activity.PublishProjectAcitivity;
import com.ming.sjll.projectmanage.bean.ZhaoRenBean;
import com.ming.sjll.projectmanage.presenter.ProjectSupplierPresenter;
import com.ming.sjll.projectmanage.presenter.PurchaserHomePresenter;
import com.ming.sjll.projectmanage.view.ProjectView;
import com.ming.sjll.projectmanage.view.PurchaserHomeView;
import com.ming.sjll.projectmanage.view.SupplierView;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

/**
 * @author luoming
 * created at 2019-10-14 10:32
 * 采购商首页
 */
public class PurchaserHomeFragemt extends MvpFragment<PurchaserHomeView, PurchaserHomePresenter> implements PurchaserHomeView {


    @BindView(R.id.tv_fabu)
    TextView tvFabu;
    @BindView(R.id.tv_zhaoren)
    TextView tvZhaoren;
    @BindView(R.id.tv_guangli)
    TextView tvGuangli;
    @BindView(R.id.tv_shuoming)
    TextView tvShuoming;
    @BindView(R.id.tv_fuwu)
    TextView tvFuwu;
    @BindView(R.id.tv_zhaor)
    TextView tvZhaor;
    @BindView(R.id.rv_zhaoren)
    RecyclerView rvZhaoren;
    @BindView(R.id.tv_jiewu)
    TextView tvJiewu;
    @BindView(R.id.rv_jiewu)
    RecyclerView rvJiewu;

    public static PurchaserHomeFragemt newInstance() {
        return new PurchaserHomeFragemt();
    }

    @Override
    protected void onCreateView(Bundle savedInstanceState) {
        super.onCreateView(savedInstanceState);
        setContentView(R.layout.fragemt_purchaser_home);
        tvFabu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Tools.jump(getActivity(),PublishProjectAcitivity.class,false);
            }
        });

    }

    @Override
    protected PurchaserHomePresenter createPresenter() {
        return new PurchaserHomePresenter();
    }

    @Override
    public void showLoading(String msg) {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError(String msg) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void ShowDate(List<ZhaoRenBean> list) {

    }
}
