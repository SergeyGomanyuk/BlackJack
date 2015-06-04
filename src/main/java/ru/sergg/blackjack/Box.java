package ru.sergg.blackjack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sergeygomanyuk on 06.04.15.
 */
public class Box extends AbstractBox {

    private int stake;

    public int getPoints(boolean soft) {
        int points = 0;
        for(Card card : getCards()) {
            points += card.getPoints();
            if(card.getPoints() == 1 && soft && points <= 11) points += 10;
        }
        return points;
    }

    public boolean isBlackjack() {
        return getCards().size() == 2 && getPoints(true) == 21;
    }

    public boolean isBusted() {
        return getPoints(false) > 21;
    }

    public void setStake(int stake) {
        this.stake = stake;
    }

    public int getStake() {
        return stake;
    }
}
