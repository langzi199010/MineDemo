package com.example.administrator.minedemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.minedemo.tools.MyLogUtils;
import com.example.administrator.minedemo.tools.MyPermissions;
import com.yanzhenjie.permission.Action;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.Permission;
import com.yanzhenjie.permission.Rationale;
import com.yanzhenjie.permission.RequestExecutor;
import com.yanzhenjie.permission.SettingService;
import com.yanzhenjie.permission.setting.PermissionSetting;
import com.yanzhenjie.permission.source.AppActivitySource;


import java.util.List;

//申请权限demo
public class PermissionActivity extends AppCompatActivity {


    TextView quanxian;
    TextView quanxian2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //bbbbbbbbcccddeeff
        setContentView(R.layout.activity_permission);
        quanxian = (TextView) findViewById(R.id.quanxian);
        quanxian2 = (TextView) findViewById(R.id.quanxian2);


        set(MyPermissions.READ_EXTERNAL_STORAGE);
    }

    private void set(String permission) {
        //申请录音权限
        AndPermission.with(this)
                .permission(MyPermissions.READ_EXTERNAL_STORAGE)
                .onGranted(new Action() {
                    @Override
                    public void onAction(List<String> permissions) {
                        // TODO what to do.
                        //拥有权限了
                    }
                }).onDenied(new Action() {
            @Override
            public void onAction(List<String> permissions) {
                //拒绝权限了
                // TODO what to do
                if (AndPermission.hasAlwaysDeniedPermission(PermissionActivity.this, permissions)) {
                    //禁止后不再询问权限要引导用户去设置里面开启
                    // 这里使用一个Dialog展示没有这些权限应用程序无法继续运行，询问用户是否去设置中授权。
                    SettingService settingService = AndPermission.permissionSetting(PermissionActivity.this);

                    // 如果用户同意去设置：
                    settingService.execute();

                    // 如果用户不同意去设置：
                    settingService.cancel();
                }
            }
        }).start();

    }

    @Override
    protected void onResume() {
        super.onResume();
    }


}
