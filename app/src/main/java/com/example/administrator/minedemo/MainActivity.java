package com.example.administrator.minedemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.minedemo.recyclerViewTools.SmartRefreshActivity;
import com.example.administrator.minedemo.recyclerViewTools.SmartRefreshActivity2;
import com.example.administrator.minedemo.tools.NetWorkUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.main_quanxian)
    TextView mainQuanxian;
    @BindView(R.id.main_dialog)
    TextView mainDialog;
    @BindView(R.id.smart_refresh)
    TextView smart_refresh;
    @BindView(R.id.smart_refresh2)
    TextView smart_refresh2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //bbbbbbbbcccddeeff
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mainQuanxian.setText(NetWorkUtils.cesh());
    }

    @OnClick({R.id.main_quanxian, R.id.main_dialog,R.id.main_okhttp,R.id.smart_refresh,R.id.smart_refresh2})
    public void onViewClicked(View view) {
        Intent intent=null;
        switch (view.getId()) {
            case R.id.main_quanxian:
                intent=new Intent(MainActivity.this, PermissionActivity.class);
                startActivity(intent);
                break;
            case R.id.main_dialog:
                intent=new Intent(MainActivity.this, DialogActivity.class);
                startActivity(intent);
                break;
            case R.id.main_okhttp:
                intent=new Intent(MainActivity.this, OkhttpActivity.class);
                startActivity(intent);
                break;
            case R.id.smart_refresh:
                //gif动画类型的 刷新
                intent=new Intent(MainActivity.this, SmartRefreshActivity.class);
                startActivity(intent);
                break;
            case R.id.smart_refresh2:
                intent=new Intent(MainActivity.this, SmartRefreshActivity2.class);
                startActivity(intent);
                break;
        }
    }
}
