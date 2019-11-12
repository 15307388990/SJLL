package com.ming.sjll.my.view;


import com.ming.sjll.base.view.MvpView;
import com.ming.sjll.my.bean.AdsBean;
import com.ming.sjll.my.bean.CurriculumBean;

public interface AdsView extends MvpView {
    void ShowData(AdsBean pBean);

}
