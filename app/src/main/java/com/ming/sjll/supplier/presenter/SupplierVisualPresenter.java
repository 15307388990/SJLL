package com.ming.sjll.supplier.presenter;

import com.ming.sjll.api.ApiService;
import com.ming.sjll.base.exp.RetrofitManager;
import com.ming.sjll.base.http.ApiObserver;
import com.ming.sjll.base.presenter.MvpPresenter;
import com.ming.sjll.my.bean.ColumnListBean;
import com.ming.sjll.purchaser.bean.OccupationBean;
import com.ming.sjll.purchaser.view.PurchaserVisualView;
import com.ming.sjll.supplier.bean.ArticleListBean;
import com.ming.sjll.supplier.bean.TopArticleBean;
import com.ming.sjll.supplier.view.SupplierVisualView;

public class SupplierVisualPresenter extends MvpPresenter<SupplierVisualView> {
    @Override
    public void attachView(SupplierVisualView view) {
        super.attachView(view);
        showDate();
    }

    public void showDate() {
        getNetData(RetrofitManager.get().create(ApiService.class).columnList(getToken()),
                new ApiObserver<ColumnListBean>() {
                    @Override
                    public void onSuccess(ColumnListBean bean) {
                        getView().setColumnList(bean);
                    }

                    @Override
                    public void onFailure(int code, String msg) {
                        getView().showError(msg);
                    }
                });

    }

    //获取置顶文章
    public void getTopArtic() {
        getNetData(RetrofitManager.get().create(ApiService.class).getTopArtic("1"),
                new ApiObserver<TopArticleBean>() {
                    @Override
                    public void onSuccess(TopArticleBean bean) {
                        getView().setTopArticle(bean);
                    }

                    @Override
                    public void onFailure(int code, String msg) {
                        getView().showError(msg);
                    }
                });
    }
    //获取专栏职业
    public void getspOccupation() {
        getNetData(RetrofitManager.get().create(ApiService.class).getspOccupation(getToken()),
                new ApiObserver<OccupationBean>() {
                    @Override
                    public void onSuccess(OccupationBean bean) {
                        getView().getspOccupation(bean);
                    }

                    @Override
                    public void onFailure(int code, String msg) {
                        getView().showError(msg);
                    }
                });
    }
}
