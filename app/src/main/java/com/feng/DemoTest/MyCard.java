package com.feng.DemoTest;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import it.gmariotti.cardslib.library.internal.Card;

/**
 * Created by Fancy on 2015/8/11.
 */
public class MyCard extends Card {
        public String Date,Message,Phone;
        public int Icon;

    public MyCard(Context context) {
        super(context);
    }

    public MyCard(Context context, int innerLayout) {
        super(context, innerLayout);
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public int getIcon() {
        return Icon;
    }

    public void setIcon(int icon) {
        Icon = icon;
    }

    @Override
    public void setupInnerViewElements(ViewGroup parent, View view) {
        ImageView iconIV= (ImageView) parent.findViewById(R.id.iv_message_icon);
        TextView messageTV= (TextView) parent.findViewById(R.id.tv_message_content);
        TextView phoneTV= (TextView) parent.findViewById(R.id.tv_message_phone);
        TextView dateTV= (TextView) parent.findViewById(R.id.tv_message_date);
        iconIV.setImageResource(getIcon());
        messageTV.setText(getMessage());
        phoneTV.setText(getPhone());
        dateTV.setText(getDate());
    }
}
