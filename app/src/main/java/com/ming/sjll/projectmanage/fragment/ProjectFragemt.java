package com.ming.sjll.projectmanage.fragment;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.ming.sjll.R;
import com.ming.sjll.base.fragment.MvpFragment;
import com.ming.sjll.projectmanage.presenter.ProjectPresenter;
import com.ming.sjll.projectmanage.view.ProjectView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import butterknife.BindView;


public class ProjectFragemt extends MvpFragment<ProjectView, ProjectPresenter> implements ProjectView {


    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.framelayout)
    FrameLayout framelayout;
    @BindView(R.id.radio_group)
    RadioGroup radioGroup;
    private ProjectPurchaserFragemt projectPurchaserFragemt;//采购商
    private ProjectSupplierFragemt projectSupplierFragemt;//供应商
    private Fragment[] mFragments;

    public static ProjectFragemt newInstance() {
        return new ProjectFragemt();
    }

    @Override
    protected void onCreateView(Bundle savedInstanceState) {
        super.onCreateView(savedInstanceState);
        setContentView(R.layout.fragemt_project);
        initView();
    }

    private void initView() {
        projectPurchaserFragemt = ProjectPurchaserFragemt.newInstance();
        projectSupplierFragemt = ProjectSupplierFragemt.newInstance();
        mFragments = new Fragment[]{projectPurchaserFragemt, projectSupplierFragemt};
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_1:
                        showFragment(projectPurchaserFragemt);
                        break;
                    case R.id.rb_2:
                        showFragment(projectSupplierFragemt);
                        break;

                }

            }
        });
        showFragment(projectPurchaserFragemt);

    }

    @Override
    protected ProjectPresenter createPresenter() {
        return new ProjectPresenter();
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

    /**
     * 显示fragment
     */
    private void showFragment(MvpFragment fragment) {
        if (!fragment.isAdded()) {
            getChildFragmentManager().beginTransaction().remove(fragment).commitAllowingStateLoss();
            FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
            transaction.add(R.id.framelayout, fragment, fragment.getClass().getName()).commitAllowingStateLoss();
            for (Fragment f : mFragments) {
                FragmentTransaction transaction2 = getChildFragmentManager().beginTransaction();
                if (f == fragment) {
                    if (fragment.isHidden()) {
                        transaction2.show(f).commitAllowingStateLoss();
                    }
                } else {
                    if (f.isAdded()) {
                        transaction2.hide(f).commitAllowingStateLoss();
                    }
                }
            }
        } else {
            for (Fragment f : mFragments) {
                FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
                if (f == fragment) {
                    if (fragment.isHidden()) {
                        transaction.show(f).commitAllowingStateLoss();
                    }
                } else {
                    if (f.isAdded()) {
                        transaction.hide(f).commitAllowingStateLoss();
                    }
                }
            }

        }
    }


}
