package com.example.abc.myapplication45;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity {

    @BindView(R.id.btn_tijiao)
    MyButton btnTijiao;
    @BindView(R.id.item1)
    ItemView item1;
    @BindView(R.id.item2)
    ItemView item2;
    @BindView(R.id.item3)
    ItemView item3;
    @BindView(R.id.mylistview)
    MyListView mylistview;
    @BindView(R.id.topview)
    LinearLayout topview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        mylistview.setTopBar(topview);
        mylistview.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return 50;
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                TextView textView = new TextView(MainActivity.this);
                textView.setText(position + "");
                return textView;
            }
        });

    }


    @OnClick({R.id.item1, R.id.item2, R.id.item3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.item1:
                Toast.makeText(this, item1.getRightText(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.item2:
                Toast.makeText(this, item2.getRightText(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.item3:
                Toast.makeText(this, item3.getRightText(), Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
