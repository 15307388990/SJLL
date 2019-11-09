package com.ming.sjll.message.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.os.Parcel;
import android.os.Parcelable;

import com.ming.sjll.BR;

public class ManagerMemberInfoViewModel extends BaseObservable implements Parcelable {
 private String url;
 private String name;
 private String position;
 private String date;

    @Bindable
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
        notifyPropertyChanged(BR.url);
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
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
        notifyPropertyChanged(BR.position);
    }

    @Bindable
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
        notifyPropertyChanged(BR.date);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.url);
        dest.writeString(this.name);
        dest.writeString(this.position);
        dest.writeString(this.date);
    }

    public ManagerMemberInfoViewModel() {
    }

    protected ManagerMemberInfoViewModel(Parcel in) {
        this.url = in.readString();
        this.name = in.readString();
        this.position = in.readString();
        this.date = in.readString();
    }

    public static final Parcelable.Creator<ManagerMemberInfoViewModel> CREATOR = new Parcelable.Creator<ManagerMemberInfoViewModel>() {
        @Override
        public ManagerMemberInfoViewModel createFromParcel(Parcel source) {
            return new ManagerMemberInfoViewModel(source);
        }

        @Override
        public ManagerMemberInfoViewModel[] newArray(int size) {
            return new ManagerMemberInfoViewModel[size];
        }
    };
}
