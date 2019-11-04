package com.ming.sjll.message.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.text.TextUtils;
import android.view.View;

import com.ming.sjll.BR;

import java.util.List;

public class ActivityUploadMessageViewModel extends BaseObservable {

    private int projectVisible = View.GONE;
    private String id;
    private String user_id;
    private String background_image;
    private String demand;
    private String brand;
    private String budget;
    private String is_scheme;
    private String provinces_id;
    private String city_id;
    private String county_id;
    private String is_local;
    private String closing_time;
    private String brief;
    private String is_determine;
    private String user_id_determine;
    private String created_time;
    private List<String> tags;
    private String showTag;
    private int showTagVisible;
    private String area_name;

    @Bindable
    public int getProjectVisible() {
        return projectVisible;
    }

    public void setProjectVisible(int projectVisible) {
        this.projectVisible = projectVisible;
        notifyPropertyChanged(com.ming.sjll.BR.projectVisible);
    }

    @Bindable
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
        notifyPropertyChanged(BR.id);
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
    public String getBackground_image() {
        return background_image;
    }

    public void setBackground_image(String background_image) {
        this.background_image = background_image;
        notifyPropertyChanged(BR.background_image);
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
        return "￥"+ budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
        notifyPropertyChanged(BR.budget);
    }

    @Bindable
    public String getIs_scheme() {
        return is_scheme;
    }

    public void setIs_scheme(String is_scheme) {
        this.is_scheme = is_scheme;
        notifyPropertyChanged(BR.is_scheme);
    }

    @Bindable
    public String getProvinces_id() {
        return provinces_id;
    }

    public void setProvinces_id(String provinces_id) {
        this.provinces_id = provinces_id;
        notifyPropertyChanged(BR.provinces_id);
    }

    @Bindable
    public String getCity_id() {
        return city_id;
    }

    public void setCity_id(String city_id) {
        this.city_id = city_id;
        notifyPropertyChanged(BR.city_id);
    }

    @Bindable
    public String getCounty_id() {
        return county_id;
    }

    public void setCounty_id(String county_id) {
        this.county_id = county_id;
        notifyPropertyChanged(BR.county_id);
    }

    @Bindable
    public String getIs_local() {
        return is_local;
    }

    public void setIs_local(String is_local) {
        this.is_local = is_local;
        notifyPropertyChanged(BR.is_local);
    }

    @Bindable
    public String getClosing_time() {
        return closing_time;
    }

    public void setClosing_time(String closing_time) {
        this.closing_time = closing_time;
        notifyPropertyChanged(BR.closing_time);
    }

    @Bindable
    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
        notifyPropertyChanged(BR.brief);
    }

    @Bindable
    public String getIs_determine() {
        return is_determine;
    }

    public void setIs_determine(String is_determine) {
        this.is_determine = is_determine;
        notifyPropertyChanged(BR.is_determine);
    }

    @Bindable
    public String getUser_id_determine() {
        return user_id_determine;
    }

    public void setUser_id_determine(String user_id_determine) {
        this.user_id_determine = user_id_determine;
        notifyPropertyChanged(BR.user_id_determine);
    }

    @Bindable
    public String getCreated_time() {
        return created_time;
    }

    public void setCreated_time(String created_time) {
        this.created_time = created_time;
        notifyPropertyChanged(BR.created_time);
    }



    @Bindable
    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
        notifyPropertyChanged(BR.tags);
    }



    @Bindable
    public String getShowTag() {
        if (tags == null || tags.isEmpty()){
            return "";
        }
        showTag = tags.get(0);

        return showTag;
    }

    public void setShowTag(String showTag) {
        this.showTag = showTag;
        notifyPropertyChanged(BR.showTag);
    }

    @Bindable
    public int getShowTagVisible() {
        if (TextUtils.isEmpty(getShowTag())){
            showTagVisible =  View.GONE;
        }else {
            showTagVisible = View.VISIBLE;
        }
        return showTagVisible;
    }

    public void setShowTagVisible(int showTagVisible) {
        this.showTagVisible = showTagVisible;
        notifyPropertyChanged(BR.showTagVisible);
    }

    @Bindable
    public String getArea_name() {
        return area_name;
    }

    public void setArea_name(String area_name) {
        this.area_name = area_name;
        notifyPropertyChanged(BR.area_name);
    }
}
