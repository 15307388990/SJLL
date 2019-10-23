package com.ming.sjll.purchaser.fragment;

import android.os.Bundle;
import android.view.View;

import com.ming.sjll.R;
import com.ming.sjll.base.fragment.MvpFragment;
import com.ming.sjll.purchaser.bean.AreaBean;
import com.ming.sjll.purchaser.presenter.CityPresenter;
import com.ming.sjll.purchaser.view.CityView;
import com.ming.sjll.view.OnSpinnerItemSelectedListener;
import com.ming.sjll.view.SpinnerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import androidx.annotation.Nullable;
import butterknife.BindView;

/**
 * @author luoming
 * created at 2019-10-14 10:32
 * 概况
 */
public class CityFragemt extends MvpFragment<CityView, CityPresenter> implements CityView {


    @BindView(R.id.ns_shen)
    SpinnerView nsShen;
    @BindView(R.id.ns_shi)
    SpinnerView nsShi;
    @BindView(R.id.ns_qu)
    SpinnerView nsQu;
    @BindView(R.id.ns_tongcheng)
    SpinnerView nsTongcheng;

    private AreaBean shenAreaBean, shiAreaBean, quAreaBean;

    public static CityFragemt newInstance() {
        return new CityFragemt();
    }

    @Override
    protected void onCreateView(Bundle savedInstanceState) {
        super.onCreateView(savedInstanceState);
        setContentView(R.layout.fragemt_city);
        ininSpiner();

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.getrovince();
    }

    private void ininSpiner() {
        List<String> tongchengList = new LinkedList<>(Arrays.asList("否", "是"));
        nsTongcheng.attachDataSource(tongchengList);
        nsShen.setOnSpinnerItemSelectedListener(new OnSpinnerItemSelectedListener() {
            @Override
            public void onItemSelected(SpinnerView parent, View view, int position, long id) {
                mPresenter.getCity(shenAreaBean.getData().get(position).getId() + "");
            }
        });
    }

    @Override
    protected CityPresenter createPresenter() {
        return new CityPresenter();
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
    public void setProvince(AreaBean areaBean) {
        shenAreaBean = areaBean;
        List<String> shenList = new ArrayList<>();
        for (AreaBean.DataBean dataBean : areaBean.getData()) {
            shenList.add(dataBean.getArea_name());
        }
        nsShen.attachDataSource(shenList);
        mPresenter.getCity(shenAreaBean.getData().get(0).getId() + "");
    }

    @Override
    public void setCity(AreaBean areaBean) {
        shiAreaBean = areaBean;
        List<String> shiList = new ArrayList<>();
        for (AreaBean.DataBean dataBean : areaBean.getData()) {
            shiList.add(dataBean.getArea_name());
        }
        nsShi.attachDataSource(shiList);
        if (shiList.size()==1)
        {
            nsShi.setSelectedIndex(0);
        }
        mPresenter.getArea(shiAreaBean.getData().get(0).getId() + "");

    }

    @Override
    public void setArea(AreaBean areaBean) {
        quAreaBean = areaBean;
        List<String> quList = new ArrayList<>();
        for (AreaBean.DataBean dataBean : areaBean.getData()) {
            quList.add(dataBean.getArea_name());
        }
        nsQu.attachDataSource(quList);

    }
}
