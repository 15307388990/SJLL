package com.ming.sjll.purchaser.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.ming.sjll.R;
import com.ming.sjll.api.Constant;
import com.ming.sjll.base.fragment.MvpFragment;
import com.ming.sjll.base.utils.ImageHelper;
import com.ming.sjll.base.utils.Tools;
import com.ming.sjll.purchaser.activity.PublishProjectAcitivity;
import com.ming.sjll.purchaser.presenter.PurchaserHomePresenter;
import com.ming.sjll.purchaser.view.CustomRoundAngleImageView;
import com.ming.sjll.purchaser.view.PurchaserHomeView;
import com.ming.sjll.supplier.adapter.JieWuAdapter;
import com.ming.sjll.supplier.adapter.SupplierHomeAdapter;
import com.ming.sjll.supplier.adapter.ZharRenAdapter;
import com.ming.sjll.supplier.bean.CikunmBean;
import com.ming.sjll.supplier.bean.HomeAdsBean;
import com.ming.sjll.supplier.bean.HomeColumBean;

import butterknife.BindView;

/**
 * @author luoming
 * created at 2019-10-14 10:32
 * 采购商首页
 */
public class PurchaserHomeFragemt extends MvpFragment<PurchaserHomeView, PurchaserHomePresenter> implements PurchaserHomeView {

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
    @BindView(R.id.iv_img)
    CustomRoundAngleImageView ivImg;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;

    public static PurchaserHomeFragemt newInstance() {
        return new PurchaserHomeFragemt();
    }

    @Override
    protected void onCreateView(Bundle savedInstanceState) {
        super.onCreateView(savedInstanceState);
        setContentView(R.layout.fragemt_purchaser_home);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.showDate();
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
    public void ShowDate(HomeColumBean homeColumBean) {
        recyclerview.setLayoutManager(new GridLayoutManager(getActivity(), 4));
        SupplierHomeAdapter supplierHomeAdapter = new SupplierHomeAdapter(homeColumBean.getData());
        recyclerview.setAdapter(supplierHomeAdapter);
        supplierHomeAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                if (homeColumBean.getData().get(position).getTitle().equals("发布项目")){
                    Tools.jump(getActivity(), PublishProjectAcitivity.class,false);
                }
            }
        });

    }

    @Override
    public void ShowImg(HomeAdsBean bean) {
        if (bean.getData().getBanner_img() != null) {
            ivImg.setVisibility(View.VISIBLE);
            ImageHelper.displayBackground((ivImg), Constant.BASE_API + bean.getData().getBanner_img(), R.drawable.ic_launcher_background);

        } else {
            ivImg.setVisibility(View.GONE);
        }

    }

    @Override
    public void ShowCikunm(CikunmBean bean) {
        rvZhaoren.setLayoutManager(new GridLayoutManager(getActivity(), 4));
        ZharRenAdapter zharRenAdapter=new ZharRenAdapter(bean.getData().getPerson());
        rvZhaoren.setAdapter(zharRenAdapter);
        rvJiewu.setLayoutManager(new GridLayoutManager(getActivity(), 4));
        JieWuAdapter jieWuAdapter=new JieWuAdapter(bean.getData().getThings());
        rvJiewu.setAdapter(jieWuAdapter);



    }
}
