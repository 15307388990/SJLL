package com.ming.sjll.my.dialog;

import android.content.Intent;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ming.sjll.R;
import com.ming.sjll.base.dialog.BaseDialog;
import com.ming.sjll.databinding.DialogMyEditorDataBinding;
import com.ming.sjll.my.bean.PersonalDateBean;
import com.ming.sjll.my.fragment.ImageFragemt;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EditorDataDialog extends BaseDialog implements ImageFragemt.UpdateData {

    private OnClickListener onClickListener;
    private static final String CONTENT = "content";
    private List<Fragment> fragmentList;
    private DialogMyEditorDataBinding editorBinding;
    private PersonalDateBean.DataBeanX.DataBean dataBean;
    private Adapter mAdapter;
    private List<String> imageLists;//中间图片集合

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

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewDataBinding binding = getLayoutBind();
        View view = binding.getRoot();
        initView(binding);
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (fragmentList != null) {
            for (Fragment fragment : fragmentList) {
                fragment.onActivityResult(requestCode, resultCode, data);
            }
        }
    }

    @Override
    public void initView(ViewDataBinding dataBinding) {
        dataBean = (PersonalDateBean.DataBeanX.DataBean) getArguments().getSerializable(CONTENT);
        editorBinding = (DialogMyEditorDataBinding) dataBinding;
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
        //将图片集合转换成字符串集合
        imageLists = new ArrayList<>();
        for (PersonalDateBean.DataBeanX.DataBean.ImgListBean imgListBean : dataBean.getImgList()) {
            imageLists.add(imgListBean.getImg());
        }
        initViewpage();


    }

    //初始化viewpage
    private void initViewpage() {
        fragmentList = new ArrayList<>();
        for (int i = 0; i <= imageLists.size() / 6; i++) {
            List<String> stringList = new ArrayList<>();

            if (i == imageLists.size() / 6) {
                //第一页 或者最后一页
                for (int j = (0 + i) * 6; j < imageLists.size(); j++) {
                    stringList.add(imageLists.get(j));
                }
                fragmentList.add(ImageFragemt.newInstance().setList(stringList, false, this));
                //总集合移除这一段
                imageLists.removeAll(stringList);
            } else {
                //其它页
                for (int j = (0 + i) * 6; j < i * 6 + 6; j++) {
                    stringList.add(imageLists.get(j));
                }
                fragmentList.add(ImageFragemt.newInstance().setList(stringList, true, this));
            }

        }
        mAdapter = new Adapter(getChildFragmentManager(), fragmentList);
        editorBinding.viewpager.setAdapter(mAdapter);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    @Override
    public boolean isBottom() {
        return true;
    }

    @Override
    public void add(List<String> list) {
        //替换最后的数据
        for (String img : list) {
            imageLists.add(img);
        }
        initViewpage();
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
