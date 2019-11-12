package com.ming.sjll.message.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.ming.sjll.BR;

import java.util.List;

public class MessageProjectCoordinationViewModel extends BaseObservable {
    public int total;
    public int per_page;
    public int current_page;
    public int last_page;
    public List<DataEntity> data;

    public boolean isLastPage(){
        return last_page == 1;
    }

    public static class DataEntity extends BaseObservable{
        public String apply_id;//申请id
        public String project_id;//项目id
        public String user_id;//用户id
        public String occupation_id;//职业id
        public String status;//状态 0- 申请中 1-已同意 2-已拒绝 3-已过期 <num
        public String default_avatar;//用户图像
        public String name;//名称
        public String personalized;//个性签名
        public List<String> occupation;//用户职业
        public String demand;//项目需求
        public String brand;//项目品牌
        public String budget;//项目预算
        public String start_time;//项目执行开始时间
        public String end_time;//项目执行结束时间



        private boolean isExpand;//是否展开需求

        public void toggeleExpand(){
            setExpand(!isExpand());
        }

        @Bindable
        public boolean isExpand() {
            return isExpand;
        }

        public void setExpand(boolean expand) {
            isExpand = expand;
            notifyPropertyChanged(BR.expend);
        }

        @Bindable
        public String getApply_id() {
            return apply_id;
        }

        public void setApply_id(String apply_id) {
            this.apply_id = apply_id;
            notifyPropertyChanged(BR.apply_id);
        }

        @Bindable
        public String getProject_id() {
            return project_id;
        }

        public void setProject_id(String project_id) {
            this.project_id = project_id;
            notifyPropertyChanged(BR.project_id);
        }

        @Bindable
        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
            notifyPropertyChanged(BR.user_id);
        }

        @Bindable
        public String getOccupation_id() {
            return occupation_id;
        }

        public void setOccupation_id(String occupation_id) {
            this.occupation_id = occupation_id;
            notifyPropertyChanged(BR.occupation_id);
        }

        @Bindable
        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
            notifyPropertyChanged(BR.status);
        }

        @Bindable
        public String getDefault_avatar() {
            return default_avatar;
        }

        public void setDefault_avatar(String default_avatar) {
            this.default_avatar = default_avatar;
            notifyPropertyChanged(BR.default_avatar);
        }

        @Bindable
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
            notifyPropertyChanged(BR.name);
        }

        @Bindable
        public String getPersonalized() {
            return personalized;
        }

        public void setPersonalized(String personalized) {
            this.personalized = personalized;
            notifyPropertyChanged(BR.personalized);
        }

        @Bindable
        public List<String> getOccupation() {
            return occupation;
        }

        public void setOccupation(List<String> occupation) {
            this.occupation = occupation;
            notifyPropertyChanged(BR.occupation);
        }

        @Bindable
        public String getDemand() {
            return demand;
        }

        public void setDemand(String demand) {
            this.demand = demand;
            notifyPropertyChanged(BR.demand);
        }

        @Bindable
        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
            notifyPropertyChanged(BR.brand);
        }

        @Bindable
        public String getBudget() {
            return budget;
        }

        public void setBudget(String budget) {
            this.budget = budget;
            notifyPropertyChanged(BR.budget);
        }

        @Bindable
        public String getStart_time() {
            return start_time;
        }

        public void setStart_time(String start_time) {
            this.start_time = start_time;
            notifyPropertyChanged(BR.start_time);
        }

        @Bindable
        public String getEnd_time() {
            return end_time;
        }

        public void setEnd_time(String end_time) {
            this.end_time = end_time;
            notifyPropertyChanged(BR.end_time);
        }
    }
}
