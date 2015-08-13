package com.feng.DemoTest;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Parcelable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Size;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.Toast;

import com.melnykov.fab.ScrollDirectionListener;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;
import in.srain.cube.views.ptr.header.StoreHouseHeader;
import in.srain.cube.views.ptr.util.PtrLocalDisplay;
import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardArrayAdapter;
import it.gmariotti.cardslib.library.internal.CardHeader;
import it.gmariotti.cardslib.library.internal.CardThumbnail;
import it.gmariotti.cardslib.library.view.CardListView;

public class CardActivity extends AppCompatActivity implements Card.OnCardClickListener{
    private PtrFrameLayout ptrFrameLayout;
    private StoreHouseHeader header;
    ImageView settingIV;
    com.melnykov.fab.FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        header=new StoreHouseHeader(CardActivity.this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);


        header.setPadding(0, PtrLocalDisplay.dp2px(20), 0, PtrLocalDisplay.dp2px(20));
        header.initWithString("HOTDOOR", 50);
        header.setTextColor(Color.GRAY);
        header.setLineWidth(4);
        ptrFrameLayout= (PtrFrameLayout) findViewById(R.id.store_house_ptr_frame);
        ptrFrameLayout.setHeaderView(header);
        ptrFrameLayout.addPtrUIHandler(header);
        ptrFrameLayout.setPtrHandler(new MyPtrHandler());
        ArrayList<Card> cards=new ArrayList< >();
        MyCard card=new MyCard(getApplicationContext(),R.layout.message_item);
        for (int i=0;i<1000;i++)
        {
            //Toast.makeText(CardActivity.this, ((int)Math.random() * 10)%6+"", Toast.LENGTH_SHORT).show();
            int[] ic={R.drawable.i1,R.drawable.i2,R.drawable.i3,R.drawable.i4,R.drawable.i5,R.drawable.i6};
            cards.add(makecard("2015年8月" + i + "日",
                    "1372625" + i,"This is a message you see for test hahahaha\n(╯‵□′)╯︵┻━┻  \n（╯－＿－）╯╧╧\n" + i,ic[i*10%6]));
        }
        CardArrayAdapter adapter=new CardArrayAdapter(CardActivity.this,cards);
        final CardListView cardListView = (CardListView) findViewById(R.id.cardlv);

        View head=getLayoutInflater().inflate(R.layout.header_main,cardListView,false);
        settingIV= (ImageView) head.findViewById(R.id.iv_header_setting);
        settingIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CardActivity.this,InfoActivity.class));
            }
        });
        cardListView.addHeaderView(head);
        if(cardListView!=null)
        {
            cardListView.setAdapter(adapter);
        }
        card.setOnClickListener(this);


        //fab
        fab= (com.melnykov.fab.FloatingActionButton) findViewById(R.id.fab_card);
        fab.attachToListView(cardListView, new ScrollDirectionListener() {
            @Override
            public void onScrollDown() {
                Log.d("ListViewFragment", "onScrollDown()");
                Log.d ("cardPostion = ",cardListView.getFirstVisiblePosition()+"");
                if (cardListView.getFirstVisiblePosition()<1)
                {
                    fab.setImageResource(R.drawable.ic_refresh_white_48dp);
                    fab.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ptrFrameLayout.autoRefresh();
                        }
                    });
                }
                else {
                    fab.setImageResource(R.drawable.ic_keyboard_arrow_up_white_48dp);
                    fab.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            cardListView.smoothScrollToPositionFromTop(0,0,300);
                        }
                    });
                }
            }

            @Override
            public void onScrollUp() {
                Log.d("ListViewFragment", "onScrollUp()");
            }
        });
        //fab
    }

    private MyCard makecard(String Date,String Phone,String Message,int Icon) {
        MyCard newCard=new MyCard(CardActivity.this,R.layout.message_item);
        newCard.setDate(Date);
        newCard.setPhone(Phone);
        newCard.setIcon(Icon);
        newCard.setMessage(Message);
        return newCard;
    }

    @Override
    public void onClick(Card card, View view) {
        Toast.makeText(CardActivity.this,"you click",Toast.LENGTH_SHORT).show();
    }

    class MyPtrHandler implements PtrHandler{
        @Override
        public boolean checkCanDoRefresh(PtrFrameLayout ptrFrameLayout,View cotent, View header) {
            return PtrDefaultHandler.checkContentCanBePulledDown(ptrFrameLayout,cotent,header);
        }

        @Override
        public void onRefreshBegin(final PtrFrameLayout ptrFrameLayout) {
            ptrFrameLayout.postDelayed(new Runnable() {
                @Override
                public void run() {
                    ptrFrameLayout.refreshComplete();
                }
            }, 1800);
        }
    }
}
