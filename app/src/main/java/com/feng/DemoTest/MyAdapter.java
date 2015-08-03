package com.feng.DemoTest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by fancy on 2015/8/3.
 */
public class MyAdapter extends BaseAdapter{
    Context context;
    LayoutInflater mInflater;
    List<MessageItemBean> messageItemBeanList;

    public MyAdapter(Context context, List<MessageItemBean> messageItemBeanList) {
        this.context = context;
        this.messageItemBeanList = messageItemBeanList;
        mInflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return messageItemBeanList.size();
    }

    @Override
    public Object getItem(int position) {
        return messageItemBeanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView==null)
        {
            viewHolder=new ViewHolder();
            convertView=mInflater.inflate(R.layout.message_item,null);
            viewHolder.phoneTV= (TextView) convertView.findViewById(R.id.tv_message_phone);
            viewHolder.contentTV= (TextView) convertView.findViewById(R.id.tv_message_content);
            viewHolder.dateTV= (TextView) convertView.findViewById(R.id.tv_message_date);
            viewHolder.iconIV= (ImageView) convertView.findViewById(R.id.iv_message_icon);
            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        MessageItemBean bean=messageItemBeanList.get(position);
        viewHolder.dateTV.setText(bean.getDate());
        viewHolder.iconIV.setBackgroundResource(bean.getIcon());
        viewHolder.contentTV.setText(bean.getMessage());
        viewHolder.phoneTV.setText(bean.getPhone());
        return convertView;
    }
}
class ViewHolder{
    public TextView phoneTV,dateTV,contentTV;
    public ImageView iconIV;
}
