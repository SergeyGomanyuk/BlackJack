package ru.sergg.blackjack;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sergeygomanyuk on 06.04.15.
 */
public class Table {

    private static final int DEFAULT_MAX_STAKE = 100;
    private static final int DEFAULT_MIN_STAKE = 1;


    private final int minStake;
    private final int maxStake;

    private Shoe shoe = new Shoe();
    private Box dealerBox;
    private Map<Player, List<Box>> playerBoxes = new LinkedHashMap<Player, List<Box>>();

    public Table() {
        this(DEFAULT_MIN_STAKE, DEFAULT_MAX_STAKE);
    }

    public Table(int minStake, int maxStake) {
        this.minStake = minStake;
        this.maxStake = maxStake;
    }

    public int getMinStake() {
        return minStake;
    }

    public int getMaxStake() {
        return maxStake;
    }

    public void turn() {
        // check if shoe needs to be refilled and shuffled - 4-8x52 cards, (90-25)% cards are left
        shoe.refillIfNeeded();

        // stakes
        doStakes();
//
//        // deal cards face up - 1 to each player, 1 to dealer, 1 to each player
//        for(Box box : table.getPlayerBoxes()) {
//            box.addCard(shoe.getCard());
//        }
//        table.getDealerBox().addCard(shoe.getCard());
//        for(Box box : table.getPlayerBoxes()) {
//            box.addCard(shoe.getCard());
//        }
//        // (two dealer cards enabled) 1 to dealer face down
//        if(twoDealerCardsEnabled) table.getDealerBox().addCard(shoe.getCard());


        // (insurance enabled) ace at dealer box
        // for each player's box:
        //   check blackjack at payer's box :
        //     blackjack - ask player to win 1:1, if yes player paid wins 1:1 and out of game
        //     other - ask player to pay insurance up to half of stake

        // (two dealer cards enabled) check for dealer's blackjack:
        //     blackjack: all players in game:
        //         player has blackjack - draw, else main stake goes to dealer;
        //         player has insurance  - player paid 2:1 of insurance stake;
        //         next turn
        //     not blackjack: all insurance stakes go to dealer

        // for each player's box:
        //    player has two cards with same value:
        //       ask player for split: player can recursively split  up to 4 boxes; aces can be splitted only once and player takes only one card to each ace)
        //    do ask player for doubles (only at start), hits or stand
        //    while not bust or player choose stand
        //    if bust player loose his stake

        // dealer draws up to soft or hard 17

        // check win condition
        // if dealer bust all players in game win 1:1
        // else if dealer has the same combination as player then player get his stake back (blackjack can be equal to blackjack only)
        // else if player has blackjack he win 3:2
        // else if dealer has less points than player then player wins 1:1
        // else player loose his stake
    }

    protected void doStakes() {
        for (Player player : playerBoxes.keySet()) {
            // check if player can pay a stake at the table
            if (player.getCoins() < getMinStake()) {
                removePlayer(player);
            } else {
                //   player pays a stake from range allowed at table (min - max stake)
                addPlayerStakes(player, player.getStakes());
            }
        }
    }

    private void addPlayerStakes(Player player, int[] stakes) {
        if(!playerBoxes.containsKey(player)) {
            throw new IllegalArgumentException("There is no " + player + " at the table");
        }
        List<Box> boxes = new ArrayList<Box>(stakes.length);
        for(int stake: stakes) {
            if(stake < minStake || stake > maxStake) {
                throw new IllegalArgumentException(player + " stake:" + stake + " is either greater than maxStake:" + maxStake + " or lower than minStake:" + minStake);
            }
            Box box = new Box();
            box.setStake(stake);
            boxes.add(box);
        }
        playerBoxes.put(player, boxes);
    }

    public void removePlayer(Player player) {
        playerBoxes.remove(player);
    }

    public void setPlayers(Player[] players) {
        playerBoxes.clear();
        for(Player player : players) {
            playerBoxes.put(player, new ArrayList<Box>());
        }
    }

    public Shoe getShoe() {
        return shoe;
    }

    public Player[] getPlayers() {
        return playerBoxes.keySet().toArray(new Player[0]);
    }
}
