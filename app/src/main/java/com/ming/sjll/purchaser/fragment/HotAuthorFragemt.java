package com.ming.sjll.purchaser.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.ming.sjll.R;
import com.ming.sjll.api.Constant;
import com.ming.sjll.base.fragment.MvpFragment;
import com.ming.sjll.base.utils.ImageHelper;
import com.ming.sjll.databinding.FragemtHotAuthBinding;
import com.ming.sjll.purchaser.presenter.HotAuthorPresenter;
import com.ming.sjll.purchaser.view.HotAuthorView;
import com.ming.sjll.supplier.bean.HotAuthorBean;


/**
 * @author luoming
 * created at 2019-10-14 10:32
 * 热门作者
 */
public class HotAuthorFragemt extends MvpFragment<HotAuthorView, HotAuthorPresenter> implements HotAuthorView {

    private FragemtHotAuthBinding binding;

    public static HotAuthorFragemt newInstance() {
        return new HotAuthorFragemt();
    }

    @Override
    protected void onCreateView(Bundle savedInstanceState) {
        super.onCreateView(savedInstanceState);
        binding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.fragemt_hot_auth, null, false);
        setContentView(binding.getRoot());

    }

    @Override
    protected HotAuthorPresenter createPresenter() {
        return new HotAuthorPresenter();
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
    public void setHotAuthor(HotAuthorBean areaBean) {
        binding.tvTitle.setText(areaBean.getData().getTitle());
        if (areaBean.getData().getData().size() > 0) {
            binding.tvName.setText(areaBean.getData().getData().get(0).getName());
            binding.tvProfessional.setText(areaBean.getData().getData().get(0).getOccupation().toString());
            ImageHelper.displayBackground(binding.ivImg, Constant.BASE_API + areaBean.getData().getData().get(0).getDefault_avatar(), R.mipmap.ic_launcher);
            if (areaBean.getData().getData().size() > 1) {
                binding.tvName2.setText(areaBean.getData().getData().get(1).getName());
                binding.tvProfessional2.setText(areaBean.getData().getData().get(1).getOccupation().toString());
                ImageHelper.displayBackground(binding.ivImg2, Constant.BASE_API + areaBean.getData().getData().get(1).getDefault_avatar(), R.mipmap.ic_launcher);

            } else {
                binding.llLayout2.setVisibility(View.GONE);
            }

        } else {
            binding.llLayout2.setVisibility(View.GONE);
            binding.llLayout.setVisibility(View.GONE);
        }

    }
}
