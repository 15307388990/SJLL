package com.ming.sjll.supplier.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ming.sjll.R;
import com.ming.sjll.api.Constant;
import com.ming.sjll.base.fragment.MvpFragment;
import com.ming.sjll.base.utils.ImageHelper;
import com.ming.sjll.purchaser.fragment.HotArticleFragemt;
import com.ming.sjll.purchaser.view.CustomRoundAngleImageView;
import com.ming.sjll.supplier.adapter.Visualdapter;
import com.ming.sjll.supplier.bean.ArticleListBean;
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

    private Visualdapter visualdapter;
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
        mPresenter.showDate();
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
    public void setArticleList(ArticleListBean bean) {
        visualdapter = new Visualdapter(bean.getData().getData());
        mPresenter.getTopArtic();

    }

    @Override
    public void setTopArticle(TopArticleBean bean) {
        headView = LinearLayout.inflate(getActivity(), R.layout.fragemt_visual_top_itm, null);
        CustomRoundAngleImageView imageView = headView.findViewById(R.id.iv_img);
        ImageHelper.displayBackground(imageView, Constant.BASE_API + bean.getData().getCover_img(), R.drawable.ic_launcher_background);
        TextView tv_title = headView.findViewById(R.id.tv_title);
        tv_title.setText(bean.getData().getTitle());
        TextView tv_yuanchuang = headView.findViewById(R.id.tv_yuanchuang);
        if (bean.getData().getIs_original() == 1) {
            tv_yuanchuang.setVisibility(View.VISIBLE);
        } else {
            tv_yuanchuang.setVisibility(View.GONE);
        }
        ViewPager viewPager = headView.findViewById(R.id.viewpager);
        fragmentList.add(HotArticleFragemt.newInstance());
        fragmentList.add(HotArticleFragemt.newInstance());
        viewPager.setAdapter(new Adapter(getChildFragmentManager()));

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
