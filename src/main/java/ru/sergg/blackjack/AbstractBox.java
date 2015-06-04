package ru.sergg.blackjack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sergeygomanyuk on 16.04.15.
 */
public abstract class AbstractBox {
    private List<Card> cards = new ArrayList<Card>();

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "cards=" + cards +
                '}';
    }
}
