package com.ming.sjll.my.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.ming.sjll.R;
import com.ming.sjll.base.fragment.MvpFragment;
import com.ming.sjll.base.utils.FullLinearLayout;
import com.ming.sjll.base.widget.ToastShow;
import com.ming.sjll.my.adapter.PersonalDataAdapter;
import com.ming.sjll.my.bean.PersonalDateBean;
import com.ming.sjll.my.dialog.EditorDataDialog;
import com.ming.sjll.my.dialog.EditorDialog;
import com.ming.sjll.my.presenter.PersonalDataPresenter;
import com.ming.sjll.my.view.PersonalDataView;

import butterknife.BindView;

/**
 * @author luoming
 * created at 2019-11-01 11:37
 * 个人中心，个人资料
 */

public class PersonalDataFragemt extends MvpFragment<PersonalDataView, PersonalDataPresenter> implements PersonalDataView {


    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;

    private EditorDataDialog editorDataDialog;

    public static PersonalDataFragemt newInstance() {
        return new PersonalDataFragemt();
    }

    @Override
    protected void onCreateView(Bundle savedInstanceState) {
        super.onCreateView(savedInstanceState);
        setContentView(R.layout.fragemt_recycle);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.getWorksList();
    }

    @Override
    protected PersonalDataPresenter createPresenter() {
        return new PersonalDataPresenter();
    }

    @Override
    public void showLoading(String msg) {
        ToastShow.s(msg);
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
    public void ShowData(PersonalDateBean pbean) {
        recyclerview.setLayoutManager(new FullLinearLayout(getActivity(), 1) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        PersonalDataAdapter personalDataAdapter = new PersonalDataAdapter(pbean.getData().getData());
        recyclerview.setAdapter(personalDataAdapter);
        personalDataAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                if (view.getId() == R.id.iv_menu) {
                    EditorDialog.newInstance().setOnClickListener(new EditorDialog.OnClickListener() {
                        @Override
                        public void Editor() {
                            editorDataDialog = EditorDataDialog.newInstance(pbean.getData().getData().get(position)).setOnClickListener(null);
                            editorDataDialog.show(getActivity());
                        }

                        @Override
                        public void Delete() {
                            mPresenter.delWork(pbean.getData().getData().get(position).getId() + "");
                        }
                    }).show(getActivity());
                }
            }
        });


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (editorDataDialog != null) {
            editorDataDialog.onActivityResult(requestCode, resultCode, data);
        }
    }
}
