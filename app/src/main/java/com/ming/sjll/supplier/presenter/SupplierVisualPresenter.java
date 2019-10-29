package com.ming.sjll.supplier.presenter;

import com.ming.sjll.api.ApiService;
import com.ming.sjll.base.exp.RetrofitManager;
import com.ming.sjll.base.http.ApiObserver;
import com.ming.sjll.base.presenter.MvpPresenter;
import com.ming.sjll.purchaser.view.PurchaserVisualView;
import com.ming.sjll.supplier.bean.ArticleListBean;
import com.ming.sjll.supplier.bean.TopArticleBean;
import com.ming.sjll.supplier.view.SupplierVisualView;

public class SupplierVisualPresenter extends MvpPresenter<SupplierVisualView> {
    public void showDate() {
        getNetData(RetrofitManager.get().create(ApiService.class).getArticleList(),
                new ApiObserver<ArticleListBean>() {
                    @Override
                    public void onSuccess(ArticleListBean bean) {
                        getView().setArticleList(bean);
                    }

                    @Override
                    public void onFailure(int code, String msg) {
                        getView().showError(msg);
                    }
                });

    }

    //获取置顶文章
    public void getTopArtic() {
        getNetData(RetrofitManager.get().create(ApiService.class).getTopArtic(),
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
}