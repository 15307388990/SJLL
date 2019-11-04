package com.ming.sjll.message.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.ming.sjll.BR;

public class MessageNotifyViewModel extends BaseObservable {
    private String count;
    private String content;
    private String url;

    @Bindable
    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
        notifyPropertyChanged(com.ming.sjll.BR.count);
    }

    @Bindable
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        notifyPropertyChanged(BR.content);
    }

    @Bindable
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
        notifyPropertyChanged(BR.url);
    }
}
