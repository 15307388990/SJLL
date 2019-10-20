package com.ming.sjll.base.fragment;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.ming.sjll.R;
import com.ming.sjll.base.widget.TitleBar;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public class BaseFragment extends BaseV4Fragment{


    private LinearLayout mViewContainer;
    private Unbinder mUnbinder;
    public TitleBar mTitleBar;


    public void setContentView(int layoutId, String title) {
        setContentViews(layoutId,title);
    }


    public void setContentView(int layoutId) {
        setContentViews(layoutId,"");
    }

    private void setContentViews(int layoutId, String title){

        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        LinearLayout parentView = (LinearLayout) inflater.inflate(layoutId, null);


        super.setContentView(parentView);

//        mViewContainer=(LinearLayout)parentView.findViewById(R.id.ll_container);
//        mTitleBar = (TitleBar) parentView.findViewById(R.id.titleBar);
//        if (!TextUtils.isEmpty(title)){
//            mTitleBar.setVisibility(View.VISIBLE);
//            mTitleBar.setTitle(title);
//        }else{
//            mTitleBar.setVisibility(View.GONE);
//        }
//
//        View childView = inflater.inflate(layoutId, null);
//        mViewContainer.addView(childView);
        mUnbinder = ButterKnife.bind(this, parentView);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mUnbinder!=null){
            mUnbinder.unbind();
        }
    }





}
