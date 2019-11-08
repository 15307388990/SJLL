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

import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.entity.LocalMedia;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Progress;
import com.lzy.okgo.model.Response;
import com.ming.sjll.R;
import com.ming.sjll.api.Constant;
import com.ming.sjll.base.dialog.BaseDialog;
import com.ming.sjll.databinding.DialogMyEditorDataBinding;
import com.ming.sjll.my.bean.PersonalDateBean;
import com.ming.sjll.my.fragment.ImageFragemt;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EditorDataDialog extends BaseDialog {

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
        initDate();
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == getActivity().RESULT_OK) {
            switch (requestCode) {
                case PictureConfig.CHOOSE_REQUEST:
                    // 图片、视频、音频选择结果回调
                    List<LocalMedia> selectList = PictureSelector.obtainMultipleResult(data);
                    // 例如 LocalMedia 里面返回三种path
                    // 1.media.getPath(); 为原图path
                    // 2.media.getCutPath();为裁剪后path，需判断media.isCut();是否为true  注意：音视频除外
                    // 3.media.getCompressPath();为压缩后path，需判断media.isCompressed();是否为true  注意：音视频除外
                    // 如果裁剪并压缩了，以取压缩路径为准，因为是先裁剪后压缩的
                    List<File> fileList = new ArrayList<>();
                    for (LocalMedia localMedia : selectList) {
                        fileList.add(new File(localMedia.getPath()));
                    }
                    uploadFiles(fileList);
                    break;
            }
        }
    }

    @Override
    public void initView(ViewDataBinding dataBinding) {
        editorBinding = (DialogMyEditorDataBinding) dataBinding;

    }

    private void initDate() {
        dataBean = (PersonalDateBean.DataBeanX.DataBean) getArguments().getSerializable(CONTENT);
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
                    editorBinding.etBiaoqian.setText("");
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
        for (String string : dataBean.getImgList()) {
            imageLists.add(string);
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
                fragmentList.add(ImageFragemt.newInstance().setList(stringList, false));
            } else {
                //其它页
                for (int j = (0 + i) * 6; j < i * 6 + 6; j++) {
                    stringList.add(imageLists.get(j));
                }
                fragmentList.add(ImageFragemt.newInstance().setList(stringList, true));
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


    public interface OnClickListener {
        void Save(PersonalDateBean.DataBeanX.DataBean dataBean);

    }
    //上传图片
    public void uploadFiles(List<File> selectList) {
        OkGo.<String>post(Constant.BASE_API + Constant.UPLOADIMG)//
                .tag(this)//
                //.isMultipart(true)       // 强制使用 multipart/form-data 表单上传（只是演示，不需要的话不要设置。默认就是false）
                //.params("param1", "paramValue1")        // 这里可以上传参数
                //.params("image", new File(file))   // 可以添加文件上传
                //.params("file2", new File("filepath2"))     // 支持多文件同时添加上传
                .addFileParams("image[]", selectList)    // 这里支持一个key传多个文件
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        try {
                           EditorDataDialog.this.onSuccess(response);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFinish() {
                        super.onFinish();
                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                    }

                    @Override
                    public void uploadProgress(Progress progress) {
                        super.uploadProgress(progress);


                    }
                });
    }

    public void onSuccess(Response<String> response) throws JSONException {
        JSONObject jsonObject = new JSONObject(response.body());
        JSONArray jsonArray = jsonObject.getJSONArray("data");
        for (int i = 0; i < jsonArray.length(); i++) {
            imageLists.add((String) jsonArray.get(i));
        }
        initViewpage();
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
