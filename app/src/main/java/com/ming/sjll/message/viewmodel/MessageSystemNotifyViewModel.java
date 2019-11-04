package com.ming.sjll.message.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.ming.sjll.BR;

public class MessageSystemNotifyViewModel extends BaseObservable {
    private String time;
    private String content;

    @Bindable
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
        notifyPropertyChanged(BR.time);
    }

    @Bindable
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        notifyPropertyChanged(BR.content);
    }
}
