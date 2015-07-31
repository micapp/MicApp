package com.feng.DemoTest;

import android.support.v7.widget.RecyclerView;
import android.view.TextureView;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.poliveira.parallaxrecycleradapter.ParallaxRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fancy on 2015/7/31.
 */
public class MyParallaxAdapter implements ParallaxRecyclerAdapter.RecyclerAdapterMethods {
    List<String>list=new ArrayList<>();
    ViewHolder viewHolder;

    public MyParallaxAdapter(List<String> list) {
        this.list = list;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public int getItemCount() {
        return 0;
    }
    class ViewHolder{
        ImageView iconIV;
        TextureView phoneTV,dateTV,contentTV;
    }
}
