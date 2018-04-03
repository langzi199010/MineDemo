package com.example.administrator.minedemo;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;

import com.taobao.sophix.PatchStatus;
import com.taobao.sophix.SophixManager;
import com.taobao.sophix.listener.PatchLoadStatusListener;

import java.util.List;


public class MyApplication extends Application {

    private static MyApplication mInstance = null;

    Context context;

    public static MyApplication getInstance() {
        if (mInstance == null) {
            mInstance = new MyApplication();
        }
        return mInstance;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        initSophix();

    }

    private void initSophix() {
        String versionName="1.0.0";
        PackageManager packageManager = getPackageManager();
        PackageInfo packInfo = null;
        try {
            packInfo = packageManager.getPackageInfo(
                    getPackageName(), 0);
            versionName = packInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
// initialize最好放在attachBaseContext最前面，初始化直接在Application类里面，切勿封装到其他类
        SophixManager.getInstance().setContext(this)
                .setAppVersion(versionName)
                .setAesKey(null)
                .setEnableDebug(true)
                .setSecretMetaData("24810268-1","3a27bd2a8c01a2d5456698c38ca8ba9c","MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQC2xUtJG5g9EEAP+Y/F6GUvUDGNYAa6UxA8OzrDCCscSumTM8Rzl3FLXzqEw1UYD8OBu6e1diATL3f2FtcufmQa8byecGxU1PkCsBy4qAOC1zdTGus9mCyCUd5pJNi4JwDm9YyS0jn0MkNVQSX1vvYFD4S1AaluJKpDmm0UHIxMFBQ4m4COVTLhr2nhsuAI1BRd+CLz2MN/X4/I0XUw/ISHSaJavLVpB3w3YzOXxic3BhB65yRfYjPawzWhytRgfIwbJCFS5aNTH/Mp46n10YzUTv+Vb+HfxH/Oe7LoDkmDj3j28OtN9vqpl3Y4p9cqtgDwDCJuWxdlG+UKsOKFDDDDAgMBAAECggEACZUWeWLE/I6ZjTzcWNfyViSyNGNQdvxb4YyJbChFelpDHMCeECFkgzse6k8DaxuIeIjKJi1nSRo4A+L2rS1bOj5qUTQ7ucbgt09cciH87SMzd1v18WjFDKAWNRUFd8Izvegp0pjLCQ6JkTK1NskoROOnZYYMyAWMF7dE+MT2ZhagsyGcgX7eFjQEuf7A2u8Stcu1qjJwu2BPc3uOMokw4+JGTGfHFY80ODhex95e+YhFHeYharS0GS4uWc06EGJ7MWiodJ0CSsiIg9PYU4zwegz/BMJxzPtkkEeUa3syODr4wNs+TcPDFwdmXiYVM4ZWyZMfmVbrnZPo2rb1h3/J4QKBgQDjSdxPSfR68WcdJG001gvsQk4UEuHZ9QODZgv7xQfRBMgAYeMpXeXndK452jiPmPLHPcV/MHOIerXW8XrQd6+2Or5+lGnNdw+2bMHz0GlHD+vSnvlgOZVMSTMHpcTROiXmKfzVT/lWpniL/5QbEL8SEaKCSDhFPARJNxPuZZQzrQKBgQDN28yhY7d5RkDt0ZOJsb5/XQxx+knXhhwPrfJZrPhR+hMzzXtpE04m1XA1B2BhFjvq5w84C5ucVXOgQS6lnVw3CiGMTDuLXq8ifG8vfFXLDshsT3ZQ0QKuVGXSquvDupJUOqAbSAtJNLRq2kXZyKOc62IWbcV4Hv6xFq6ExygELwKBgEhS2m3IhKkSY9NcIfvsGIMnXhz5HTDzzBhlwm5s9d3G/bVRcK1bGasa782s6M6YxrgrqcqdKkZFddNdp8zqKNl9u9wfccNVnYRY+yaQLM/V+x5cQ9IgwKczq69FSmmhbSneNnvSJO8zrawuuXwbShF/1wxJ2s39GQgLJKZ5YD1JAoGBAJsUWWy/bSl8Rk+iUU4qy8Kw+z4l+ljVm/An72mlB5DiHnMo+i5nL7nLkvMv8mhRUqQcmvdyrzCvoyJ32EdFa4G/LRS/HSBaHP+S1EPmm88T/OKzXgN14VopFGgHAQN7Wt7/JzxGItJsVPomIvb00mTVYhhZa6iZWO9ZkfFPAxNbAoGAOWQJbwygIPI7HQ2Js9bBXAVgARq7MXZUQ96tzDyn5hFcF8Pr+ikADQ3dB5l8RsQEftiZhHzrt0GpvCS8fymKAvc8VwEtGQ7y4kJXwJVZyIloOFo0awa6KM/z+pbiXI8ue5op7cAhWKGnUmJtUgpglIPVfNdefxpHStTHpzpgZGc=")
                .setPatchLoadStatusStub(new PatchLoadStatusListener() {
                    @Override
                    public void onLoad(final int mode, final int code, final String info, final int handlePatchVersion) {
                        // 补丁加载回调通知
                        Log.i("youtu",code+"");
                        if (code == PatchStatus.CODE_LOAD_SUCCESS) {
                            // 表明补丁加载成功
                        } else if (code == PatchStatus.CODE_LOAD_RELAUNCH) {
                            // 表明新补丁生效需要重启. 开发者可提示用户或者强制重启;
                            // 建议: 用户可以监听进入后台事件, 然后调用killProcessSafely自杀，以此加快应用补丁，详见1.3.2.3
                        } else {
                            // 其它错误信息, 查看PatchStatus类说明
                        }
                    }
                }).initialize();

    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
// queryAndLoadNewPatch不可放在attachBaseContext 中，否则无网络权限，建议放在后面任意时刻，如onCreate中
//        SophixManager.getInstance().queryAndLoadNewPatch();
    }


    /**
     * @param cxt
     * @param pid
     * @return
     */
    public static String getProcessName(Context cxt, int pid) {
        ActivityManager am = (ActivityManager) cxt
                .getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> runningApps = am.getRunningAppProcesses();
        if (runningApps == null) {
            return null;
        }
        for (ActivityManager.RunningAppProcessInfo procInfo : runningApps) {
            if (procInfo.pid == pid) {
                return procInfo.processName;
            }
        }
        return null;
    }


}
