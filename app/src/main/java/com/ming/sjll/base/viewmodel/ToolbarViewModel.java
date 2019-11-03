package com.ming.sjll.base.viewmodel;

import android.app.Activity;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.view.View;

public class ToolbarViewModel  extends BaseObservable {
    private String title;

    public ToolbarViewModel() {
    }
  public ToolbarViewModel(String title) {
        this.title = title;
    }

    @Bindable
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(com.ming.sjll.BR.title);
    }

    public void onClickLeft(View view){
        if (view.getContext() instanceof Activity){
            ((Activity) view.getContext()).finish();
        }
    }
}
