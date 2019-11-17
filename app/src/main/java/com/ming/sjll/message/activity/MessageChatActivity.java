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
import com.ming.sjll.message.message.CooperationApplyMessageContent;
import com.ming.sjll.message.message.CooperationMessageContent;
import com.ming.sjll.message.message.ShareUserMessageContent;
import com.ming.sjll.message.message.ShareWorkMessageContent;
import com.ming.sjll.message.presenter.MessageChatPresenter;
import com.ming.sjll.message.presenter.UploadPdfMessagePresenter;
import com.ming.sjll.message.utils.RongIMUtils;
import com.ming.sjll.message.view.MessageChatView;
import com.ming.sjll.message.viewmodel.MessageChatViewModel;
import com.ming.sjll.message.viewmodel.ProjectChatViewModel;
import com.ming.sjll.my.activity.ComplainActivity;

import java.util.Locale;

import io.rong.common.RLog;
import io.rong.imkit.RongIM;
import io.rong.imkit.fragment.ConversationFragment;
import io.rong.imlib.IRongCallback;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.Message;
import io.rong.message.FileMessage;


public class MessageChatActivity extends MvpActivity<MessageChatView, MessageChatPresenter> implements MessageChatView {

    private ActivityMessageChatBinding viewDataBinding;
    private MessageChatViewModel messageChatViewModel;
    private Conversation.ConversationType conversationType;
    private String targetId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_message_chat);
        messageChatViewModel = new MessageChatViewModel();
        viewDataBinding.setViewModel(messageChatViewModel);

        try {
            Intent intent = getIntent();
            Uri dataUri = intent.getData();
            String title;
            String path;
            if (dataUri != null) {
                targetId = dataUri.getQueryParameter("targetId");
                title = dataUri.getQueryParameter("title");
                path = dataUri.getPath();

                //页面离开的时候缓存当前的用户和标题，为了给上传pdf使用，因为pdf是从微信里面进行应用选择打开的，这里接收的时候是在mainActivity进行接收
                mSavePreferencesData.putStringData("targetId", targetId);
                mSavePreferencesData.putStringData("title", title);
                mSavePreferencesData.putStringData("path", path);
            } else {
                targetId = mSavePreferencesData.getStringData("targetId");
                title = mSavePreferencesData.getStringData("title");
                path = mSavePreferencesData.getStringData("path");

                //发送pdf信息
                boolean fromWechat = intent.getBooleanExtra("fromWechat", false);
                if (fromWechat){
                    sendPdfMessage(dataUri);
                }
            }


            if (dataUri != null) {

                conversationType = Conversation.ConversationType.valueOf(path);
                if (TextUtils.equals(Conversation.ConversationType.PRIVATE.getName().toLowerCase(Locale.US), path)) {
                    messageChatViewModel.setGroupInfoVisible(View.GONE);
                    messageChatViewModel.setProjectVisible(View.GONE);
                } else if (TextUtils.equals(Conversation.ConversationType.GROUP.getName().toLowerCase(Locale.US), path)) {
                    messageChatViewModel.setGroupInfoVisible(View.VISIBLE);
                    messageChatViewModel.setProjectVisible(View.GONE);
                }

                //设置标题
                viewDataBinding.setTitleViewModel(new ToolbarViewModel(title));

                ConversationFragment conversationListFragment = createConversationFragment(targetId);
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.container, conversationListFragment)
                        .commitAllowingStateLoss();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ConversationFragment createConversationFragment(String mtargetId) {
        ConversationFragment fragement = new MessageConversationFragment();
        try {
            Uri uri = Uri.parse("rong://" + getApplicationInfo().packageName).buildUpon()
                    .appendPath("conversation").appendPath(conversationType.getName().toLowerCase(Locale.US))
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

    /**
     *  public void run() {
     *             Iterator var1 = this.selectedFileInfos.iterator();
     *
     *             while(var1.hasNext()) {
     *                 FileInfo fileInfo = (FileInfo)var1.next();
     *                 Uri filePath = Uri.parse("file://" + fileInfo.getFilePath());
     *                 FileMessage fileMessage = FileMessage.obtain(filePath);
     *                 if (fileMessage != null) {
     *                     fileMessage.setType(fileInfo.getSuffix());
     *                     Message message = Message.obtain(this.targetId, this.conversationType, fileMessage);
     *                     RongIM.getInstance().sendMediaMessage(message, (String)null, (String)null, (ISendMediaMessageCallback)null);
     *
     *                     try {
     *                         Thread.sleep(400L);
     *                     } catch (InterruptedException var7) {
     *                         RLog.e("FileInputProvider", "sendMediaMessage e:" + var7.toString());
     *                         Thread.currentThread().interrupt();
     *                     }
     *                 }
     *             }
     *
     *         }
     * @param pdfUri
     */
    public void sendPdfMessage(Uri pdfUri){
        FileMessage fileMessage = FileMessage.obtain(pdfUri);
        if (fileMessage != null) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    fileMessage.setType("pdf");
                    Message message = Message.obtain(targetId, conversationType, fileMessage);
                    RongIM.getInstance().sendMediaMessage(message, (String) null, (String) null, (IRongCallback.ISendMediaMessageCallback) null);

                    try {
                        Thread.sleep(400L);
                    } catch (InterruptedException var7) {
                        RLog.e("FileInputProvider", "sendMediaMessage e:" + var7.toString());
                        Thread.currentThread().interrupt();
                    }
                }
            }).start();
        }

    }

    @Override
    public void uploadPdf() {
        Bundle bundle = new Bundle();
        bundle.putString(UploadPdfMessagePresenter.PROJECT_ID, "");
        Tools.jump(this, UploadPdfMessageActivity.class, bundle, false);
    }

    @Override
    public void sendCooperation() {
        //有相关的信息，需要透传下来
        if (mPresenter.hasProject()) {
            confirmCooperationDialog();
        } else { //如果当前没有项目id，弹框选择项目，然后再弹框
            changeProject();
        }
    }

    @Override
    public void sendCooperationApply() {
        String demand = "";
        String applyId = "";
        String projectId = "";
        RongIMUtils.INSTANCE.sendCooperationApply(conversationType, targetId, CooperationApplyMessageContent.obtain("", projectId, demand, applyId));
    }

    private void confirmCooperationDialog() {
        String demand = "";
        String applyId = "";
        String projectId = "";
        //如果当前项目id，就弹框
        ReceivedConfirmDialog.newInstance(mPresenter.getConfirmCooperationContent())
                .setConfirmListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //发送合作信息,自定义消息
                        RongIMUtils.INSTANCE.sendCooperation(conversationType, targetId, CooperationMessageContent.obtain("", projectId, demand, applyId));
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
    public void shareUser() {
        InviteMemberShareDialog.newInstance().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userId = "";
                String userName = "";
                String headImage = "";
                String occupation = "";
                RongIMUtils.INSTANCE.sendShareUser(conversationType, targetId, ShareUserMessageContent.obtain("", userId, userName, headImage, occupation));
            }
        }).show(this);
    }

    @Override
    public void shareWork() {
        String userId = "";
        String userName = "";
        String headImage = "";
        String work_id = "";
        RongIMUtils.INSTANCE.sendShareWork(conversationType, targetId, ShareWorkMessageContent.obtain("", userId, userName, headImage, work_id));
    }


}
