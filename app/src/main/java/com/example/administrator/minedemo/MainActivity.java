package com.example.administrator.minedemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.minedemo.tools.MyPermissions;

import java.security.acl.Permission;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.main_quanxian)
    TextView mainQuanxian;
    @BindView(R.id.main_dialog)
    TextView mainDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //bbbbbbbbcccddeeff
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


    }

    @OnClick({R.id.main_quanxian, R.id.main_dialog})
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
        }
    }
}
