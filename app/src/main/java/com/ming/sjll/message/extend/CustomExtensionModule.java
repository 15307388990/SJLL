package com.ming.sjll.message.extend;

import java.util.ArrayList;
import java.util.List;

import io.rong.imkit.DefaultExtensionModule;
import io.rong.imkit.plugin.IPluginModule;
import io.rong.imlib.model.Conversation;

public class CustomExtensionModule extends DefaultExtensionModule {
    private PdfPlugin pdfPlugin;
    private CooperationPlugin cooperationPlugin;
    private ChangeProjectPlugin changeProjectPlugin;
    private ComplaintPlugin complaintPlugin;

    @Override
    public List<IPluginModule> getPluginModules(Conversation.ConversationType conversationType) {
        List<IPluginModule> pluginModules = new ArrayList<>();
        pdfPlugin = new PdfPlugin();
        pluginModules.add(pdfPlugin);
        //单聊有合作和切换项目
        if (conversationType != Conversation.ConversationType.GROUP){
            cooperationPlugin = new CooperationPlugin();
            changeProjectPlugin = new ChangeProjectPlugin();
            pluginModules.add(cooperationPlugin);
            pluginModules.add(changeProjectPlugin);
        }
        complaintPlugin = new ComplaintPlugin();
        pluginModules.add(complaintPlugin);
        return pluginModules;
    }
}
