package com.ming.sjll.message.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.view.View;

import com.ming.sjll.BR;

import java.util.ArrayList;
import java.util.List;

public class MessageChatViewModel extends BaseObservable {

    private int projectVisible = View.GONE;
    private ProjectChatViewModel projectChatViewModel = new ProjectChatViewModel();

    private int groupInfoVisible = View.GONE;
    private List<String> memberInfos = new ArrayList<>();

    @Bindable
    public int getProjectVisible() {
        return projectVisible;
    }

    public void setProjectVisible(int projectVisible) {
        this.projectVisible = projectVisible;
        notifyPropertyChanged(BR.projectVisible);
    }

    @Bindable
    public ProjectChatViewModel getProjectChatViewModel() {
        return projectChatViewModel;
    }

    public void setProjectChatViewModel(ProjectChatViewModel projectChatViewModel) {
        this.projectChatViewModel = projectChatViewModel;
        notifyPropertyChanged(BR.projectChatViewModel);
    }

    @Bindable
    public int getGroupInfoVisible() {
        return groupInfoVisible;
    }

    public void setGroupInfoVisible(int groupInfoVisible) {
        this.groupInfoVisible = groupInfoVisible;
        notifyPropertyChanged(BR.groupInfoVisible);
    }

    @Bindable
    public List<String> getMemberInfos() {
        return memberInfos;
    }

    public void setMemberInfos(List<String> memberInfos) {
        this.memberInfos = memberInfos;
        notifyPropertyChanged(BR.memberInfos);
    }
}
