package com.ming.sjll.supplier.view;


import com.ming.sjll.base.view.MvpView;
import com.ming.sjll.supplier.bean.ComprehenBean;
import com.ming.sjll.supplier.bean.MaybeLikBean;
import com.ming.sjll.supplier.bean.TalentPushBean;

public interface TalentView extends MvpView {
    void talentPush(TalentPushBean bean);

    void maybeLike(MaybeLikBean bean);

}
