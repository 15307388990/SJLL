package com.ming.sjll.my.dialog;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.databinding.ViewDataBinding;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.ming.sjll.R;
import com.ming.sjll.base.dialog.BaseDialog;
import com.ming.sjll.base.widget.ToastShow;
import com.ming.sjll.databinding.UpgradeDialogBinding;
import com.ming.sjll.my.bean.VersionBean;
import com.yanzhenjie.permission.Action;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.runtime.Permission;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;


/**
 * @Author luoming
 * @Date 2019/3/14 10:32 AM
 * 版本升级
 */
public class VersionUpgradeDialog extends BaseDialog {

    private static final String VERSION = "version";
    private UpgradeDialogBinding binding;
    private OnClickListener onClickListener;
    private ProgressDialog mProgDialog;
    private ProgressBar pBar;
    private TextView tv_progress;
    private Handler mViewUpdateHandler;
    // 下载存储的文件名
    private static final String DOWNLOAD_NAME = "ssl";
    private Context mContext;
    Dialog dialog;
    private boolean iShow = false;
    VersionBean versionBean=null;

    /**
     * 定义结果回调接口
     */
    public interface OnClickListener {
        void successful(String paymentVoucher);

    }

    public boolean getIshow() {
        return iShow;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        dialog = new Dialog(getActivity(), R.style.DialogTheme);
        if (dialog.getWindow() != null) {
            dialog.getWindow().setDimAmount(0.65f);
        }
        ViewDataBinding binding = getLayoutBind();
        View view = binding.getRoot();
        dialog.setContentView(view);
        initView(binding);
        initWindowParams(dialog);
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
            @Override
            public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK) {
                    return true;
                }
                return false;
            }
        });
        return dialog;
    }

    @Override
    public Dialog getDialog() {
        return dialog;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewUpdateHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                // TODO Auto-generated method stub
                super.handleMessage(msg);
                int progress = pBar.getProgress();
                int max = pBar.getMax();
                double dProgress = (double) progress / (double) (1024 * 1024);
                double dMax = (double) max / (double) (1024 * 1024);

            }
        };
    }


    @Override
    public void show(Object object) {
        this.mContext = (Context) object;
        this.iShow = true;
        try {
            super.show(object);
        } catch (IllegalStateException var5) {
        }

    }

    public static VersionUpgradeDialog newInstance(VersionBean versionBean) {
        VersionUpgradeDialog dialog = new VersionUpgradeDialog();
        Bundle bundle = new Bundle();
        bundle.putSerializable(VERSION, versionBean);
        dialog.setArguments(bundle);
        return dialog;
    }


    @Override
    public void dismiss() {
        this.iShow = false;
        if (this.getActivity() != null && !this.getActivity().isFinishing()) {
            super.dismissAllowingStateLoss();
        }
    }

    @Override
    public void dismissAllowingStateLoss() {
        super.dismissAllowingStateLoss();
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
    }

    @Override
    public int getLayoutId() {
        return R.layout.upgrade_dialog;
    }



    @Override
    public void initView(ViewDataBinding dataBinding) {
        binding = (UpgradeDialogBinding) dataBinding;
        pBar = binding.pbProgressbar;
        tv_progress = binding.tvProgress;
        mProgDialog = new ProgressDialog(VersionUpgradeDialog.this.getActivity());
        mProgDialog.setCancelable(false);
        Bundle bundle = getArguments();
        if (bundle != null) {
            versionBean = (VersionBean) bundle.getSerializable(VERSION);
        }
        binding.tvTitle.setText("发现新版本" + versionBean.getData().getVersionName());
        binding.tvContext.setText(versionBean.getData().getVersionTip());
        binding.tvOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(versionBean.getData().getDownloadUrl())) {
                    initPermission();
                } else {
                    ToastShow.s("APK下载地址为空");
                }
            }
        });
        binding.tvCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });


    }

    private void initPermission() {
        AndPermission.with(getActivity())
                .runtime()
                .permission(Permission.WRITE_EXTERNAL_STORAGE,Permission.READ_EXTERNAL_STORAGE).
                onGranted(new Action<List<String>>() {
                    @Override
                    public void onAction(List<String> data) {
                        binding.tvContext.setVisibility(View.GONE);
                        binding.llProgres.setVisibility(View.VISIBLE);
                        binding.tvOk.setVisibility(View.GONE);
                        DownloadTask downloadTask = new DownloadTask(
                                getActivity());
                        downloadTask.execute(versionBean.getData().getDownloadUrl());
                    }
                }).
                onDenied(new Action<List<String>>() {
                    @Override
                    public void onAction(List<String> data) {
                        ToastShow.s("无法获取手机权限，功能无法正常使用");
                    }
                }).
                start();

    }

    /**
     * 下载应用
     *
     * @author Administrator
     */
    class DownloadTask extends AsyncTask<String, Integer, String> {

        private Context context;
        // private PowerManager.WakeLock mWakeLock;

        public DownloadTask(Context context) {
            this.context = context;
        }

        @Override
        protected String doInBackground(String... sUrl) {
            InputStream input = null;
            OutputStream output = null;
            HttpURLConnection connection = null;
            File file = null;
            try {
                URL url = new URL(sUrl[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();
                // expect HTTP 200 OK, so we don't mistakenly save error
                // report
                // instead of the file
                if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                    return "Server returned HTTP "
                            + connection.getResponseCode() + " "
                            + connection.getResponseMessage();
                }
                // this will be useful to display download percentage
                // might be -1: server did not report the length
                int fileLength = connection.getContentLength();
                if (Environment.getExternalStorageState().equals(
                        Environment.MEDIA_MOUNTED)) {
                    file = new File(Environment.getExternalStorageDirectory(),
                            DOWNLOAD_NAME);

                    if (!file.exists()) {
                        // 判断父文件夹是否存在
                        if (!file.getParentFile().exists()) {
                            file.getParentFile().mkdirs();
                        }
                    }

                } else {
                    Toast.makeText(getActivity(), "sd卡未挂载",
                            Toast.LENGTH_LONG).show();
                }
                input = connection.getInputStream();
                output = new FileOutputStream(file);
                byte data[] = new byte[4096];
                long total = 0;
                int count;
                while ((count = input.read(data)) != -1) {
                    // allow canceling with back button
                    if (isCancelled()) {
                        input.close();
                        return null;
                    }
                    total += count;
                    // publishing the progress....
                    if (fileLength > 0) // only if total length is known
                        publishProgress((int) (total * 100 / fileLength));
                    output.write(data, 0, count);

                }
            } catch (Exception e) {
                System.out.println("错误—+" + e.toString());
                return e.toString();

            } finally {
                try {
                    if (output != null)
                        output.close();
                    if (input != null)
                        input.close();
                } catch (IOException ignored) {
                    System.out.print("错误信息" + ignored.toString());
                }
                if (connection != null)
                    connection.disconnect();
            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // take CPU lock to prevent CPU from going off if the user
            // presses the power button during download
//            PowerManager pm = (PowerManager) context
//                    .getSystemService(Context.POWER_SERVICE);
//            mWakeLock = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK,
//                    getClass().getName());
//            mWakeLock.acquire();
        }

        @Override
        protected void onProgressUpdate(Integer... progress) {
            super.onProgressUpdate(progress);
            // if we get here, length is known, now set indeterminate to false
            pBar.setIndeterminate(false);
            pBar.setMax(100);
            pBar.setProgress(progress[0]);
            tv_progress.setText(pBar.getProgress() + "%");

        }

        @Override
        protected void onPostExecute(String result) {
            //mWakeLock.release();
            dismiss();
            if (result != null) {

                // 申请多个权限。大神的界面
              //  initPermission();


                Toast.makeText(context, "您未打开SD卡权限" + result, Toast.LENGTH_LONG).show();
            } else {
                // Toast.makeText(context, "File downloaded",
                // Toast.LENGTH_SHORT)
                // .show();
                update();
            }

        }
    }


    private static final int REQUEST_CODE_SETTING = 300;


    private void update() {
        File apkfile = new File(Environment.getExternalStorageDirectory(), DOWNLOAD_NAME);
        if (!apkfile.exists()) {
            return;
        }
        AndPermission.with(getActivity())
                .install()
                .file(apkfile)
                .start();
//        //安装应用
//        Intent intent = new Intent(Intent.ACTION_VIEW);
//        //判断是否是AndroidN以及更高的版本
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//            intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
//            Uri contentUri = FileProvider.getUriForFile(mContext, BuildConfig.APPLICATION_ID + ".fileProvider", apkfile);
//            intent.setDataAndType(contentUri, "application/vnd.android.package-archive");
//        } else {
//            intent.setDataAndType(Uri.fromFile(new File(Environment
//                    .getExternalStorageDirectory(), DOWNLOAD_NAME)), "application/vnd.android.package-archive");
//            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        }
//
//        try {
//            startActivity(intent);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


    }


}
