package com.ming.sjll.message.viewmodel;

import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MessageChatViewModel {

    private int projectVisible = View.GONE;
    private ProjectChatViewModel projectChatViewModel = new ProjectChatViewModel();

    private int groupInfoVisible = View.GONE;
    private List<String> memberInfos = new ArrayList<>();

    public int getProjectVisible() {
        return projectVisible;
    }

    public void setProjectVisible(int projectVisible) {
        this.projectVisible = projectVisible;
    }

    public ProjectChatViewModel getProjectChatViewModel() {
        return projectChatViewModel;
    }

    public void setProjectChatViewModel(ProjectChatViewModel projectChatViewModel) {
        this.projectChatViewModel = projectChatViewModel;
    }

    public int getGroupInfoVisible() {
        return groupInfoVisible;
    }

    public void setGroupInfoVisible(int groupInfoVisible) {
        this.groupInfoVisible = groupInfoVisible;
    }

    public List<String> getMemberInfos() {
        return memberInfos;
    }

    public void setMemberInfos(List<String> memberInfos) {
        this.memberInfos = memberInfos;
    }
}
