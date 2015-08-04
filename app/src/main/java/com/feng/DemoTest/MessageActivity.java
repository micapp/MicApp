package com.feng.DemoTest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.baoyz.widget.PullRefreshLayout;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollViewCallbacks;
import com.github.ksoichiro.android.observablescrollview.ScrollState;

import java.util.ArrayList;
import java.util.List;

public class MessageActivity extends AppCompatActivity implements ObservableScrollViewCallbacks{
    PullRefreshLayout pullRefreshLayout;
    ListView listView;
    ImageView settingIV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        //new pull to refresh
        pullRefreshLayout= (PullRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        pullRefreshLayout.setRefreshStyle(PullRefreshLayout.STYLE_RING);
        //refresh
        listView= (ListView) findViewById(R.id.lv_message_main);
        View head=getLayoutInflater().inflate(R.layout.header_main,listView,false);
        settingIV= (ImageView) head.findViewById(R.id.iv_header_setting);
        listView.addHeaderView(head);
        //data
        List<MessageItemBean>date=new ArrayList<>();
        for (int i=0;i<30;i++)
        {
            date.add(new MessageItemBean("2015年8月"+i+"日",android.R.drawable.ic_lock_idle_alarm,"This is a message you see for test hahahaha\n(╯‵□′)╯︵┻━┻  \n（╯－＿－）╯╧╧\n"+i,"1372625"+i));
        }
        MyAdapter adapter=new MyAdapter(this,date);
        listView.setAdapter(adapter);
        settingIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MessageActivity.this,InfoActivity.class));
            }
        });


    }

    @Override
    public void onScrollChanged(int i, boolean b, boolean b1) {

    }

    @Override
    public void onDownMotionEvent() {

    }

    @Override
    public void onUpOrCancelMotionEvent(ScrollState scrollState) {
    }

}