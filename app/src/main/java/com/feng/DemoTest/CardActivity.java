package com.feng.DemoTest;

import android.content.Context;
import android.graphics.Color;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Size;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.Toast;

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        header=new StoreHouseHeader(CardActivity.this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);
        header.setPadding(0, PtrLocalDisplay.dp2px(20), 0, PtrLocalDisplay.dp2px(20));
        header.initWithString("HOTDOOR", 50);
        header.setTextColor(Color.BLACK);
        ptrFrameLayout= (PtrFrameLayout) findViewById(R.id.store_house_ptr_frame);
        ptrFrameLayout.setHeaderView(header);
        ptrFrameLayout.addPtrUIHandler(header);
        ptrFrameLayout.setPtrHandler(new PtrHandler() {
            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout ptrFrameLayout, View cotent, View header) {
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
        });
        //ArrayList<Card> cards = new ArrayList<>();
        ArrayList<Card> cards=new ArrayList< >();
//        Card card = new Card(getApplicationContext(),R.layout.message_item);
        MyCard card=new MyCard(getApplicationContext(),R.layout.message_item);
        for (int i=0;i<1000;i++)
        {
            //Toast.makeText(CardActivity.this, ((int)Math.random() * 10)%6+"", Toast.LENGTH_SHORT).show();
            int[] ic={R.drawable.i1,R.drawable.i2,R.drawable.i3,R.drawable.i4,R.drawable.i5,R.drawable.i6};
            cards.add(makecard("2015年8月" + i + "日",
                    "1372625" + i,"This is a message you see for test hahahaha\n(╯‵□′)╯︵┻━┻  \n（╯－＿－）╯╧╧\n" + i,ic[i*10%6]));
        }
//        for (int i = 0; i < 30; i++) {
//            card.setDate("2015年8月" + i + "日");
//            card.setPhone("1372625" + i);
//            card.setIcon(android.R.drawable.ic_lock_idle_alarm);
//            card.setMessage("This is a message you see for test hahahaha\n(╯‵□′)╯︵┻━┻  \n（╯－＿－）╯╧╧\n" + i);
//            cards.add(card);
//        }
//        List<MessageItemBean> date=new ArrayList<>();
//        for (int i=0;i<30;i++)
//        {
//            date.add(new MessageItemBean("2015年8月"+i+"日",android.R.drawable.ic_lock_idle_alarm,"This is a message you see for test hahahaha\n(╯‵□′)╯︵┻━┻  \n（╯－＿－）╯╧╧\n"+i,"1372625"+i));
//        }
//
//        MyAdapter myAdapter=new MyAdapter(CardActivity.this,date);
        CardArrayAdapter adapter=new CardArrayAdapter(CardActivity.this,cards);
        CardListView cardListView = (CardListView) findViewById(R.id.cardlv);

        View head=getLayoutInflater().inflate(R.layout.header_main,cardListView,false);
        cardListView.addHeaderView(head);
        if(cardListView!=null)
        {
//            cardListView.setExternalAdapter(myAdapter,adapter);
            cardListView.setAdapter(adapter);
        }
        card.setOnClickListener(this);
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
}
