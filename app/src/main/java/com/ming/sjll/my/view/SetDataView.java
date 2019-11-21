package com.ming.sjll.my.view;


import com.ming.sjll.base.bean.BaseBean;
import com.ming.sjll.base.view.MvpView;
import com.ming.sjll.my.bean.HomePageBean;
import com.ming.sjll.my.bean.VersionBean;

import okhttp3.internal.Version;

public interface SetDataView extends MvpView {
    void ShowData(VersionBean pBean);
}
