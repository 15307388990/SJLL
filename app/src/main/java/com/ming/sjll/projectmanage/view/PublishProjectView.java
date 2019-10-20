package com.ming.sjll.projectmanage.view;


import android.widget.ScrollView;

import com.ming.sjll.base.view.MvpView;

public interface PublishProjectView extends MvpView {
    //scrollView滚动 ScrollView.FOCUS_DOWN
    void fullScrollTop(int f);
}
