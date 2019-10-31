package com.ming.sjll.base.utils;

import android.content.Context;
import android.os.CountDownTimer;
import android.widget.TextView;

public class MyCountTimer extends CountDownTimer {
    public static final int TIME_COUNT = 61000;// 时间防止从59s开始显示（以倒计时60s为例子）
    private TextView btn;
    private String endStrRid;
    private int normalColor, timingColor;// 未计时的文字颜色，计时期间的文字颜色
    private Context mContext;

    /**
     * 参数 millisInFuture 倒计时总时间（如60S，120s等） 参数 countDownInterval 渐变时间（每次倒计1s）
     * <p>
     * 参数 btn 点击的按钮(因为Button是TextView子类，为了通用我的参数设置为TextView）
     * <p>
     * 参数 endStrRid 倒计时结束后，按钮对应显示的文字
     */
    public MyCountTimer(Context context, TextView btn, String endStrRid, int normalColor, int timingColor) {
        super( TIME_COUNT, 1000 );
        this.btn = btn;
        this.endStrRid = endStrRid;
        this.mContext = context;
        this.timingColor = timingColor;
    }

    // 计时完毕时触发
    @Override
    public void onFinish() {
        if (normalColor > 0) {
            btn.setTextColor( mContext.getResources().getColor( normalColor ) );
        }
        btn.setEnabled( true );
        btn.setText( endStrRid );
    }

    // 计时过程显示
    @Override
    public void onTick(long millisUntilFinished) {
        if (timingColor > 0) {
            btn.setTextColor( mContext.getResources().getColor( timingColor ) );
        }
        btn.setEnabled( false );
        btn.setText("重新发送\n剩余" +millisUntilFinished / 1000 + "s" );
    }
}
