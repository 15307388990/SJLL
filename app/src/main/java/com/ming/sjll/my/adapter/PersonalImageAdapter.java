package com.ming.sjll.my.adapter;

import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ming.sjll.R;
import com.ming.sjll.api.Constant;
import com.ming.sjll.base.utils.ImageHelper;
import com.ming.sjll.base.utils.Tools;
import com.ming.sjll.my.bean.PersonalDateBean;

import java.util.List;


/**
 * @author luoming
 * created at 2019-10-27 16:08
 */
public class PersonalImageAdapter extends BaseQuickAdapter<PersonalDateBean.DataBeanX.DataBean.ImgListBean, BaseViewHolder> {

    public PersonalImageAdapter(@Nullable List<PersonalDateBean.DataBeanX.DataBean.ImgListBean> data) {
        super(R.layout.personal_imgview_item, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, PersonalDateBean.DataBeanX.DataBean.ImgListBean dataBean) {
        ImageHelper.displayBackground((ImageView) baseViewHolder.getView(R.id.iv_img), Constant.BASE_API + dataBean.getImg(), R.mipmap.ic_launcher);
        baseViewHolder.addOnClickListener(R.id.iv_img);
    }

    @Override
    public int getItemCount() {
        if (getData().size() < 6) {
            return getData().size();
        } else {
            return 6;
        }

    }
}