package com.example.administrator.minedemo.base;

/**
 * Created by Administrator on 2018/4/17.
 */
//阿里热修复
import android.app.Application;
import android.content.Context;
import android.support.annotation.Keep;
import android.support.multidex.MultiDex;
import android.util.Log;
import com.taobao.sophix.PatchStatus;
import com.taobao.sophix.SophixApplication;
import com.taobao.sophix.SophixEntry;
import com.taobao.sophix.SophixManager;
import com.taobao.sophix.listener.PatchLoadStatusListener;
/**
 * Sophix入口类，专门用于初始化Sophix，不应包含任何业务逻辑。
 * 此类必须继承自SophixApplication，onCreate方法不需要实现。
 * 此类不应与项目中的其他类有任何互相调用的逻辑，必须完全做到隔离。
 * AndroidManifest中设置application为此类，而SophixEntry中设为原先Application类。
 * 注意原先Application里不需要再重复初始化Sophix，并且需要避免混淆原先Application类。
 * 如有其它自定义改造，请咨询官方后妥善处理。
 */
public class SophixStubApplication extends SophixApplication {
    private final String TAG = "SophixStubApplication";
    // 此处SophixEntry应指定真正的Application，并且保证RealApplicationStub类名不被混淆。
    @Keep
    @SophixEntry(MyApplication.class)
    static class RealApplicationStub {}
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
//         如果需要使用MultiDex，需要在此处调用。
         MultiDex.install(this);
        initSophix();
    }
    private void initSophix() {
        String appVersion = "1.0.5";
        try {
            appVersion = this.getPackageManager()
                    .getPackageInfo(this.getPackageName(), 0)
                    .versionName;

        final SophixManager instance = SophixManager.getInstance();
        instance.setContext(this)
                .setAppVersion(appVersion)
                .setSecretMetaData("24810268","3a27bd2a8c01a2d5456698c38ca8ba9c","MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQC2xUtJG5g9EEAP+Y/F6GUvUDGNYAa6UxA8OzrDCCscSumTM8Rzl3FLXzqEw1UYD8OBu6e1diATL3f2FtcufmQa8byecGxU1PkCsBy4qAOC1zdTGus9mCyCUd5pJNi4JwDm9YyS0jn0MkNVQSX1vvYFD4S1AaluJKpDmm0UHIxMFBQ4m4COVTLhr2nhsuAI1BRd+CLz2MN/X4/I0XUw/ISHSaJavLVpB3w3YzOXxic3BhB65yRfYjPawzWhytRgfIwbJCFS5aNTH/Mp46n10YzUTv+Vb+HfxH/Oe7LoDkmDj3j28OtN9vqpl3Y4p9cqtgDwDCJuWxdlG+UKsOKFDDDDAgMBAAECggEACZUWeWLE/I6ZjTzcWNfyViSyNGNQdvxb4YyJbChFelpDHMCeECFkgzse6k8DaxuIeIjKJi1nSRo4A+L2rS1bOj5qUTQ7ucbgt09cciH87SMzd1v18WjFDKAWNRUFd8Izvegp0pjLCQ6JkTK1NskoROOnZYYMyAWMF7dE+MT2ZhagsyGcgX7eFjQEuf7A2u8Stcu1qjJwu2BPc3uOMokw4+JGTGfHFY80ODhex95e+YhFHeYharS0GS4uWc06EGJ7MWiodJ0CSsiIg9PYU4zwegz/BMJxzPtkkEeUa3syODr4wNs+TcPDFwdmXiYVM4ZWyZMfmVbrnZPo2rb1h3/J4QKBgQDjSdxPSfR68WcdJG001gvsQk4UEuHZ9QODZgv7xQfRBMgAYeMpXeXndK452jiPmPLHPcV/MHOIerXW8XrQd6+2Or5+lGnNdw+2bMHz0GlHD+vSnvlgOZVMSTMHpcTROiXmKfzVT/lWpniL/5QbEL8SEaKCSDhFPARJNxPuZZQzrQKBgQDN28yhY7d5RkDt0ZOJsb5/XQxx+knXhhwPrfJZrPhR+hMzzXtpE04m1XA1B2BhFjvq5w84C5ucVXOgQS6lnVw3CiGMTDuLXq8ifG8vfFXLDshsT3ZQ0QKuVGXSquvDupJUOqAbSAtJNLRq2kXZyKOc62IWbcV4Hv6xFq6ExygELwKBgEhS2m3IhKkSY9NcIfvsGIMnXhz5HTDzzBhlwm5s9d3G/bVRcK1bGasa782s6M6YxrgrqcqdKkZFddNdp8zqKNl9u9wfccNVnYRY+yaQLM/V+x5cQ9IgwKczq69FSmmhbSneNnvSJO8zrawuuXwbShF/1wxJ2s39GQgLJKZ5YD1JAoGBAJsUWWy/bSl8Rk+iUU4qy8Kw+z4l+ljVm/An72mlB5DiHnMo+i5nL7nLkvMv8mhRUqQcmvdyrzCvoyJ32EdFa4G/LRS/HSBaHP+S1EPmm88T/OKzXgN14VopFGgHAQN7Wt7/JzxGItJsVPomIvb00mTVYhhZa6iZWO9ZkfFPAxNbAoGAOWQJbwygIPI7HQ2Js9bBXAVgARq7MXZUQ96tzDyn5hFcF8Pr+ikADQ3dB5l8RsQEftiZhHzrt0GpvCS8fymKAvc8VwEtGQ7y4kJXwJVZyIloOFo0awa6KM/z+pbiXI8ue5op7cAhWKGnUmJtUgpglIPVfNdefxpHStTHpzpgZGc=")
                .setEnableDebug(true)
                .setEnableFullLog()
                .setPatchLoadStatusStub(new PatchLoadStatusListener() {
                    @Override
                    public void onLoad(final int mode, final int code, final String info, final int handlePatchVersion) {
                        Log.i("youtu",code+"");
                        if (code == PatchStatus.CODE_LOAD_SUCCESS) {
                            Log.i(TAG, "sophix load patch success!");
                        } else if (code == PatchStatus.CODE_LOAD_RELAUNCH) {
                            // 如果需要在后台重启，建议此处用SharePreference保存状态。
                            Log.i(TAG, "sophix preload patch success. restart app to make effect.");
                        }
                    }
                }).initialize();
        } catch (Exception e) {
        }
    }
}