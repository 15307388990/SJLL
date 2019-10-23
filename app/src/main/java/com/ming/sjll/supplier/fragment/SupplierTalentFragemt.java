package com.ming.sjll.supplier.fragment;

import android.annotation.SuppressLint;
import android.graphics.pdf.PdfRenderer;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.ming.sjll.R;
import com.ming.sjll.base.fragment.MvpFragment;
import com.ming.sjll.base.widget.ToastShow;
import com.ming.sjll.purchaser.bean.AreaBean;
import com.ming.sjll.purchaser.presenter.PurchaserHomePresenter;
import com.ming.sjll.purchaser.view.PurchaserHomeView;
import com.ming.sjll.view.WrapContentHeightViewPager;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.databinding.adapters.CardViewBindingAdapter;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import butterknife.BindView;

/**
 * @author luoming
 * created at 2019-10-14 10:32
 * 供应商达人
 */
public class SupplierTalentFragemt extends MvpFragment<PurchaserHomeView, PurchaserHomePresenter> implements PurchaserHomeView {


    public static SupplierTalentFragemt newInstance() {
        return new SupplierTalentFragemt();
    }

    @Override
    protected void onCreateView(Bundle savedInstanceState) {
        super.onCreateView(savedInstanceState);
        setContentView(R.layout.fragemt_supplier_talent);


    }

    private void initViewpage() {
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
        ToastShow.s(msg);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void ShowDate(List<AreaBean> list) {

    }

    class Adaper extends PagerAdapter {
        private List<CardView> cardViewList;

        public Adaper(FragmentManager fm, List<CardView> cardViewList) {
            this.cardViewList = cardViewList;
        }

        @Override
        public int getCount() {
            return cardViewList.size();
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {

            return super.instantiateItem(container, position);
        }
    }
}
