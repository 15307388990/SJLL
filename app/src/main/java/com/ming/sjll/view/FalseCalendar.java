package com.ming.sjll.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.necer.calendar.MonthCalendar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class FalseCalendar extends MonthCalendar {

    public FalseCalendar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return false;
    }

    @Override
    public boolean canScrollHorizontally(int direction) {
        return false;
    }

}
