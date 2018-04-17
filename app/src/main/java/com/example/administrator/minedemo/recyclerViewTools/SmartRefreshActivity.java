package com.example.administrator.minedemo.recyclerViewTools;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.minedemo.R;
import com.example.administrator.minedemo.recyclerViewTools.FeedRootRecyclerView;
import com.example.administrator.minedemo.recyclerViewTools.PageGridView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SmartRefreshActivity extends AppCompatActivity {


    @BindView(R.id.home_function_rv)
    FeedRootRecyclerView homeFunctionRv;
    @BindView(R.id.home_huodong_rv)
    PageGridView homeHuodongRv;
    @BindView(R.id.home_srf)
    SmartRefreshLayout homeSrf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //bbbbbbbbcccddeeff
        setContentView(R.layout.activity_smartrefresh);
        ButterKnife.bind(this);

        homeSrf.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                if (homeSrf.isRefreshing()) {
                    homeSrf.finishRefresh(3000, false);
                }

            }
        });
        homeSrf.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshLayout) {
                if (homeSrf.isLoading()) {
                    homeSrf.finishLoadMore(3000,false,false);
                }
            }
        });
    }


}
