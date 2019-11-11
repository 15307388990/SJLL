package com.ming.sjll.purchaser.adapter;

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
import com.ming.sjll.purchaser.bean.ProjectManagementBean;
import com.ming.sjll.supplier.bean.ComprehenBean;

import java.util.List;


/**
 * @author luoming
 * created at 2019-10-22 17:01
 * 项目列表
 */
public class ProjectListAdapter extends BaseQuickAdapter<ProjectManagementBean.DataBeanX.DataBean.ListBean, BaseViewHolder> {
    ChangeProjectDialog.onClickProjectListener onClickProjectListener;

    public ProjectListAdapter(@Nullable List<ProjectManagementBean.DataBeanX.DataBean.ListBean> data, ChangeProjectDialog.onClickProjectListener onClickProjectListener) {
        super(R.layout.comprehend_item, data);
        this.onClickProjectListener = onClickProjectListener;
    }

    public ProjectListAdapter(@Nullable List<ProjectManagementBean.DataBeanX.DataBean.ListBean> data) {
        super(R.layout.comprehend_item, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, ProjectManagementBean.DataBeanX.DataBean.ListBean dataBean) {
        baseViewHolder.setText(R.id.tv_title, dataBean.getDemand());
        ImageHelper.displayBackground((ImageView) baseViewHolder.getView(R.id.iv_img), Constant.BASE_API + dataBean.getBackground_image(), R.drawable.ic_launcher_background);
        baseViewHolder.setText(R.id.tv_city, dataBean.getArea_name());
        baseViewHolder.setText(R.id.tv_timer, Tools.getDateformat(dataBean.getClosing_time()));
        baseViewHolder.setText(R.id.tv_pinpai, dataBean.getBrand());
        baseViewHolder.setText(R.id.tv_price, dataBean.getBudget());
        // if (TextUtil.isEquals(dataBean.getTags(), "")) {
        baseViewHolder.setVisible(R.id.tv_tag, false);
//        } else {
//            baseViewHolder.setVisible(R.id.tv_tag, true);
//            baseViewHolder.setText(R.id.tv_tag, dataBean.getTags());
//        }

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