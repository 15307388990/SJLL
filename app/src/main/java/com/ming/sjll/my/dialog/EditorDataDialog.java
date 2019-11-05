package com.ming.sjll.my.dialog;

import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;

import com.ming.sjll.R;
import com.ming.sjll.base.dialog.BaseDialog;
import com.ming.sjll.base.utils.TextUtil;
import com.ming.sjll.databinding.DialogMyEditorBinding;
import com.ming.sjll.databinding.DialogMyEditorDataBinding;
import com.ming.sjll.my.adapter.PersonalImageAdapter;
import com.ming.sjll.my.bean.PersonalDateBean;
import com.ming.sjll.my.fragment.ImageFragemt;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EditorDataDialog extends BaseDialog {

    private OnClickListener onClickListener;
    private static final String CONTENT = "content";

    public static EditorDataDialog newInstance(PersonalDateBean.DataBeanX.DataBean dataBean) {

        Bundle args = new Bundle();
        args.putSerializable(CONTENT, (Serializable) dataBean);
        EditorDataDialog fragment = new EditorDataDialog();
        fragment.setArguments(args);
        return fragment;
    }

    public EditorDataDialog setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
        return this;
    }


    @Override
    public int getLayoutId() {
        return R.layout.dialog_my_editor_data;
    }

    @Override
    public void initView(ViewDataBinding dataBinding) {
        PersonalDateBean.DataBeanX.DataBean dataBean = (PersonalDateBean.DataBeanX.DataBean) getArguments().getSerializable(CONTENT);
        DialogMyEditorDataBinding editorBinding = (DialogMyEditorDataBinding) dataBinding;
        editorBinding.etTitle.setText(dataBean.getTitle());
        editorBinding.etNtroduction.setText(dataBean.getDescribe());
        editorBinding.flowtag.addTags(dataBean.getTagsList());
        editorBinding.btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        editorBinding.tvAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(editorBinding.etBiaoqian.getText().toString().trim())) {
                    editorBinding.flowtag.addTag(editorBinding.etBiaoqian.getText().toString().trim());
                    editorBinding.tvAdd.setText("");
                }
            }
        });
        editorBinding.ivClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        editorBinding.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickListener.Save(dataBean);
            }
        });

        List<Fragment> fragmentList = new ArrayList<>();
        for (int i = 0; i <= dataBean.getImgList().size() / 6; i++) {
            List<String> stringList = new ArrayList<>();

            if (i == dataBean.getImgList().size() / 6) {
                //第一页 或者最后一页
                for (int j = (0+i)*6; j < dataBean.getImgList().size(); j++) {
                    stringList.add(dataBean.getImgList().get(j).getImg());
                }

            } else {
                //其它页
                for (int j = (0+i)*6; j <(5+i)*6 ; j++) {
                    stringList.add(dataBean.getImgList().get(j).getImg());
                }

            }

            fragmentList.add(ImageFragemt.newInstance());
        }
        editorBinding.viewpager.setAdapter(new Adapter(getChildFragmentManager(),fragmentList));

    }

    @Override
    public boolean isBottom() {
        return true;
    }

    public interface OnClickListener {
        void Save(PersonalDateBean.DataBeanX.DataBean dataBean);

    }

    class Adapter extends FragmentStatePagerAdapter {
        private List<Fragment> fragmentList;

        public Adapter(FragmentManager fm, List<Fragment> fragmentList) {
            super(fm);
            this.fragmentList = fragmentList;
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }


    }
}
