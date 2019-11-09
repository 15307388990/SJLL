package com.ming.sjll.message.extend;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;

import com.ming.sjll.R;
import com.ming.sjll.message.view.MessageChatView;

import io.rong.imkit.RongExtension;
import io.rong.imkit.plugin.IPluginModule;

public class ComplaintPlugin implements IPluginModule {
    @Override
    public Drawable obtainDrawable(Context context) {
        return ContextCompat.getDrawable(context,R.mipmap.plugin_comlaint);
    }

    @Override
    public String obtainTitle(Context context) {
        return "投诉";
    }

    @Override
    public void onClick(Fragment fragment, RongExtension rongExtension) {
        if (fragment.getActivity() instanceof MessageChatView){
            ((MessageChatView) fragment.getActivity()).complain();
        }
    }

    @Override
    public void onActivityResult(int i, int i1, Intent intent) {

    }
}
