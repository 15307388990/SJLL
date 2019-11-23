package com.ming.sjll.my.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.ming.sjll.R;
import com.ming.sjll.base.fragment.MvpFragment;
import com.ming.sjll.base.utils.Tools;
import com.ming.sjll.base.widget.ToastShow;
import com.ming.sjll.my.bean.ColumnListBean;
import com.ming.sjll.my.presenter.ColletionCoursePresenter;
import com.ming.sjll.my.presenter.ColletionProjectPresenter;
import com.ming.sjll.my.view.ColletionProjectlView;
import com.ming.sjll.purchaser.bean.OccupationBean;
import com.ming.sjll.supplier.activity.ColumnDetailsActivity;
import com.ming.sjll.supplier.adapter.ColumnListdapter;
import com.ming.sjll.supplier.adapter.Comprehendapter;
import com.ming.sjll.supplier.bean.ComprehenBean;
import com.ming.sjll.supplier.bean.TopArticleBean;
import com.ming.sjll.supplier.view.SupplierVisualView;

import butterknife.BindView;

/**
 * @author luoming
 * created at 2019-10-14 10:32
 * 收藏 课程
 */
public class CollectionCourseFragemt extends MvpFragment<SupplierVisualView, ColletionCoursePresenter> implements SupplierVisualView {
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;


    public static CollectionCourseFragemt newInstance() {
        CollectionCourseFragemt projectManagementFragemt = new CollectionCourseFragemt();
        return projectManagementFragemt;
    }

    @Override
    protected void onCreateView(Bundle savedInstanceState) {
        super.onCreateView(savedInstanceState);
        setContentView(R.layout.fragemt_recycle);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


    @Override
    protected ColletionCoursePresenter createPresenter() {
        return new ColletionCoursePresenter();
    }

    @Override
    public void showLoading(String msg) {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError(String msg) {
        ToastShow.s(msg);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }



    @Override
    public void setColumnList(ColumnListBean bean) {
        ColumnListdapter visualdapter = new ColumnListdapter(bean.getData().getData());
        visualdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Bundle bundle = new Bundle();
                bundle.putString("column_id", bean.getData().getData().get(position).getCloumn_id() + "");
                Tools.jump(getActivity(), ColumnDetailsActivity.class, bundle,false);
            }
        });
        recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerview.setAdapter(visualdapter);

    }

    @Override
    public void setTopArticle(TopArticleBean bean) {

    }

    @Override
    public void getspOccupation(OccupationBean bean) {

    }
}
