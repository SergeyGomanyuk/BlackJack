package ru.sergg.blackjack;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class ShoeTest {

    @Autowired
    private Shoe shoe;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testGetMaxCardNum() throws Exception {
        Assert.assertEquals(Shoe.MAX_DECK_NUM*Shoe.DECK_SIZE, shoe.getMaxCardNum());
    }

    @Test
    public void testGetMinCardNum() throws Exception {
        Assert.assertEquals(Shoe.MIN_DECK_NUM*Shoe.DECK_SIZE, shoe.getMinCardNum());
    }

    @Test
    public void testFill() throws Exception {
        shoe.fill();
        Assert.assertEquals(shoe.getMaxCardNum(), shoe.getCards().size());
        for(int i=1; i<shoe.getMaxCardNum()-shoe.getMinCardNum(); i++) {
            shoe.getCards().remove(0);
        }
        shoe.refillIfNeeded();
        Assert.assertEquals(shoe.getMinCardNum() + 1, shoe.getCards().size());
        shoe.getCards().remove(0);
        shoe.refillIfNeeded();
        Assert.assertEquals(shoe.getMaxCardNum(), shoe.getCards().size());
    }
}