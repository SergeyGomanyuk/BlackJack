package ru.sergg.blackjack;

/**
 * Created by sergeygomanyuk on 06.04.15.
 */
public class Card {

    public enum Rank { two, three, four, five, six, seven, eight, nine, ten, jack, lady, king, ace };
    public enum Suit { spades, clubs, diamonds, hearts };

    private final Rank rank;
    private final Suit suit;
    private final int index;

    public Card(int index) {
        assert index>=0 && index<=51;
        this.suit=Suit.values()[index / Rank.values().length];
        this.rank=Rank.values()[index % Rank.values().length];
        this.index = index;
    }

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
        this.index = suit.ordinal() * Rank.values().length + rank.ordinal();
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public int getIndex() {
        return index;
    }

    public int getPoints() {
        switch (rank) {
            case ace:
                return 1;
            case two:
                return 2;
            case three:
                return 3;
            case four:
                return 4;
            case five:
                return 5;
            case six:
                return 6;
            case seven:
                return 7;
            case eight:
                return 8;
            case nine:
                return 9;
            default:
                return 10;
        }
    }

    @Override
    public String toString() {
        return "Card{" +
                "index=" + index +
                ", rank=" + rank +
                ", suit=" + suit +
                '}';
    }
}
