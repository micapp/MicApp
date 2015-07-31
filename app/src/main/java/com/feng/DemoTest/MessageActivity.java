package com.feng.DemoTest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.poliveira.parallaxrecycleradapter.ParallaxRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MessageActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        List<String>mycontent=new ArrayList<String>();
        //MyParallaxAdapter adapter=new MyParallaxAdapter(mycontent);
        ParallaxRecyclerAdapter mAdpater=new ParallaxRecyclerAdapter(mycontent);
        RecyclerView myRecycler= (RecyclerView) findViewById(R.id.rv_message_main);
        LinearLayoutManager manager=new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        myRecycler.setLayoutManager(manager);
        myRecycler.setHasFixedSize(true);
        final List<String>content=new ArrayList<>();
        for(int i=0;i<30;i++)
        {
            content.add(getListString(i));
        }
        ParallaxRecyclerAdapter stringAdapter=new ParallaxRecyclerAdapter(content);
        stringAdapter.implementRecyclerAdapterMethods(new ParallaxRecyclerAdapter.RecyclerAdapterMethods() {
            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
                ((TextView)viewHolder.itemView).setText(content.get(i));
            }

            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
                return new SimpleViewHolder(getLayoutInflater().inflate(android.R.layout.simple_list_item_1,viewGroup,false));
            }

            @Override
            public int getItemCount() {
                return content.size();
            }
        });

        stringAdapter.setParallaxHeader(getLayoutInflater().inflate(R.layout.header_main, myRecycler, false), myRecycler);
        stringAdapter.setOnParallaxScroll(new ParallaxRecyclerAdapter.OnParallaxScroll() {
            @Override
            public void onParallaxScroll(float v, float v1, View view) {

            }
        });
        myRecycler.setAdapter(stringAdapter);


    }

    public String getListString(int position) {
        return position + " - android";
    }
    class SimpleViewHolder extends RecyclerView.ViewHolder{
        public SimpleViewHolder(View itemView) {
            super(itemView);
        }
    }
}
