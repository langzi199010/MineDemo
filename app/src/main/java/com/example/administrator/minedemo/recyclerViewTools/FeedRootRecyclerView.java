package com.example.administrator.minedemo.recyclerViewTools;

/**
 * Created by Administrator on 2018/3/25.
 */

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
//RecyclerView 应该只拦截垂直滚动事件，所以可以这么修改父 RecyclerView：
//解决竖向滑动大控件  与横向滑动RecyclerView之间的滑动冲突
public class FeedRootRecyclerView extends BetterRecyclerView {
    public FeedRootRecyclerView(Context context) {
        this(context,null);
    }


    public FeedRootRecyclerView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }


    public FeedRootRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }


    //这个接口的作用是不允许父类打断这个onTouch 事件，
    //那么设置一个空的函数，override 父类的方法，就可以达到相反的效果
    @Override
    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
//        super.requestDisallowInterceptTouchEvent(disallowIntercept);
    }
}