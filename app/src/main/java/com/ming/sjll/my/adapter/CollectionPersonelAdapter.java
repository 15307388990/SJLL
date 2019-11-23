package com.ming.sjll.my.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jet.flowtaglayout.FlowTagLayout;
import com.ming.sjll.R;
import com.ming.sjll.api.Constant;
import com.ming.sjll.base.utils.ImageHelper;
import com.ming.sjll.my.bean.ColletionPersenterBean;
import com.ming.sjll.my.bean.HomePageBean;

import java.util.List;


/**
 * @author luoming
 * created at 2019-10-22 17:01
 * 收藏 人员
 */
public class CollectionPersonelAdapter extends BaseQuickAdapter<ColletionPersenterBean.DataBeanX.DataBean, BaseViewHolder> {

    public CollectionPersonelAdapter(@Nullable List<ColletionPersenterBean.DataBeanX.DataBean> data) {
        super(R.layout.collection_personnel_item, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, ColletionPersenterBean.DataBeanX.DataBean dataBean) {
        ImageHelper.displayBackground((ImageView) baseViewHolder.getView(R.id.iv_img), Constant.BASE_API + dataBean.getCover_img(), R.drawable.ic_launcher_background);
        baseViewHolder.setText(R.id.tv_title, dataBean.getName());
        baseViewHolder.setText(R.id.tv_wage, dataBean.getPayment());
        FlowTagLayout flowTagLayout = baseViewHolder.getView(R.id.flowTagLayout);
        flowTagLayout.addTags(dataBean.getTags());
        StringBuffer stringBuffer = new StringBuffer();
        for (String string : dataBean.getOccupation()) {
            stringBuffer.append(string + ".");
        }
        baseViewHolder.setText(R.id.tv_professional, stringBuffer);


    }

}