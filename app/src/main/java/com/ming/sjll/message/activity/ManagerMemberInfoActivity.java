package com.ming.sjll.message.activity;

import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ming.sjll.R;
import com.ming.sjll.api.Constant;
import com.ming.sjll.base.activity.MvpActivity;
import com.ming.sjll.base.utils.ImageHelper;
import com.ming.sjll.base.utils.Tools;
import com.ming.sjll.base.viewmodel.ToolbarViewModel;
import com.ming.sjll.databinding.ActivityManagerInfoBinding;
import com.ming.sjll.message.dialog.ManagerMemberInfoDialog;
import com.ming.sjll.message.presenter.ManagerMemberInfoPresenter;
import com.ming.sjll.message.view.ManagerMemberView;
import com.ming.sjll.message.viewmodel.ManagerMemberInfoViewModel;
import com.yanzhenjie.recyclerview.OnItemMenuClickListener;
import com.yanzhenjie.recyclerview.SwipeMenu;
import com.yanzhenjie.recyclerview.SwipeMenuBridge;
import com.yanzhenjie.recyclerview.SwipeMenuCreator;
import com.yanzhenjie.recyclerview.SwipeMenuItem;
import com.yanzhenjie.recyclerview.SwipeRecyclerView;

import java.util.ArrayList;
import java.util.List;


public class ManagerMemberInfoActivity extends MvpActivity<ManagerMemberView, ManagerMemberInfoPresenter> implements ManagerMemberView {

    private ActivityManagerInfoBinding viewDataBinding;
    private ArrayList<ManagerMemberInfoViewModel> data;
    private MemberInfoApter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_manager_info);
        viewDataBinding.setTitleViewModel(new ToolbarViewModel("成员信息"));
        viewDataBinding.rcMember.setLayoutManager(new LinearLayoutManager(this));
        viewDataBinding.rcMember.setSwipeMenuCreator(swipeMenuCreator);
        viewDataBinding.rcMember.setOnItemMenuClickListener(mMenuItemClickListener);

        data = new ArrayList<>();
        ManagerMemberInfoViewModel memberInfoViewModel = new ManagerMemberInfoViewModel();
        memberInfoViewModel.setDate("6 天");
        memberInfoViewModel.setName("Abby Katheryn");
        memberInfoViewModel.setPosition("摄影师");
        data.add(memberInfoViewModel);
        data.add(memberInfoViewModel);
        data.add(memberInfoViewModel);
        adapter = new MemberInfoApter(data);
        viewDataBinding.rcMember.setAdapter(adapter);
        adapter.notifyDataSetChanged();


    }


    public class MemberInfoApter extends BaseQuickAdapter<ManagerMemberInfoViewModel, BaseViewHolder> {

        public MemberInfoApter(@Nullable List<ManagerMemberInfoViewModel> data) {
            super(R.layout.message_member_info_item, data);
        }

        @Override
        protected void convert(BaseViewHolder baseViewHolder, ManagerMemberInfoViewModel dataBean) {
            baseViewHolder.setText(R.id.tv_pro, dataBean.getPosition());
            baseViewHolder.setText(R.id.tv_date, dataBean.getDate());
            baseViewHolder.setText(R.id.name, dataBean.getName());
            ImageHelper.displayUser(baseViewHolder.getView(R.id.header), Constant.BASE_API + dataBean.getUrl());
        }

    }


    /**
     * 菜单创建器，在Item要创建菜单的时候调用。
     */
    private SwipeMenuCreator swipeMenuCreator = new SwipeMenuCreator() {
        @Override
        public void onCreateMenu(SwipeMenu swipeLeftMenu, SwipeMenu swipeRightMenu, int position) {
            int width = Tools.dip2px(ManagerMemberInfoActivity.this, 60);

            // 1. MATCH_PARENT 自适应高度，保持和Item一样高;
            // 2. 指定具体的高，比如80;
            // 3. WRAP_CONTENT，自身高度，不推荐;
            int height = ViewGroup.LayoutParams.MATCH_PARENT;


            // 添加右侧的，如果不添加，则右侧不会出现菜单。
            {
                SwipeMenuItem deleteItem = new SwipeMenuItem(ManagerMemberInfoActivity.this)
                        .setText("删除")
                        .setTextColor(Color.WHITE)
                        .setBackgroundColor(Color.parseColor("#FF5454"))
                        .setWidth(width)
                        .setHeight(height);
                swipeRightMenu.addMenuItem(deleteItem);// 添加菜单到右侧。

                SwipeMenuItem addItem = new SwipeMenuItem(ManagerMemberInfoActivity.this)
                        .setText("管理")
                        .setTextColor(Color.WHITE)
                        .setBackgroundColor(Color.parseColor("#0A3FFF"))
                        .setWidth(width)
                        .setHeight(height);
                swipeRightMenu.addMenuItem(addItem); // 添加菜单到右侧。
            }
        }
    };

    /**
     * RecyclerView的Item的Menu点击监听。
     */
    private OnItemMenuClickListener mMenuItemClickListener = new OnItemMenuClickListener() {
        @Override
        public void onItemClick(SwipeMenuBridge menuBridge, int position) {
            menuBridge.closeMenu();

            int direction = menuBridge.getDirection(); // 左侧还是右侧菜单。
            int menuPosition = menuBridge.getPosition(); // 菜单在RecyclerView的Item中的Position。

            if (direction == SwipeRecyclerView.RIGHT_DIRECTION) {
                if (menuPosition == 0) {//删除
                    //调用接口
                    adapter.remove(position);
                } else {//管理
                    ManagerMemberInfoDialog.newInstance(data.get(position)).show(ManagerMemberInfoActivity.this);
                }

            } else if (direction == SwipeRecyclerView.LEFT_DIRECTION) {

            }
        }
    };
}