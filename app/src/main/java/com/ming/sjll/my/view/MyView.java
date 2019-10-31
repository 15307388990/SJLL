package com.ming.sjll.my.view;


import com.ming.sjll.base.view.MvpView;
import com.ming.sjll.my.bean.CompanyBean;

public interface MyView extends MvpView {
    void ShowData(CompanyBean companyBean);
}
