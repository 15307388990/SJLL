package com.ming.sjll.message.presenter;

import com.ming.sjll.api.ApiService;
import com.ming.sjll.base.exp.RetrofitManager;
import com.ming.sjll.base.http.ApiObserver;
import com.ming.sjll.base.presenter.MvpPresenter;
import com.ming.sjll.message.fragment.ProjectListFragment;
import com.ming.sjll.supplier.bean.ComprehenBean;
import com.ming.sjll.supplier.view.ComprehensiveView;

public class ProjectListPresenter extends MvpPresenter<ComprehensiveView> {

    @Override
    protected void onViewAttached() {
        super.onViewAttached();
        getProjectList();
    }

    public void getProjectList() {
        String type = getBundle().getString(ProjectListFragment.TYPE);
        //0 我发起的 1 我接单的 2 项目合伙
        String occupation_id = "0";
        getNetData(RetrofitManager.get().create(ApiService.class).getNotice(getToken(),occupation_id),
                new ApiObserver<ComprehenBean>() {
                    @Override
                    public void onSuccess(ComprehenBean bean) {
                        getView().setProjectIntegrated(bean);
                    }
                    @Override
                    public void onFailure(int code, String msg) {
                        getView().showError(msg);
                    }
                });

    }

}
