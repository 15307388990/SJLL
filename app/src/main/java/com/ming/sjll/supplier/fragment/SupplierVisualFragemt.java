package com.ming.sjll.supplier.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.ming.sjll.R;
import com.ming.sjll.api.Constant;
import com.ming.sjll.base.fragment.MvpFragment;
import com.ming.sjll.base.utils.ImageHelper;
import com.ming.sjll.base.utils.Tools;
import com.ming.sjll.my.bean.ColumnListBean;
import com.ming.sjll.purchaser.adapter.Generaldapter;
import com.ming.sjll.purchaser.bean.OccupationBean;
import com.ming.sjll.purchaser.fragment.HotArticleFragemt;
import com.ming.sjll.purchaser.fragment.HotAuthorFragemt;
import com.ming.sjll.purchaser.view.CustomRoundAngleImageView;
import com.ming.sjll.supplier.activity.ColumnDetailsActivity;
import com.ming.sjll.supplier.adapter.ColumnListdapter;
import com.ming.sjll.supplier.bean.TopArticleBean;
import com.ming.sjll.supplier.presenter.SupplierVisualPresenter;
import com.ming.sjll.supplier.view.SupplierVisualView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * @author luoming
 * created at 2019-10-14 10:32
 * 供应商专栏
 */
public class SupplierVisualFragemt extends MvpFragment<SupplierVisualView, SupplierVisualPresenter> implements SupplierVisualView {


    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;

    private ColumnListdapter visualdapter;
    private View headView;

    private List<Fragment> fragmentList;

    public static SupplierVisualFragemt newInstance() {
        return new SupplierVisualFragemt();
    }

    @Override
    protected void onCreateView(Bundle savedInstanceState) {
        super.onCreateView(savedInstanceState);
        setContentView(R.layout.fragemt_purchaser_visual);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        fragmentList = new ArrayList<>();
    }

    @Override
    protected SupplierVisualPresenter createPresenter() {
        return new SupplierVisualPresenter();
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
    public void setColumnList(ColumnListBean bean) {
        visualdapter = new ColumnListdapter(bean.getData().getData());
        visualdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Bundle bundle = new Bundle();
                bundle.putString("column_id", bean.getData().getData().get(position).getCloumn_id() + "");
                Tools.jump(getActivity(), ColumnDetailsActivity.class, bundle,false);
            }
        });
        mPresenter.getTopArtic();

    }

    @Override
    public void setTopArticle(TopArticleBean bean) {
        headView = LinearLayout.inflate(getActivity(), R.layout.fragemt_visual_top_itm, null);
        CustomRoundAngleImageView imageView = headView.findViewById(R.id.iv_img);
        ImageHelper.displayBackground(imageView, Constant.BASE_API + bean.getData().getBg_img(), R.drawable.ic_launcher_background);
        TextView tv_title = headView.findViewById(R.id.tv_title);
        tv_title.setText(bean.getData().getTitle());
        TextView tv_yuanchuang = headView.findViewById(R.id.tv_yuanchuang);
        if (bean.getData().getIs_original() == 1) {
            tv_yuanchuang.setVisibility(View.VISIBLE);
        } else {
            tv_yuanchuang.setVisibility(View.GONE);
        }
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("column_id", bean.getData().getCloumn_id()+"");
                Tools.jump(getActivity(), ColumnDetailsActivity.class, bundle,false);
            }
        });

        ViewPager viewPager = headView.findViewById(R.id.viewpager);
        fragmentList.add(HotArticleFragemt.newInstance());
        fragmentList.add(HotAuthorFragemt.newInstance());
        viewPager.setAdapter(new Adapter(getChildFragmentManager()));

        mPresenter.getspOccupation();


    }

    @Override
    public void getspOccupation(OccupationBean bean) {
        LinearLayout ll_zhuanlan = headView.findViewById(R.id.ll_zhuanlan);
        ll_zhuanlan.setVisibility(View.VISIBLE);
        RecyclerView zhuanlanrecyclerView = headView.findViewById(R.id.recyclerview);
        zhuanlanrecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        zhuanlanrecyclerView.setAdapter(new Generaldapter(bean.getData()));

        visualdapter.setHeaderView(headView);
        recyclerview.setAdapter(visualdapter);
    }

    class Adapter extends FragmentStatePagerAdapter {
        public Adapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Override
        public float getPageWidth(int position) {
            if (position == 0 || position == 2) {
                return 0.8f;
            }
            return 1f;
        }

    }
}
