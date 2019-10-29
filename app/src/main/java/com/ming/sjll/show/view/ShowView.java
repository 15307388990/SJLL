package com.ming.sjll.show.view;


import com.ming.sjll.base.bean.BaseBean;
import com.ming.sjll.base.view.MvpView;
import com.ming.sjll.show.bean.ShowWorkBean;

public interface ShowView extends MvpView {
    void ShowWork(ShowWorkBean bean);

    void workCollect(BaseBean bean);
}
