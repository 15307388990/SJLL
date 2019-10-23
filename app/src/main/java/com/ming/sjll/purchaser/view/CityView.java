package com.ming.sjll.purchaser.view;


import com.ming.sjll.base.view.MvpView;
import com.ming.sjll.purchaser.bean.AreaBean;

public interface CityView extends MvpView {
    //设置省列表
   void setProvince(AreaBean areaBean);
   //设置市列表
    void  setCity(AreaBean areaBean);
    //设置区列表
    void  setArea(AreaBean areaBean);
}
