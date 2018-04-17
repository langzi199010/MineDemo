package com.example.administrator.minedemo.recyclerViewTools;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.minedemo.R;
import com.example.administrator.minedemo.recyclerViewTools.header.MyRefreshAnimHeader;
import com.example.administrator.minedemo.recyclerViewTools.header.MyRefreshLottieHeader;
import com.scwang.smartrefresh.header.FunGameBattleCityHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SmartRefreshActivity2 extends AppCompatActivity {


    @BindView(R.id.hear_anim)
    TextView hear_anim;
    @BindView(R.id.hear_dra)
    TextView hear_dra;
    @BindView(R.id.home_function_rv2)
    FeedRootRecyclerView homeFunctionRv2;
    @BindView(R.id.home_huodong_rv2)
    PageGridView homeHuodongRv2;
    @BindView(R.id.home_srf2)
    SmartRefreshLayout homeSrf2;
    MyRefreshLottieHeader mRefreshLottieHeader;
    MyRefreshAnimHeader mRefreshAnimHeader;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //bbbbbbbbcccddeeff
        setContentView(R.layout.activity_smartrefresh2);
        ButterKnife.bind(this);
        mRefreshLottieHeader = new MyRefreshLottieHeader(this);
        mRefreshAnimHeader = new MyRefreshAnimHeader(this);
        hear_anim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRefreshLottieHeader.setAnimationViewJson("anim1.json");
                setHeader(mRefreshLottieHeader);
                homeSrf2.autoRefresh();
            }
        });
        hear_dra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setHeader(mRefreshAnimHeader);
                homeSrf2.autoRefresh();
            }
        });
        homeSrf2.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                if (homeSrf2.isRefreshing()) {
                    homeSrf2.finishRefresh(3000, false);
                }

            }
        });
        homeSrf2.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshLayout) {
                if (homeSrf2.isLoading()) {
                    homeSrf2.finishLoadMore(3000, false, false);
                }
            }
        });
    }
    /**
     * 设置刷新header风格
     * @param header
     */
    private void setHeader(RefreshHeader header) {
        if (homeSrf2.isRefreshing()){
            homeSrf2.finishRefresh();
        }
        homeSrf2.setRefreshHeader(header);
    }

}
