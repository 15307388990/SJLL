package com.ming.sjll.purchaser.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

import com.ming.sjll.R;
import com.ming.sjll.base.fragment.MvpFragment;
import com.ming.sjll.base.utils.TextUtil;
import com.ming.sjll.base.widget.ToastShow;
import com.ming.sjll.purchaser.adapter.TagAdapter;
import com.ming.sjll.purchaser.presenter.ProjectSupplierPresenter;
import com.ming.sjll.purchaser.view.ProjectView;
import com.ming.sjll.purchaser.view.PublishProjectView;
import com.ming.sjll.purchaser.view.SupplierView;
import com.ming.sjll.view.FlowTagLayout;
import com.ming.sjll.view.OnTagSelectListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * @author luoming
 * created at 2019-10-14 10:32
 * 简介
 */
public class IntroductionFragemt extends MvpFragment<SupplierView, ProjectSupplierPresenter> implements ProjectView {


    @BindView(R.id.flowtag)
    FlowTagLayout flowtag;
    @BindView(R.id.et_biaoqian)
    EditText etBiaoqian;
    @BindView(R.id.tv_add)
    TextView tvAdd;
    private List<String> biaoqianList;
    private PublishProjectView publishProjectView;

    public static IntroductionFragemt newInstance() {
        return new IntroductionFragemt();
    }

    @Override
    protected void onCreateView(Bundle savedInstanceState) {
        super.onCreateView(savedInstanceState);
        setContentView(R.layout.fragemt_introduction);
        initFlowtag();
    }

    public IntroductionFragemt setPublishProjectView(PublishProjectView publishProjectView) {
        this.publishProjectView = publishProjectView;
        return this;
    }

    private void initFlowtag() {
        TagAdapter tagAdapter = new TagAdapter(getActivity());
        flowtag.setTagCheckedMode(FlowTagLayout.FLOW_TAG_CHECKED_MULTI);//支持多选
        flowtag.setAdapter(tagAdapter);
        biaoqianList = new ArrayList<>();
        tvAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtil.isEquals(etBiaoqian.getText().toString(), "")) {
                    biaoqianList.add(etBiaoqian.getText().toString().trim());
                    etBiaoqian.setText("");
                    tagAdapter.clearAndAddAll(biaoqianList);
                    publishProjectView.fullScrollTop(ScrollView.FOCUS_DOWN);
                } else {
                    ToastShow.s("标签内容不能为空");
                }

            }
        });
        flowtag.setOnTagSelectListener(new OnTagSelectListener() {
            @Override
            public void onItemSelect(FlowTagLayout parent, List<Integer> selectedList) {
                if (selectedList != null && selectedList.size() > 0) {
                    StringBuilder sb = new StringBuilder();

                    for (int i : selectedList) {
                        sb.append(parent.getAdapter().getItem(i));
                        sb.append(":");
                    }
                    ToastShow.s(sb.toString());
                } else {

                }
            }
        });


    }


    @Override
    protected ProjectSupplierPresenter createPresenter() {
        return new ProjectSupplierPresenter();
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

}
