package com.feng.DemoTest;

import android.content.Context;
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

import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardArrayAdapter;
import it.gmariotti.cardslib.library.internal.CardHeader;
import it.gmariotti.cardslib.library.internal.CardThumbnail;
import it.gmariotti.cardslib.library.view.CardListView;

public class CardActivity extends AppCompatActivity implements Card.OnCardClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);
        //ArrayList<Card> cards = new ArrayList<>();
        ArrayList<Card> cards=new ArrayList< >();
//        Card card = new Card(getApplicationContext(),R.layout.message_item);
        MyCard card=new MyCard(getApplicationContext(),R.layout.message_item);
        for (int i = 0; i < 30; i++) {
            card.setDate("2015年8月" + i + "日");
            card.setPhone("1372625" + i);
            card.setIcon(android.R.drawable.ic_lock_idle_alarm);
            card.setMessage("This is a message you see for test hahahaha\n(╯‵□′)╯︵┻━┻  \n（╯－＿－）╯╧╧\n" + i);
            cards.add(card);
        }
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

    @Override
    public void onClick(Card card, View view) {
        Toast.makeText(CardActivity.this,"you click",Toast.LENGTH_SHORT).show();
    }
}
