package com.ming.sjll.show.fragment;

import android.os.Bundle;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.ming.sjll.R;
import com.ming.sjll.base.bean.BaseBean;
import com.ming.sjll.base.fragment.MvpFragment;
import com.ming.sjll.base.widget.ToastShow;
import com.ming.sjll.show.adapter.ShowAdapter;
import com.ming.sjll.show.bean.ShowWorkBean;
import com.ming.sjll.show.presenter.ShowPresenter;
import com.ming.sjll.show.view.ShowView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import me.yuqirong.cardswipelayout.CardItemTouchHelperCallback;
import me.yuqirong.cardswipelayout.CardLayoutManager;
import me.yuqirong.cardswipelayout.OnSwipeListener;


public class ShowFragemt extends MvpFragment<ShowView, ShowPresenter> implements ShowView {


    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;

    private ShowAdapter mAdapter;
    private ShowWorkBean showWorkBean;
    private int index;

    public static ShowFragemt newInstance() {
        return new ShowFragemt();
    }

    @Override
    protected void onCreateView(Bundle savedInstanceState) {
        super.onCreateView(savedInstanceState);
        setContentView(R.layout.fragemt_show);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.showDate();
    }

    @Override
    protected ShowPresenter createPresenter() {
        return new ShowPresenter();
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
    public void ShowWork(ShowWorkBean bean) {
        showWorkBean = bean;
        mAdapter = new ShowAdapter(bean.getData());

        mAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                if (view.getId() == R.id.iv_like) {
                    index = position;
                    mPresenter.workCollect(showWorkBean.getData().get(position).getWork_id());
                }
            }
        });


        recyclerview.setAdapter(mAdapter);
        CardItemTouchHelperCallback cardCallback = new CardItemTouchHelperCallback(recyclerview.getAdapter(), bean.getData());
        ItemTouchHelper touchHelper = new ItemTouchHelper(cardCallback);
        CardLayoutManager cardLayoutManager = new CardLayoutManager(recyclerview, touchHelper);
        recyclerview.setLayoutManager(cardLayoutManager);
        touchHelper.attachToRecyclerView(recyclerview);
        cardCallback.setOnSwipedListener(new OnSwipeListener() {
            @Override
            public void onSwiping(RecyclerView.ViewHolder viewHolder, float v, int i) {

            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, Object o, int i) {

            }

            @Override
            public void onSwipedClear() {

            }
        });

    }

    @Override
    public void workCollect(BaseBean bean) {
        showWorkBean.getData().get(index).setIs_like(1);
        if (mAdapter != null) {
            mAdapter.setData(index, showWorkBean.getData().get(index));
        }

    }
}
