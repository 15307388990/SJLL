package com.ming.sjll.my.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ming.sjll.R;
import com.ming.sjll.api.Constant;
import com.ming.sjll.base.utils.ImageHelper;
import com.ming.sjll.my.bean.HomePageBean;
import com.ming.sjll.supplier.bean.TalentPushBean;

import java.util.List;


/**
 * @author luoming
 * created at 2019-10-22 17:01
 * 公司橱窗
 */
public class Companydapter extends BaseQuickAdapter<HomePageBean.DataBean.CompanyInfoBean.ShowCaseBean, BaseViewHolder> {

    public Companydapter(@Nullable List<HomePageBean.DataBean.CompanyInfoBean.ShowCaseBean> data) {
        super(R.layout.home_page_company_item, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, HomePageBean.DataBean.CompanyInfoBean.ShowCaseBean dataBean) {
        ImageHelper.displayBackground((ImageView) baseViewHolder.getView(R.id.iv_img), Constant.BASE_API + dataBean.getImg(), R.drawable.ic_launcher_background);
        baseViewHolder.setText(R.id.tv_name, dataBean.getTitle());

    }

}