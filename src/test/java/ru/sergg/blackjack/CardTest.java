package ru.sergg.blackjack;

import org.junit.Assert;
import org.junit.Test;


public class CardTest {

    public static final Card ace_hearts = createCard(Card.Rank.ace, Card.Suit.hearts);
    public static final Card ace_clubs = createCard(Card.Rank.ace, Card.Suit.clubs);
    public static final Card two_spades = createCard(Card.Rank.two, Card.Suit.spades);
    public static final Card three_clubs = createCard(Card.Rank.three, Card.Suit.clubs);
    public static final Card four_clubs = createCard(Card.Rank.four, Card.Suit.clubs);
    public static final Card five_diamonds = createCard(Card.Rank.five, Card.Suit.diamonds);
    public static final Card six_clubs = createCard(Card.Rank.six, Card.Suit.clubs);
    public static final Card seven_clubs = createCard(Card.Rank.seven, Card.Suit.clubs);
    public static final Card eight_spades = createCard(Card.Rank.eight, Card.Suit.spades);
    public static final Card nine_clubs = createCard(Card.Rank.nine, Card.Suit.clubs);
    public static final Card ten_spades = createCard(Card.Rank.ten, Card.Suit.spades);
    public static final Card jack_diamonds = createCard(Card.Rank.jack, Card.Suit.diamonds);
    public static final Card lady_clubs = createCard(Card.Rank.lady, Card.Suit.clubs);
    public static final Card king_hearts = createCard(Card.Rank.king, Card.Suit.hearts);

    public static Card createCard(Card.Rank rank, Card.Suit suit) {
        return new Card(suit.ordinal() * Card.Rank.values().length + rank.ordinal());
    }

    @Test
    public void testGetRank() throws Exception {
        Assert.assertEquals(Card.Rank.ace, ace_hearts.getRank());
        Assert.assertEquals(Card.Rank.ace, ace_clubs.getRank());
        Assert.assertEquals(Card.Rank.two, two_spades.getRank());
        Assert.assertEquals(Card.Rank.three, three_clubs.getRank());
        Assert.assertEquals(Card.Rank.four, four_clubs.getRank());
        Assert.assertEquals(Card.Rank.five, five_diamonds.getRank());
        Assert.assertEquals(Card.Rank.six, six_clubs.getRank());
        Assert.assertEquals(Card.Rank.seven, seven_clubs.getRank());
        Assert.assertEquals(Card.Rank.eight, eight_spades.getRank());
        Assert.assertEquals(Card.Rank.nine, nine_clubs.getRank());
        Assert.assertEquals(Card.Rank.ten, ten_spades.getRank());
        Assert.assertEquals(Card.Rank.jack, jack_diamonds.getRank());
        Assert.assertEquals(Card.Rank.lady, lady_clubs.getRank());
        Assert.assertEquals(Card.Rank.king, king_hearts.getRank());
    }

    @Test
    public void testGetSuit() throws Exception {
        Assert.assertEquals(Card.Suit.hearts, ace_hearts.getSuit());
        Assert.assertEquals(Card.Suit.clubs, ace_clubs.getSuit());
        Assert.assertEquals(Card.Suit.spades, two_spades.getSuit());
        Assert.assertEquals(Card.Suit.clubs, three_clubs.getSuit());
        Assert.assertEquals(Card.Suit.clubs, four_clubs.getSuit());
        Assert.assertEquals(Card.Suit.diamonds, five_diamonds.getSuit());
        Assert.assertEquals(Card.Suit.clubs, six_clubs.getSuit());
        Assert.assertEquals(Card.Suit.clubs, seven_clubs.getSuit());
        Assert.assertEquals(Card.Suit.spades, eight_spades.getSuit());
        Assert.assertEquals(Card.Suit.clubs, nine_clubs.getSuit());
        Assert.assertEquals(Card.Suit.spades, ten_spades.getSuit());
        Assert.assertEquals(Card.Suit.diamonds, jack_diamonds.getSuit());
        Assert.assertEquals(Card.Suit.clubs, lady_clubs.getSuit());
        Assert.assertEquals(Card.Suit.hearts, king_hearts.getSuit());
    }

    @Test
    public void testGetPoints() throws Exception {
        Assert.assertEquals(1, ace_hearts.getPoints());
        Assert.assertEquals(1, ace_clubs.getPoints());
        Assert.assertEquals(2, two_spades.getPoints());
        Assert.assertEquals(3, three_clubs.getPoints());
        Assert.assertEquals(4, four_clubs.getPoints());
        Assert.assertEquals(5, five_diamonds.getPoints());
        Assert.assertEquals(6, six_clubs.getPoints());
        Assert.assertEquals(7, seven_clubs.getPoints());
        Assert.assertEquals(8, eight_spades.getPoints());
        Assert.assertEquals(9, nine_clubs.getPoints());
        Assert.assertEquals(10, ten_spades.getPoints());
        Assert.assertEquals(10, jack_diamonds.getPoints());
        Assert.assertEquals(10, lady_clubs.getPoints());
        Assert.assertEquals(10, king_hearts.getPoints());
    }
}