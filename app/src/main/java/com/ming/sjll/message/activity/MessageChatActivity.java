package com.ming.sjll.message.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;

import com.ming.sjll.R;
import com.ming.sjll.base.activity.MvpActivity;
import com.ming.sjll.base.utils.Tools;
import com.ming.sjll.base.viewmodel.ToolbarViewModel;
import com.ming.sjll.databinding.ActivityMessageChatBinding;
import com.ming.sjll.message.dialog.ChangeProjectDialog;
import com.ming.sjll.message.dialog.InviteMemberShareDialog;
import com.ming.sjll.message.dialog.ReceivedConfirmDialog;
import com.ming.sjll.message.fragment.MessageConversationFragment;
import com.ming.sjll.message.presenter.MessageChatPresenter;
import com.ming.sjll.message.presenter.UploadPdfMessagePresenter;
import com.ming.sjll.message.utils.RongIMUtils;
import com.ming.sjll.message.view.MessageChatView;
import com.ming.sjll.message.viewmodel.MessageChatViewModel;
import com.ming.sjll.message.viewmodel.ProjectChatViewModel;
import com.ming.sjll.my.activity.ComplainActivity;

import java.util.Locale;

import io.rong.imkit.fragment.ConversationFragment;
import io.rong.imlib.model.Conversation;


public class MessageChatActivity extends MvpActivity<MessageChatView, MessageChatPresenter> implements MessageChatView {

    private ActivityMessageChatBinding viewDataBinding;
    private MessageChatViewModel messageChatViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_message_chat);
        messageChatViewModel = new MessageChatViewModel();
        viewDataBinding.setViewModel(messageChatViewModel);

        try {
            Intent intent = getIntent();
            Uri dataUri = intent.getData();
            if (dataUri != null) {
                String mtargetId = dataUri.getQueryParameter("targetId");
                String title = dataUri.getQueryParameter("title");
                String path = dataUri.getPath();

                if (TextUtils.equals(Conversation.ConversationType.PRIVATE.getName().toLowerCase(Locale.US), path)) {
                    messageChatViewModel.setGroupInfoVisible(View.GONE);
                    messageChatViewModel.setProjectVisible(View.GONE);
                } else if (TextUtils.equals(Conversation.ConversationType.GROUP.getName().toLowerCase(Locale.US), path)) {
                    messageChatViewModel.setGroupInfoVisible(View.VISIBLE);
                    messageChatViewModel.setProjectVisible(View.GONE);
                }

                //设置标题
                viewDataBinding.setTitleViewModel(new ToolbarViewModel(title));

                ConversationFragment conversationListFragment = createConversationFragment(mtargetId);
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.container, conversationListFragment)
                        .commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ConversationFragment createConversationFragment(String mtargetId) {
        ConversationFragment fragement = new MessageConversationFragment();
        try {
            Conversation.ConversationType mConversationType = Conversation.ConversationType.APP_PUBLIC_SERVICE;
            Uri uri = Uri.parse("rong://" + getApplicationInfo().packageName).buildUpon()
                    .appendPath("conversation").appendPath(mConversationType.getName().toLowerCase())
                    .appendQueryParameter("targetId", mtargetId).build();
            fragement.setUri(uri);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fragement;

    }

    @Override
    public void onShowData(ProjectChatViewModel viewModel) {
        messageChatViewModel.setProjectVisible(View.VISIBLE);
        messageChatViewModel.setProjectChatViewModel(viewModel);
        viewDataBinding.setViewModel(messageChatViewModel);
    }


    @Override
    public void uploadPdf() {
        Bundle bundle = new Bundle();
        bundle.putString(UploadPdfMessagePresenter.PROJECT_ID, "");
        Tools.jump(this, UploadPdfMessageActivity.class, bundle, false);
    }

    @Override
    public void confirmCooperation() {
        if (mPresenter.hasProject()) {
            confirmCooperationDialog();
        } else { //如果当前没有项目id，弹框选择项目，然后再弹框
            changeProject();
        }
    }

    private void confirmCooperationDialog() {
        String projectName;
        String projectId;
        String userName;
        //如果当前项目id，就弹框
        ReceivedConfirmDialog.newInstance(mPresenter.getConfirmCooperationContent()).setConfirmListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //发送合作信息,自定义消息
                RongIMUtils.INSTANCE.sendCooperation();

            }
        }).show(this);
    }

    @Override
    public void changeProject() {
        ChangeProjectDialog.newInstance().setOnClickProjectListener(new ChangeProjectDialog.onClickProjectListener() {
            @Override
            public void onClickProject(String type, String projectId, String projectName) {
                //弹框
                if (mPresenter != null) {
                    mPresenter.changeProject(projectId);
                }
                confirmCooperationDialog();
            }
        }).show(this);
    }

    @Override
    public void complain() {
        //跳转到投诉页面
        Bundle bundle = new Bundle();
        Tools.jump(this, ComplainActivity.class, bundle, false);
    }

    @Override
    public void onAddMemberInfo() {
        InviteMemberShareDialog.newInstance().show(this);
    }


}
