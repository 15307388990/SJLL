package com.ming.sjll.my.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ming.sjll.R;
import com.ming.sjll.api.Constant;
import com.ming.sjll.base.utils.Tools;
import com.ming.sjll.my.bean.PersonalDateBean;
import com.ming.sjll.purchaser.bean.OccupationBean;

import java.util.List;

import androidx.annotation.Nullable;

/**
 * @author luoming
 *created at 2019-10-27 16:08
*/
public class PersonalDataAdapter extends BaseQuickAdapter<PersonalDateBean.DataBeanX.DataBean, BaseViewHolder> {

    public PersonalDataAdapter(@Nullable List<PersonalDateBean.DataBeanX.DataBean> data) {
        super(R.layout.personal_data_item, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder,PersonalDateBean.DataBeanX.DataBean dataBean) {
        baseViewHolder.setText(R.id.tv_title, dataBean.getTitle());
        baseViewHolder.setText(R.id.tv_describe,dataBean.getDescribe());
        baseViewHolder.setText(R.id.tv_day, Tools.getDateformat3(dataBean.getCreated_time(),"dd"));
        baseViewHolder.setText(R.id.tv_describe,Tools.getDateformat3(dataBean.getCreated_time(),"MM")+"月");

    }

}