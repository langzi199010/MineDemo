package com.example.administrator.minedemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.minedemo.tools.LogUtils;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.PermissionListener;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView ceshi0, ceshi1, ceshi2, ceshi3;
    String permissions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       //asdfasdf
        setContentView(R.layout.activity_main);
        ceshi0 = (TextView) findViewById(R.id.ceshi0);
        ceshi1 = (TextView) findViewById(R.id.ceshi1);
        ceshi2 = (TextView) findViewById(R.id.ceshi2);
        ceshi3 = (TextView) findViewById(R.id.ceshi3);
        ceshi1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                set();
            }
        });

    }

    private void set() {
        //申请录音权限
        AndPermission.with(this)
                .requestCode(100)
                .permission(android.Manifest.permission.CALL_PHONE)
                .callback(listener)
                // rationale作用是：用户拒绝一次权限，再次申请时先征求用户同意，再打开授权对话框；
                // 这样避免用户勾选不再提示，导致以后无法申请权限。
                // 你也可以不设置。
                .rationale((requestCode, rationale) ->
                        // 这里的对话框可以自定义，只要调用rationale.resume()就可以继续申请。
                        AndPermission.rationaleDialog(this, rationale).show()
                )
                .start();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
    private PermissionListener listener = new PermissionListener() {
        @Override
        public void onSucceed(int requestCode, List<String> grantedPermissions) {
            // 权限申请成功回调。

            // 这里的requestCode就是申请时设置的requestCode。
            // 和onActivityResult()的requestCode一样，用来区分多个不同的请求。
            if(requestCode == 100) {
                // TODO ...
                if(AndPermission.hasPermission(MainActivity.this, grantedPermissions)) {
                    // TODO 执行拥有权限时的下一步。
                } else {
                    // 使用AndPermission提供的默认设置dialog，用户点击确定后会打开App的设置页面让用户授权。
                    AndPermission.defaultSettingDialog(MainActivity.this, 200).show();

                    // 建议：自定义这个Dialog，提示具体需要开启什么权限，自定义Dialog具体实现上面有示例代码。
                }
            }
        }

        @Override
        public void onFailed(int requestCode, List<String> deniedPermissions) {
            // 权限申请失败回调。
            if(requestCode == 100) {
                LogUtils.i("222");
                // TODO ...
                // 是否有不再提示并拒绝的权限。

                if(AndPermission.hasPermission(MainActivity.this, deniedPermissions)) {
                    // TODO 执行拥有权限时的下一步。
                } else {
                    // 使用AndPermission提供的默认设置dialog，用户点击确定后会打开App的设置页面让用户授权。
                    AndPermission.defaultSettingDialog(MainActivity.this, 200).show();

                    // 建议：自定义这个Dialog，提示具体需要开启什么权限，自定义Dialog具体实现上面有示例代码。
                }
            }
        }
    };
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 200: { // 这个400就是上面defineSettingDialog()的第二个参数。
                // 你可以在这里检查你需要的权限是否被允许，并做相应的操作。
                set();
                break;
            }
        }
    }
}
