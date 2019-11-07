package com.ming.sjll.my.view;


import com.ming.sjll.base.bean.BaseBean;
import com.ming.sjll.base.view.MvpView;
import com.ming.sjll.my.bean.PersonalDateBean;

public interface HomeageDataView extends MvpView {
    void ShowData(PersonalDateBean pBean);
    void workCollect(BaseBean bean);
}
