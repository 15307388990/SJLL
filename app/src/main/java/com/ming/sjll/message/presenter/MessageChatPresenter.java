package com.ming.sjll.message.presenter;

import android.text.TextUtils;

import com.ming.sjll.api.ApiService;
import com.ming.sjll.base.exp.RetrofitManager;
import com.ming.sjll.base.http.ApiObserver;
import com.ming.sjll.base.presenter.MvpPresenter;
import com.ming.sjll.message.view.MessageChatView;
import com.ming.sjll.message.viewmodel.ProjectChatViewModel;

public class MessageChatPresenter extends MvpPresenter<MessageChatView> {

    public static final String PROJECT_ID = "project_id";
    private String projectId;

    @Override
    protected void onViewAttached() {
        super.onViewAttached();

        projectId = getBundle().getString(PROJECT_ID);

        //根据项目id获取项目数据，然后进行展示
        updateProject();
    }

    public void updateProject(){
        getNetData(RetrofitManager.get().create(ApiService.class).getProjectInfo(getToken(), projectId),
                new ApiObserver<ProjectChatViewModel>() {
                    @Override
                    public void onSuccess(ProjectChatViewModel bean) {
                        getView().onShowData(bean);
                    }

                    @Override
                    public void onFailure(int code, String msg) {
                        getView().showError(msg);
                    }
                });
    }

    public void changeProject(String projectId){
        this.projectId = projectId;
        updateProject();
    }


    public boolean hasProject(){
        return TextUtils.isEmpty(projectId);
    }

    public String getConfirmCooperationContent(){
        String cooperationName = "";
        String projectName = "";
        return "你是否确定跟 "+cooperationName+" 合作 "+projectName+" 新品拍摄吗？";
    }


    public void onClickGroupMemberInfo(){

    }
    public void onClickAddMemberInfo(){
        //弹框
        getView().onAddMemberInfo();

    }

    public void onClickProjectManager(){

    }

    public void onClickProjectProgress(){

    }
}
