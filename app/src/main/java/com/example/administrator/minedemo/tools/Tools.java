package com.example.administrator.minedemo.tools;

import android.content.Context;
import android.net.ParseException;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Tools {
    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dp2px(Context context, double dpValue) {
        int res = 0;
        final float scale = context.getResources().getDisplayMetrics().density;
        if (dpValue < 0)
            res = -(int) (-dpValue * scale + 0.5f);
        else
            res = (int) (dpValue * scale + 0.5f);
        return res;
    }

    /**
     * 将dip或dp值转换为px值，保证尺寸大小不变
     *
     * @param dipValue （DisplayMetrics类中属性density）
     * @return
     */
    public static int dip2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

    /**
     * 将px值转换为sp值，保证文字大小不变
     *
     * @param pxValue （DisplayMetrics类中属性scaledDensity）
     * @return
     */
    public static int px2sp(Context context, float pxValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }

    /**
     * 将sp值转换为px值，保证文字大小不变
     *
     * @param spValue （DisplayMetrics类中属性scaledDensity）
     * @return
     */
    public static int sp2px(Context context, float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);

    }

    /**
     * @param context
     * @return int
     * @Name getScreenWidth
     * @Description TODO 获取屏幕宽度
     * @Author Administrator
     * @Date 2014-12-23 下午1:58:50
     **/
    public static int getScreenWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    /**
     * @param context
     * @return int
     * @Name getScreenHeight
     * @Description TODO 获取屏幕高度
     * @Author Administrator
     * @Date 2014-12-23 下午1:59:03
     **/
    public static int getScreenHeight(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }


    //转换为带一位的小数

    public static String keepDecimal(String data) {
        String newData = "";
        if (data.split("\\.").length > 1) {
            String xiaoshu = data.split("\\.")[1];
            newData = data.split("\\.")[0] + "." + xiaoshu.substring(0, 1);
        } else {
            return data;
        }
        return newData;
    }
    //转换分钟 小时 刚刚  显示时间的时候用

    public static String getDate(String data) {
        String newData = "";
        if (!TextUtils.isEmpty(data)) {
            Long time = Long.parseLong(data);
            Long now = System.currentTimeMillis() - time;
            if (now / 1000 / 60 < 1) {
                newData = "刚刚";
            } else if (now / 1000 / 60 / 60 < 1) {
                newData = (int) (now / 1000 / 60) + "分钟前";
            } else if (now / 1000 / 60 / 60 / 24 < 1) {
                newData = (int) (now / 1000 / 60 / 60) + "小时前";
            } else if (now / 1000 / 60 / 60 / 24 / 30 < 1) {
                newData = (int) (now / 1000 / 60 / 60 / 24) + "天前";
            } else if (now / 1000 / 60 / 60 / 24 / 30 >= 1) {
                newData = (int) (now / 1000 / 60 / 60 / 24 / 30) + "月前";
            }
        } else {
            return data;
        }
        return newData;
    }
    //转换为整数

    public static String keepDecimal2(String data) {
        String newData = "";
        if (data.split("\\.").length > 1) {
            String xiaoshu = data.split("\\.")[1];
            String zhengshu = data.split("\\.")[0];
            if (Integer.parseInt(zhengshu) >= 100) {
                newData = data.split("\\.")[0] + "";
            } else {
                newData = data.split("\\.")[0] + "." + xiaoshu.substring(0, 1);
            }

        } else {
            return data;
        }
        return newData;
    }

    //老司机档案模块去除地址中的省
    public static String getCity(String data) {
        String newData = "";
        String city[] = data.split("\\,");
        if (city.length > 1) {
            for (int i = 0; i < city.length; i++) {
                if (i > 0) {
                    newData = newData + city[i];
                }
            }
        } else {
            return data;
        }
        return newData;
    }

    /*
       * 将时间转换为时间戳
       */
    public static String dateToStamp(String s) throws ParseException {
        if (TextUtils.isEmpty(s)) {
            return "";
        }
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = simpleDateFormat.parse(s);
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        long ts = date.getTime();
        res = String.valueOf(ts);
        return res;
    }

    /*
    * 将时间戳转换为时间
    */
    public static String stampToDate(String s) {
        if (TextUtils.isEmpty(s)) {
            return "";
        }
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lt = new Long(s);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }

    /*
  * 将网络图片地址截取出最后一截
  */
    public static String splitrUrl(String s) {
        String url_name="";
        if (TextUtils.isEmpty(s)) {
            return s;
        }else{
           String url[]=s.split("/");
            if(url.length>0){
                url_name=url[url.length-1];
            }else{
                return s;
            }
        }
        return url_name;

    }
    //计算两个日期相差多少天
    public static int daysBetween(String bdate) throws ParseException, java.text.ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.setTime(sdf.parse(sdf.format(System.currentTimeMillis())));
        long time1 = cal.getTimeInMillis();
        cal.setTime(sdf.parse(bdate));
        long time2 = cal.getTimeInMillis();
        long between_days=(time2-time1)/(1000*3600*24);

        return Integer.parseInt(String.valueOf(between_days));
    }
    /**
     * 隐藏键盘
     */
    public static void hideInputKeyboard(Context context, View v) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }
}
