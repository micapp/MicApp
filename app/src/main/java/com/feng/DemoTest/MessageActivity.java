package com.feng.DemoTest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import com.github.ksoichiro.android.observablescrollview.ObservableScrollViewCallbacks;
import com.github.ksoichiro.android.observablescrollview.ScrollState;

import java.util.ArrayList;
import java.util.List;

public class MessageActivity extends AppCompatActivity implements ObservableScrollViewCallbacks{
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        listView= (ListView) findViewById(R.id.lv_message_main);
        View head=getLayoutInflater().inflate(R.layout.header_main,listView,false);
        listView.addHeaderView(head);
        //data
        List<MessageItemBean>date=new ArrayList<>();
        for (int i=0;i<30;i++)
        {
            date.add(new MessageItemBean("2015年8月"+i+"日",android.R.drawable.ic_lock_idle_alarm,"This is a message you see for test hahahaha\n(╯‵□′)╯︵┻━┻  \n（╯－＿－）╯╧╧\n"+i,"1372625"+i));
        }
        MyAdapter adapter=new MyAdapter(this,date);
        listView.setAdapter(adapter);

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