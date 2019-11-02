package com.ming.sjll.my.view;


import com.ming.sjll.base.view.MvpView;
import com.ming.sjll.my.bean.CompanyBean;
import com.ming.sjll.my.bean.PersonalDateBean;

public interface PersonalDataView extends MvpView {
    void ShowData(PersonalDateBean pBean);
}
