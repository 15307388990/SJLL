package com.ming.sjll.purchaser.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ming.sjll.R;
import com.ming.sjll.base.fragment.MvpFragment;
import com.ming.sjll.base.utils.Tools;
import com.ming.sjll.purchaser.presenter.HotArticlePresenter;
import com.ming.sjll.purchaser.view.HotArticleView;
import com.ming.sjll.supplier.bean.HotArticleBean;

import butterknife.BindView;

/**
 * @author luoming
 * created at 2019-10-14 10:32
 * 热门文章
 */
public class HotArticleFragemt extends MvpFragment<HotArticleView, HotArticlePresenter> implements HotArticleView {


    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_img1)
    ImageView ivImg1;
    @BindView(R.id.tv_title1)
    TextView tvTitle1;
    @BindView(R.id.rl_1)
    RelativeLayout rl1;
    @BindView(R.id.iv_img2)
    ImageView ivImg2;
    @BindView(R.id.tv_title2)
    TextView tvTitle2;
    @BindView(R.id.rl_2)
    RelativeLayout rl2;
    @BindView(R.id.iv_img3)
    ImageView ivImg3;
    @BindView(R.id.tv_title3)
    TextView tvTitle3;
    @BindView(R.id.rl_3)
    RelativeLayout rl3;
    @BindView(R.id.tv_timer1)
    TextView tvTimer1;
    @BindView(R.id.tv_timer2)
    TextView tvTimer2;
    @BindView(R.id.tv_timer3)
    TextView tvTimer3;

    public static HotArticleFragemt newInstance() {
        return new HotArticleFragemt();
    }

    @Override
    protected void onCreateView(Bundle savedInstanceState) {
        super.onCreateView(savedInstanceState);
        setContentView(R.layout.fragemt_hotarticle);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.getHotArticle();
    }

    @Override
    protected HotArticlePresenter createPresenter() {
        return new HotArticlePresenter();
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
    public void setHotArticle(HotArticleBean areaBean) {
        tvTitle.setText(areaBean.getData().getTitle());
        if (areaBean.getData().getData().size() > 0) {
            tvTitle1.setText(areaBean.getData().getData().get(0).getTitle());
            tvTimer1.setText(Tools.getDateformat(areaBean.getData().getData().get(0).getCreated_time()));
            if (areaBean.getData().getData().size() > 1) {
                tvTitle2.setText(areaBean.getData().getData().get(1).getTitle());
                tvTimer2.setText(Tools.getDateformat(areaBean.getData().getData().get(1).getCreated_time()));
                if (areaBean.getData().getData().size() > 2) {
                    tvTitle3.setText(areaBean.getData().getData().get(1).getTitle());
                    tvTimer3.setText(Tools.getDateformat(areaBean.getData().getData().get(1).getCreated_time()));
                } else {
                    rl3.setVisibility(View.GONE);
                }
            } else {
                rl2.setVisibility(View.GONE);
            }

        } else {
            rl1.setVisibility(View.GONE);
            rl2.setVisibility(View.GONE);
            rl3.setVisibility(View.GONE);
        }

    }
}
