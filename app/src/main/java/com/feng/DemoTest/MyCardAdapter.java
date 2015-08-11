package com.feng.DemoTest;

import android.content.Context;

import java.util.List;

import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardArrayAdapter;

/**
 * Created by Fancy on 2015/8/10.
 */
public class MyCardAdapter extends CardArrayAdapter {
    public MyCardAdapter(Context context, List<Card> cards) {
        super(context, cards);
    }
}
