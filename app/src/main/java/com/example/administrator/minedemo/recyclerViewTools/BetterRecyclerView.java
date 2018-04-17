package com.example.administrator.minedemo.recyclerViewTools;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewConfigurationCompat;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

import java.lang.reflect.Field;

/**
 * Created by Administrator on 2018/3/25.
 */
//修复垂直滑动RecyclerView嵌套水平滑动RecyclerView水平滑动不灵敏问题
public class BetterRecyclerView extends RecyclerView {
    private int touchSlop;
    private Context mContext;
    private int INVALID_POINTER = -1;
    private int scrollPointerId = INVALID_POINTER;
    private int initialTouchX;
    private int initialTouchY;
    private final static String TAG = "BetterRecyclerView";


    public BetterRecyclerView(Context context) {
//        super(context);
        this(context, null);
    }


    public BetterRecyclerView(Context context, @Nullable AttributeSet attrs) {
//        super(context, attrs);
        this(context, attrs, 0);
    }


    public BetterRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        ViewConfiguration vc = ViewConfiguration.get(context);
        touchSlop = vc.getScaledEdgeSlop();
        mContext = context;
    }


    @Override
    public void setScrollingTouchSlop(int slopConstant) {
        super.setScrollingTouchSlop(slopConstant);
        ViewConfiguration vc = ViewConfiguration.get(mContext);
        switch (slopConstant) {
            case TOUCH_SLOP_DEFAULT:
                touchSlop = vc.getScaledTouchSlop();
                break;
            case TOUCH_SLOP_PAGING:
                touchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(vc);
                break;


        }
    }


    @Override
    public boolean onInterceptTouchEvent(MotionEvent e) {
        //isScrolling 为 true 表示是 Fling 状态
        boolean isScrolling = getScrollState() == SCROLL_STATE_SETTLING;
        boolean ans = super.onInterceptTouchEvent(e);
        if (ans && isScrolling && e.getAction() == MotionEvent.ACTION_DOWN) {
            //先调用 onTouchEvent() 使 RecyclerView 停下来
            onTouchEvent(e);
            //反射恢复 ScrollState
            try {
                Field field = RecyclerView.class.getDeclaredField("mScrollState");
                field.setAccessible(true);
                field.setInt(this, SCROLL_STATE_IDLE);
            } catch (NoSuchFieldException e1) {
                e1.printStackTrace();
            } catch (IllegalAccessException e1) {
                e1.printStackTrace();
            }
            return false;
        }
        return ans;
    }
}