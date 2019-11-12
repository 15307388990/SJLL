package com.ming.sjll.my.adapter;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.luck.picture.lib.PictureSelector;
import com.ming.sjll.R;
import com.ming.sjll.api.Constant;
import com.ming.sjll.base.utils.ImageHelper;
import com.ming.sjll.base.utils.Tools;
import com.ming.sjll.my.bean.AdsBean;
import com.ming.sjll.my.bean.CurriculumBean;

import java.util.List;


/**
 * @author luoming
 * created at 2019-10-22 17:01
 * 投广列表
 */
public class AdsListAdapter extends BaseQuickAdapter<AdsBean.DataBeanX.DataBean, BaseViewHolder> {

    public AdsListAdapter(@Nullable List<AdsBean.DataBeanX.DataBean> data) {
        super(R.layout.ads_item, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, AdsBean.DataBeanX.DataBean dataBean) {
        baseViewHolder.setText(R.id.tv_title, dataBean.getTitle());
        ImageHelper.displayBackground((ImageView) baseViewHolder.getView(R.id.iv_img), Constant.BASE_API + dataBean.getBackground_img(), R.drawable.ic_launcher_background);
        baseViewHolder.setText(R.id.tv_timer, "于" + Tools.getDateformat(dataBean.getPut_time()) + "投放");
        baseViewHolder.setText(R.id.tv_content, dataBean.getContent());


    }

}