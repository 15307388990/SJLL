package com.ming.sjll.supplier.adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ming.sjll.R;
import com.ming.sjll.api.Constant;
import com.ming.sjll.base.utils.ImageHelper;
import com.ming.sjll.base.utils.TextUtil;
import com.ming.sjll.base.utils.Tools;
import com.ming.sjll.message.dialog.ChangeProjectDialog;
import com.ming.sjll.supplier.bean.ComprehenBean;

import java.util.List;


/**
 * @author luoming
 * created at 2019-10-22 17:01
 * 综合
 */
public class Comprehendapter extends BaseQuickAdapter<ComprehenBean.DataBeanX.DataBean, BaseViewHolder> {
    ChangeProjectDialog.onClickProjectListener onClickProjectListener;

    public Comprehendapter(@Nullable List<ComprehenBean.DataBeanX.DataBean> data, ChangeProjectDialog.onClickProjectListener onClickProjectListener) {
        super(R.layout.comprehend_item, data);
        this.onClickProjectListener = onClickProjectListener;
    }

    public Comprehendapter(@Nullable List<ComprehenBean.DataBeanX.DataBean> data) {
        super(R.layout.comprehend_item, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, ComprehenBean.DataBeanX.DataBean dataBean) {
        baseViewHolder.setText(R.id.tv_title, dataBean.getDemand());
        ImageHelper.displayBackground((ImageView) baseViewHolder.getView(R.id.iv_img), Constant.BASE_API + dataBean.getBackground_image(), R.drawable.ic_launcher_background);
        baseViewHolder.setText(R.id.tv_city, dataBean.getArea_name());
        baseViewHolder.setText(R.id.tv_timer, Tools.getDateformat(dataBean.getClosing_time()));
        baseViewHolder.setText(R.id.tv_pinpai, dataBean.getBrand());
        baseViewHolder.setText(R.id.tv_price, dataBean.getBudget());
        if (TextUtil.isEquals(dataBean.getTags(), "")) {
            baseViewHolder.setVisible(R.id.tv_tag, false);
        } else {
            baseViewHolder.setVisible(R.id.tv_tag, true);
            baseViewHolder.setText(R.id.tv_tag, dataBean.getTags());
        }

        baseViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickProjectListener != null) {
                    onClickProjectListener.onClickProject("", "", "");
                }
            }
        });

    }

}