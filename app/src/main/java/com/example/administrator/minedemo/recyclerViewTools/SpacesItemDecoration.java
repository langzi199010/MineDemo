package com.example.administrator.minedemo.recyclerViewTools;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Administrator on 2018/3/7.
 */

public class SpacesItemDecoration extends RecyclerView.ItemDecoration {

    private int left_space,right_space,bottom_space,top_space;

    public SpacesItemDecoration(int left_space,int right_space,int bottom_space,int top_space){
        this.left_space = left_space;
        this.right_space = right_space;
        this.bottom_space = bottom_space;
        this.top_space = top_space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.left=left_space;
        outRect.right=right_space;
        outRect.bottom=bottom_space;
        outRect.top=top_space;

    }
}


