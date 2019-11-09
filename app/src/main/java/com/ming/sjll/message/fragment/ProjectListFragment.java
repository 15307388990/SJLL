package com.ming.sjll.message.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ming.sjll.R;
import com.ming.sjll.base.fragment.MvpFragment;
import com.ming.sjll.message.dialog.ChangeProjectDialog;
import com.ming.sjll.message.presenter.ProjectListPresenter;
import com.ming.sjll.supplier.adapter.Comprehendapter;
import com.ming.sjll.supplier.bean.ComprehenBean;
import com.ming.sjll.supplier.view.ComprehensiveView;

import butterknife.BindView;


public class ProjectListFragment extends MvpFragment<ComprehensiveView, ProjectListPresenter> implements ComprehensiveView {


    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;

    public static final String TYPE = "type";
    private ChangeProjectDialog.onClickProjectListener onClickProjectListener;

    public static ProjectListFragment newInstance(String type) {

        Bundle args = new Bundle();
        args.putString(TYPE, type);
        ProjectListFragment fragment = new ProjectListFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected void onCreateView(Bundle savedInstanceState) {
        super.onCreateView(savedInstanceState);
        setContentView(R.layout.fragemt_comprehensive);
    }

    @Override
    public void setProjectIntegrated(ComprehenBean bean) {
        recyclerview.setNestedScrollingEnabled(false);
        recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerview.setAdapter(new Comprehendapter(bean.getData().getData(), onClickProjectListener));
    }

    public ProjectListFragment setItemClick(ChangeProjectDialog.onClickProjectListener onClickProjectListener) {
        this.onClickProjectListener = onClickProjectListener;
        return this;
    }
}
