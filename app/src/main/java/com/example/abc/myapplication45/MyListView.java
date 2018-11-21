package com.example.abc.myapplication45;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;

public class MyListView extends ListView {

    private View headView;

    private View topBar;




    public MyListView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        headView= LayoutInflater.from(context).inflate(R.layout.head_layout,null);

        addHeaderView(headView);

        setOnScrollListener(new OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if(topBar!=null)
                {
                    int headTop=headView.getTop();//获取头部视图的高度

                    headTop=Math.abs(headTop);

                //alpha 0-255 0 全透明 255 不透明
                topBar.getBackground().setAlpha(headTop*(255/100));
                   }
                }

        });


    }

    public void setTopBar(View view)
    {
        this.topBar=view;
    }



}
