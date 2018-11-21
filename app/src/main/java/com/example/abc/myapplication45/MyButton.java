package com.example.abc.myapplication45;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;

/*
     自定义按钮
 */

public class MyButton extends android.support.v7.widget.AppCompatButton {


    public MyButton(final Context context, AttributeSet attrs) {
        super(context, attrs);

       setBackgroundResource(R.drawable.btn_selector);

       setText("提交");

       setTextSize(18);//定义自定义按钮的样式


       setOnClickListener(new OnClickListener() {
           @Override
           public void onClick(View v) {
               Toast.makeText(context,"我的第一个自定义控件",Toast.LENGTH_SHORT).show();
           }
       });//定义自定义按钮的单击事件


    }


}
