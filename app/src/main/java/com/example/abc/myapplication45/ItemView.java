package com.example.abc.myapplication45;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ItemView extends RelativeLayout {

    @BindView(R.id.tv_leftText)
    TextView tvLeftText;
    @BindView(R.id.tv_rightText)
    TextView tvRightText;
    @BindView(R.id.iv_arrow)
    ImageView ivArrow;
    @BindView(R.id.rl)
    RelativeLayout rl;


    public ItemView(Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater.from(context).inflate(R.layout.item_layout, this);
        ButterKnife.bind(this);//在自定义view中使用bufferknife时需要加上这行代码，不然获取不到控件实例报空指针异常，而且这行代码要写在上一行代码的后面，不然会绑定不了控件


        //自定义属性
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ItemView);//获取自定义属性列表

        String tvLeftText = typedArray.getString(R.styleable.ItemView_leftText);//获取xml布局文件里设置的属性

        String tvRightText = typedArray.getString(R.styleable.ItemView_rightText);

        boolean isShowArrow = typedArray.getBoolean(R.styleable.ItemView_isShowArrow, false);

        setItemViewStyle(tvLeftText, tvRightText, isShowArrow);//将属性放入自定义函数里跟新UI

        typedArray.recycle();//回收自定义属性列表
    }


    /*
        自定义函数为自定义view设置ui参数
     */
    public void setItemViewStyle(String leftText, String rightText, boolean isShowArrow) {

        if (leftText != null) {
            tvLeftText.setText(leftText);
        }

        if (rightText != null) {
            tvRightText.setText(rightText);
        }

        if (isShowArrow) {
            ivArrow.setVisibility(View.VISIBLE);
        } else {
            ivArrow.setVisibility(View.GONE);
        }
    }


    public void setOnItemViewClickListener(OnClickListener listener) {
            rl.setOnClickListener(listener);
    }

    public String getLeftText()
    {
        return tvLeftText.getText().toString();
    }

    public String getRightText()
    {
        return tvRightText.getText().toString();
    }
}
