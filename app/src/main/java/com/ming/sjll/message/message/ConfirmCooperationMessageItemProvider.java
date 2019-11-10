package com.ming.sjll.message.message;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ming.sjll.R;

import org.jetbrains.annotations.NotNull;

import io.rong.imkit.model.ProviderTag;
import io.rong.imkit.model.UIMessage;
import io.rong.imkit.widget.provider.IContainerItemProvider;
import io.rong.imlib.model.Message;

@ProviderTag(messageContent = ConfirmCooperationMessageContent.class)
public class ConfirmCooperationMessageItemProvider extends IContainerItemProvider.MessageProvider<ConfirmCooperationMessageContent> {

    class ViewHolder {
        RelativeLayout message;
        TextView tv_apply;
        TextView tv_status;
    }

    @Override
    public View newView(Context context, ViewGroup group) {
        View view = LayoutInflater.from(context).inflate(R.layout.message_custom_confirm_cooperation, null);
        ViewHolder holder = new ViewHolder();
        holder.message = view.findViewById(R.id.message);
        holder.tv_apply = view.findViewById(R.id.tv_apply);
        holder.tv_status = view.findViewById(R.id.tv_status);
        view.setTag(holder);
        return view;
    }

    @Override
    public void bindView(View v, int position, ConfirmCooperationMessageContent content, UIMessage message) {
        ViewHolder holder = (ViewHolder) v.getTag();

        if (message.getMessageDirection() == Message.MessageDirection.SEND) {//消息方向，自己发送的
            holder.message.setBackgroundResource(R.drawable.message_custom_bg_right);
        } else {
            holder.message.setBackgroundResource(R.drawable.message_custom_bg_left);
        }
        ImageSpan span = getImageSpan(v);
        SpannableString spannable = new SpannableString(content.getDemand() + " ");
        spannable.setSpan(span, content.getDemand().length(), content.getDemand().length() + " ".length(), Spannable.SPAN_INCLUSIVE_EXCLUSIVE);

        holder.tv_apply.setText(spannable);
        holder.tv_status.setText(content.statusStr());

    }

    @NotNull
    private ImageSpan getImageSpan(View v) {
        Drawable drawable = v.getResources().getDrawable(R.mipmap.ic_arrow_h);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        return new ImageSpan(drawable, ImageSpan.ALIGN_BASELINE);
    }


    @Override
    public Spannable getContentSummary(ConfirmCooperationMessageContent data) {
        if (data.isReceived()) {
            return new SpannableString("[确认合作]");
        } else {
            return new SpannableString("[拒绝合作]");
        }
    }

    @Override
    public void onItemClick(View view, int i, ConfirmCooperationMessageContent pdfMessageContent, UIMessage uiMessage) {

    }


}
