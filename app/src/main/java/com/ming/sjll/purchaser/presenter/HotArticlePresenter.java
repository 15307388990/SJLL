package com.ming.sjll.purchaser.presenter;

import com.ming.sjll.api.ApiService;
import com.ming.sjll.base.exp.RetrofitManager;
import com.ming.sjll.base.http.ApiObserver;
import com.ming.sjll.base.presenter.MvpPresenter;
import com.ming.sjll.purchaser.bean.AreaBean;
import com.ming.sjll.purchaser.view.CityView;
import com.ming.sjll.purchaser.view.HotArticleView;
import com.ming.sjll.supplier.bean.HotArticleBean;

public class HotArticlePresenter extends MvpPresenter<HotArticleView> {
    public void getHotArticle() {

        getNetData(RetrofitManager.get().create(ApiService.class).getHotArticle(),
                new ApiObserver<HotArticleBean>() {
                    @Override
                    public void onSuccess(HotArticleBean bean) {
                        getView().setHotArticle(bean);
                    }

                    @Override
                    public void onFailure(int code, String msg) {
                        getView().showError(msg);
                    }
                });
    }


}
