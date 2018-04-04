package com.example.administrator.minedemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.administrator.minedemo.okgo.OkUtil;
import com.example.administrator.minedemo.okgo.bean.ResponseBean;
import com.example.administrator.minedemo.okgo.bean.SimpleBean;
import com.example.administrator.minedemo.okgo.callbck.DialogCallback;
import com.example.administrator.minedemo.okgo.callbck.JsonCallback;
import com.lzy.okgo.model.Response;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Haoz on 2017/4/6 0006.
 */

public class OkhttpActivity extends AppCompatActivity {

    @BindView(R.id.okhttp_tv)
    TextView okhttpTv;
    @BindView(R.id.okhttp_tv2)
    TextView okhttpTv2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp);
        ButterKnife.bind(this);
        getRequest();
    }


    private void getRequest() {
        OkUtil.getRequets("http://218.29.121.74:8081/user/personStat?memberId=1000000000243300", this, new HashMap<String, String>(), new JsonCallback<ResponseBean<SimpleBean>>() {
            @Override
            public void onSuccess(Response<ResponseBean<SimpleBean>> response) {

                okhttpTv.setText(response.body().resultData.getHabby());
            }
        });
//        OkUtil.getRequets("http://218.29.121.74:8081/user/personStat?memberId=1000000000243300", this, new HashMap<String, String>(), new DialogCallback<Object>() {
//
//            @Override
//            public void onSuccess(Response<Object> response) {
//                okhttpTv2.setText(response.body().toString());
//            }
//        });
        OkUtil.getRequets("http://218.29.121.74:8081/user/personStat?memberId=1000000000243300", this, new HashMap<String, String>(), new DialogCallback(OkhttpActivity.this) {
            @Override
            public void onSuccess(Response response) {
                okhttpTv2.setText(response.body().toString());
            }

        });
    }

}