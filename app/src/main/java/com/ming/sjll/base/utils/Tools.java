/**
 *
 */
package com.ming.sjll.base.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static android.content.Context.TELEPHONY_SERVICE;

/**
 * @author WuJianHua 工具类
 */
public class Tools {
    private static long lastClickTime;
    public static List<Activity> acts = new ArrayList<Activity>();// 界面栈
    public static List<Activity> webacts = new ArrayList<Activity>();// 网页界面栈
    private static DecimalFormat df = new DecimalFormat("0.00");


    /**
     * 弹出日期选择器
     */
    public static void showDateDialog(Context context, DatePickerDialog.OnDateSetListener listener,
                                      Calendar mycalendar) {
        DatePickerDialog dialog = new DatePickerDialog(context, listener, mycalendar.get(Calendar.YEAR),
                mycalendar.get(Calendar.MONTH), mycalendar.get(Calendar.DAY_OF_MONTH));
        dialog.show();
    }

    /**
     * 获取设备品牌名称
     */
    public static String getBrandName() {
        Build bd = new Build();
        return bd.BRAND;
    }

    /**
     * 获取设备型号
     */
    public static String getBrandModel() {
        Build bd = new Build();
        return bd.MODEL;
    }

    /**
     * 获取手机IMEI
     */
    public static String getImei(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(TELEPHONY_SERVICE);
        @SuppressLint("MissingPermission") String szImei = telephonyManager.getDeviceId();
        return szImei;
    }

    /**
     * 防止控件被重复点击
     *
     * @return
     */
    public static boolean isFastDoubleClick() {
        long time = System.currentTimeMillis();
        long timeD = time - lastClickTime;
        if (0 < timeD && timeD < 1500) {
            return true;
        }
        lastClickTime = time;
        return false;
    }

    // 判断是否符合身份证号码的规范
    public static boolean isIDCard(String IDCard) {
        if (IDCard != null) {
            String IDCardRegex = "(^\\d{15}$)|(^\\d{18}$)|(^\\d{17}(\\d|X|x|Y|y)$)";
            return IDCard.matches(IDCardRegex);
        }
        return false;
    }

    /**
     * 保存图片
     *
     * @param bitmap
     * @param bitName
     * @throws IOException
     */
    public static void saveBitmap(Bitmap bitmap, String bitName) throws IOException {
        File file = new File(bitName);
        if (file.exists()) {
            file.delete();
        }
        FileOutputStream out;
        try {
            out = new FileOutputStream(file);
            if (bitmap.compress(Bitmap.CompressFormat.PNG, 90, out)) {
                out.flush();
                out.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //获取屏幕宽度
    public static int getScreenWidth(Context context) {
        DisplayMetrics dm = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(dm);
        return dm.widthPixels;
    }

    //获取屏幕高度
    public static int getScreenHeight(Context context) {
        DisplayMetrics dm = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(dm);
        return dm.heightPixels;
    }


    /**
     * 将List<String>集合 转化为String
     * 如{"aaa","bbb"} To 'aaa','bbb'
     */
    public static String convertListToString(List<String> strlist) {
        StringBuffer sb = new StringBuffer();
        if (!TextUtils.isEmpty(strlist.toString())) {
            for (int i = 0; i < strlist.size(); i++) {
                if (i == 0) {
                    sb.append(strlist.get(i));
                } else {
                    sb.append(",").append(strlist.get(i));
                }
            }
        }
        return sb.toString();
    }

    /**
     * 价格 分转元
     */
    public static String getFenYuan(int prcie) {
        if (prcie == 0) {
            return 0.00 + "";
        }
        return df.format((double) prcie / 100);
    }

    /**
     * 价格 分转元
     */
    public static float getFenYuan2(int prcie) {
        if (prcie == 0) {
            return (float) 0.0;
        }
        return (float) prcie / 100;
    }

    /**
     * 价格 元转分
     */
    public static int getYuanFen(String prcieString) {
        double prcie = Double.valueOf(prcieString.replace(" ", ""));
        return (int) (prcie * 100);

    }

    /**
     * 退出
     */
    public static void exit() {
        try {
            for (Activity act : acts) {
                // acts.remove(act);
                act.finish();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 退出
     */
    public static void webexit() {
        try {
            for (Activity act : webacts) {
                // acts.remove(act);
                act.finish();
            }
            webacts.clear();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 退出
     */
    public static void webexit(int page) {
        try {
            for (int i = 1; i <= page; i++) {
                webacts.get(webacts.size() - 1).finish();
                webacts.remove(webacts.size() - 1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * @param pNumber 手机号码隐藏中间四位数字
     * @return
     */
    public static String pNumber(String pNumber) {
        if (!TextUtils.isEmpty(pNumber) && pNumber.length() > 6) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < pNumber.length(); i++) {
                char c = pNumber.charAt(i);
                if (i >= 3 && i <= 6) {
                    sb.append('*');
                } else {
                    sb.append(c);
                }
            }

            return sb.toString();
        }
        return "";
    }

    /**
     * @param pNumber 银行卡号隐藏中间8位数字
     * @return
     */
    public static String pCardNumber(String pNumber) {
        if (!TextUtils.isEmpty(pNumber) && pNumber.length() > 10) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < pNumber.length(); i++) {
                char c = pNumber.charAt(i);
                if (i >= 4 && i <= 11) {
                    sb.append('*');
                } else {
                    sb.append(c);
                }
            }

            return sb.toString();
        }
        return "";
    }

    /**
     * 验证邮箱
     *
     * @param email
     * @return
     */
    public static boolean checkEmail(String email) {
        boolean flag = false;
        try {
            String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
            Pattern regex = Pattern.compile(check);
            Matcher matcher = regex.matcher(email);
            flag = matcher.matches();
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    /**
     * @param context     检测手机是否安装app
     * @param packageName 包名
     * @return
     */
    public static boolean isAppInstalled(Context context, String packageName) {
        final PackageManager packageManager = context.getPackageManager();
        List<PackageInfo> pinfo = packageManager.getInstalledPackages(0);
        List<String> pName = new ArrayList<String>();
        if (pinfo != null) {
            for (int i = 0; i < pinfo.size(); i++) {
                String pn = pinfo.get(i).packageName;
                pName.add(pn);
            }
        }
        return pName.contains(packageName);
    }

    /**
     * 手机正则表达式
     */
    public static boolean isMobileNum(String mobiles) {
        Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,1-9])|(17[0,1-9])|(14[0,1-9]))\\d{8}$");
        Matcher m = p.matcher(mobiles);
        System.out.println(m.matches() + "---");
        return m.matches();
    }

    /**
     * 密码正则表达式 密码要求6-18位 字母+数字，
     */
    public static boolean isPassword(String mobiles) {
        String passRegex = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,18}$";
        return !TextUtils.isEmpty(mobiles) && mobiles.matches(passRegex);
    }


    public static String readTextFile(InputStream inputStream) {
        InputStreamReader inputStreamReader = null;
        try {
            inputStreamReader = new InputStreamReader(inputStream, "gbk");
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        BufferedReader reader = new BufferedReader(inputStreamReader);
        StringBuffer sb = new StringBuffer("");
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line);
                sb.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    private static Toast toast;

    /**
     * 弹出吐司
     */
    public static void showToast(Context context, Object object) {
        if (toast == null) {
            toast = Toast.makeText(context, "", Toast.LENGTH_SHORT);
        }
        toast.setText(object.toString());

        toast.show();
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * convert px to its equivalent sp
     * <p>
     * 将px转换为sp
     */
    public static int px2sp(Context context, float pxValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }

    /**
     * convert sp to its equivalent px
     * <p>
     * 将sp转换为px
     */
    public static int sp2px(Context context, float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    public static String getRandomFileName() {

        SimpleDateFormat simpleDateFormat;

        simpleDateFormat = new SimpleDateFormat("yyyyMMdd");

        Date date = new Date();

        String str = simpleDateFormat.format(date);

        Random random = new Random();

        int rannum = (int) (random.nextDouble() * (99999 - 10000 + 1)) + 10000;// 获取5位随机数

        return rannum + str;// 当前时间
    }

    public static String listToString(List list) {
        StringBuilder sb = new StringBuilder();
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                if (i < 8) {
                    if (i < list.size() - 1) {
                        sb.append(list.get(i) + ",");
                    } else {
                        sb.append(list.get(i));
                    }
                }
            }
        }
        return sb.toString();
    }

    /**
     * 验证输入的邮箱格式是否符合
     *
     * @param email
     * @return 是否合法
     */
    public static boolean emailFormat(String email) {
        Pattern pattern = Pattern.compile(
                "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    /**
     * 通过字符串获取date对象
     */
    public static Date getDateByStr(String str) {
        Date date = null;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            date = formatter.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 获取手机厂商
     *
     * @return 手机厂商
     */
    public static String getDeviceBrand() {
        return Build.BRAND;
    }

    /**
     * 获取当前手机系统版本号
     *
     * @return 系统版本号
     */
    public static String getSystemVersion() {
        return Build.VERSION.RELEASE;
    }

    /**
     * 获取手机型号
     *
     * @return 手机型号
     */
    public static String getSystemModel() {
        return Build.MODEL;
    }

    /**
     * 获取版本号
     *
     * @param context
     * @return
     */
    public static int packageCode(Context context) {
        PackageManager manager = context.getPackageManager();
        int code = 0;
        try {
            PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0);
            code = info.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return code;
    }

    /**
     * 获取版本名称
     *
     * @param context
     * @return
     */
    public static String getVersionName(Context context) {
        PackageManager manager = context.getPackageManager();
        String versionNam = null;
        try {
            PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0);
            versionNam = info.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionNam;
    }

    /**
     * 通过字符串获取date对象
     */
    public static String obtainDateNow() {
        String dataString = null;
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            dataString = formatter.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataString;
    }

    /**
     * 通过Date获取日期字符串对象
     */
    public static String getDateStr(Date date, String formateStr) {
        String dateStr = null;
        SimpleDateFormat formatter = new SimpleDateFormat(/* "yyyy-MM-dd HH:mm:ss" */formateStr);
        try {
            dateStr = formatter.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dateStr;
    }

    /**
     * 将int转为16进制,如果数字在byte或short范围内通过补0方式使其成为双字节16进制
     */
    public static String int2Short16Str(int i) {
        String str16 = Integer.toHexString(i);
        if (str16.length() == 1) {
            str16 = "000" + str16;
        } else if (str16.length() == 2) {
            str16 = "00" + str16;
        } else if (str16.length() == 3) {
            str16 = "0" + str16;
        }
        return str16;
    }

    /**
     * 跳转
     */
    public static void jump(Activity context, Class<?> cls, boolean afterFinish) {
        Intent intent = new Intent(context, cls);
        context.startActivity(intent);
        if (afterFinish)
            context.finish();
    }

    /**
     * string转时间
     */
    public static long getLongformat(String time) {

        if (TextUtils.isEmpty(time)) {
            return 0;
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = format.parse(time);
        } catch (Exception e) {
        }
        return date.getTime();

    }

    /**
     * double 保留两位小数
     */
    public static String getDoubleformat(double d) {
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(d);
    }

    /**
     * 时间戳转时间
     */
    public static String getDateformat(long time) {
        if (time == 0) {
            return "";
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(time);

    }

    /**
     * 时间戳转时间
     */
    public static String getDateformat3(long time) {
        if (time == 0) {
            return "";
        }
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        return format.format(time);

    }

    /**
     * 时间戳转时间
     */
    public static String getDateformat2(long time) {
        if (time == 0) {
            return "";
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(time);

    }

    /**
     * 时间戳转字符
     */
    public static String getDateString(long time) {
        if (time == 0) {
            return "";
        }
        //小时差
        int hours = (int) time / 1000 / 60 / 60;
        // 分钟差
        int minutes = (int) (time - (hours * 1000 * 60 * 60)) / 1000 / 60;
        return hours + "小时" + minutes + "分钟";

    }

    /**
     * 计算时间差
     */
    public static String getDateformat(String create_date) {
        String text = "";
        SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date now = new Date();
        // 开始时间
        long from = 0;
        try {
            from = simpleFormat.parse(create_date).getTime();
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // 现在时间
        long to = now.getTime();
        // 分钟差
        int minutes = (int) ((to - from) / (1000 * 60));
        minutes = 120 - minutes;
        if (minutes > 0) {
            if (minutes > 60) {
                text = "剩余支付时间1小时" + (minutes - 61) + "分钟";
            } else {
                text = "剩余支付时间" + minutes + "分钟";
            }
        } else {
            text = "已经超时了";
        }

        return text;

    }

    public static ArrayList<String> StringArrayToList(String[] covers) {
        ArrayList<String> wordList = new ArrayList<String>(Arrays.asList(covers));
        // wordList.add("1");
        return wordList;
    }

    public static void onSaveBitmap(final Bitmap mBitmap, final Context context) {
        // 第一步：首先保存图片
        //将Bitmap保存图片到指定的路径/sdcard/Boohee/下，文件名以当前系统时间命名,但是这种方法保存的图片没有加入到系统图库中
        File appDir = new File(Environment.getExternalStorageDirectory(), "Boohee");

        if (!appDir.exists()) {
            appDir.mkdir();
        }

        String fileName = System.currentTimeMillis() + ".jpg";
        File file = new File(appDir, fileName);

        try {
            FileOutputStream fos = new FileOutputStream(file);
            mBitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            fos.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 第二步：其次把文件插入到系统图库
        try {
            MediaStore.Images.Media.insertImage(context.getContentResolver(), file.getAbsolutePath(), fileName, null);
//   /storage/emulated/0/Boohee/1493711988333.jpg
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 第三步：最后通知图库更新
        context.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.parse("file://" + file)));
    }

    /**
     * 获取年
     * @return
     */
    public static int getYear() {
        Calendar cd = Calendar.getInstance();
        return cd.get(Calendar.YEAR);
    }

    /**
     * 获取月
     * @return
     */
    public static int getMonth() {
        Calendar cd = Calendar.getInstance();
        return cd.get(Calendar.MONTH) + 1;
    }

    /**
     * 获取日
     * @return
     */
    public static int getDay() {
        Calendar cd = Calendar.getInstance();
        return cd.get(Calendar.DATE);
    }

    public static String Date() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return  dateFormat.format(date);
    }
}
