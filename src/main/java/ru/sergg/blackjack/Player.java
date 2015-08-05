package ru.sergg.blackjack;

/**
 * Created by sergeygomanyuk on 06.04.15.
 */
public abstract class Player {
    private int coins;

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public int[] getStakes() {
        // TODO implement
        return new int[0];
    }

    public abstract boolean askForInsurance();
}
