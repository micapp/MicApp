package com.feng.DemoTest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Size;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.Toast;

import java.util.ArrayList;

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
        ArrayList<Card> cards = new ArrayList<>();
        Card card = new Card(getApplicationContext(),R.layout.message_item);
        card.setTitle("This is title");
        for (int i = 0; i < 30; i++) {
            cards.add(card);
        }

        CardArrayAdapter adapter=new CardArrayAdapter(CardActivity.this,cards);
        CardListView cardListView = (CardListView) findViewById(R.id.cardlv);
        View head=getLayoutInflater().inflate(R.layout.header_main,cardListView,false);
        cardListView.addHeaderView(head);
        if(cardListView!=null)
        {
            cardListView.setAdapter(adapter);
        }
        card.setOnClickListener(this);
    }

    @Override
    public void onClick(Card card, View view) {
        Toast.makeText(CardActivity.this,"you click",Toast.LENGTH_SHORT).show();
    }
}
