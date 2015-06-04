package ru.sergg.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by sergeygomanyuk on 16.04.15.
 */
public class Shoe extends AbstractBox {

    public static final int DECK_SIZE = 52;
    public static final int MAX_DECK_NUM = 8;
    public static final int MIN_DECK_NUM = 3;

    private final int maxCardNum;
    private final int minCardNum;

    public Shoe() {
        this(MAX_DECK_NUM*DECK_SIZE, MIN_DECK_NUM*DECK_SIZE);
    }

    public Shoe(int maxCardNum, int minCardNum) {
        this.maxCardNum = maxCardNum;
        this.minCardNum = minCardNum;
    }

    public int getMaxCardNum() {
        return maxCardNum;
    }

    public int getMinCardNum() {
        return minCardNum;
    }

    public void refillIfNeeded() {
        if(getCards().size() <= minCardNum) {
            fill();
        }
    }

    public void fill() {
        // set cards in order
        List<Card> cards = new ArrayList<Card>(maxCardNum);
        for(int i=0; i<maxCardNum; i++) {
            cards.add(new Card(i%DECK_SIZE));
        }
        // randomly remove ordered cards and put them into Shoe
        getCards().clear();
        Random random = new Random(System.currentTimeMillis());
        for(int i=maxCardNum; i>0; i--) {
            getCards().add(cards.remove(random.nextInt(i)));
        }
    }
}
