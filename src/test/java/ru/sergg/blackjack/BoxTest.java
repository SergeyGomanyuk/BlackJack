package ru.sergg.blackjack;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class BoxTest {

    @Autowired
    private Box box;

    @Before
    public void setUp() throws Exception {
        box.getCards().clear();
        Assert.assertEquals(0, box.getPoints(true));
        Assert.assertEquals(0, box.getPoints(false));
        Assert.assertFalse(box.isBlackjack());
    }

    private void checkBox(int hardPoints, int softPoints, boolean isBlackjack, boolean isBusted) {
        Assert.assertEquals(hardPoints, box.getPoints(false));
        Assert.assertEquals(softPoints, box.getPoints(true));
        Assert.assertEquals(isBlackjack, box.isBlackjack());
        Assert.assertEquals(isBusted, box.isBusted());
    }

    @Test
    public void testGetPoints() throws Exception {
        box.getCards().add(CardTest.ace_clubs);
        checkBox(1, 11, false, false);

        box.getCards().add(CardTest.ace_hearts);
        checkBox(2, 12, false, false);

        box.getCards().add(CardTest.ten_spades);
        checkBox(12, 22, false, false);

        box.getCards().add(CardTest.eight_spades);
        checkBox(20, 30, false, false);

        box.getCards().add(CardTest.ace_clubs);
        checkBox(21, 31, false, false);

        box.getCards().add(CardTest.five_diamonds);
        checkBox(26, 36, false, true);
    }

    @Test
    public void testIsBlackjack() throws Exception {
        box.getCards().add(CardTest.ace_hearts);
        checkBox(1, 11, false, false);

        box.getCards().add(CardTest.ten_spades);
        checkBox(11, 21, true, false);

        box.getCards().clear();

        box.getCards().add(CardTest.ten_spades);
        checkBox(10, 10, false, false);

        box.getCards().add(CardTest.ace_clubs);
        checkBox(11, 21, true, false);
    }

}