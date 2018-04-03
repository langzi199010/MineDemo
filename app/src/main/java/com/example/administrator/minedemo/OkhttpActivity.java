package com.example.administrator.minedemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.administrator.minedemo.okhttp.CommonBean;
import com.example.administrator.minedemo.okhttp.CommonBeans;
import com.example.administrator.minedemo.okhttp.GsonCommonCallback;
import com.example.administrator.minedemo.okhttp.GsonObjectCallback;
import com.example.administrator.minedemo.okhttp.OkHttpUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;

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
        getDataSuccess();
        getDataSuccesss();
    }


    private void getDataSuccess() {
        String url = "http://218.29.121.74:8081//v4/adpic/picinfo?adspace=mainAd&areaCode=41011";
        /**
         * get请求
         * 参数1 url
         * 参数2 回调Callback
         */
        OkHttpUtils.getInstance().doGet(url, new GsonObjectCallback<CommonBeans>() {

            //主线程处理
            @Override
            public void onUi(CommonBeans commonBeans) {

                if (commonBeans.isIsSuccess()) {
                    List<CommonBeans.ResultDataBean.ActivitylistBean> newslist = commonBeans.getResultData().getActivitylist();
                    okhttpTv.setText(newslist.get(0).getAdName());
                }

            }

            //请求失败
            @Override
            public void onFailed(Call call, IOException e) {

            }
        });
    }

    private void getDataSuccesss() {
        String url = "http://218.29.121.74:8081/user/personStat?memberId=1000000000243300";
        /**
         * get请求
         * 参数1 url
         * 参数2 回调Callback
         */
        OkHttpUtils.getInstance().doGet(url, new GsonCommonCallback<CommonBean>() {
            @Override
            public void onUi(CommonBean commonBean) {
                if (commonBean.isIsSuccess()) {

                    okhttpTv.setText("--");
                }
            }

            @Override
            public void onFailed(Call call, IOException e) {

            }
        });

    }


}