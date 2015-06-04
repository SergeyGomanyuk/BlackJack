package ru.sergg.blackjack;

import static org.junit.Assert.*;

public class TableTest {

    // check if shoe needs to be refilled and shuffled - 4-8x52 cards, (90-25)% cards are left

    // for each player:
    // check if player can pay a stake at the table
    //   player pays a stake from range allowed at table (min - max stake)

    // deal cards face up - 1 to each player, 1 to dealer, 1 to each player
    // (two dealer cards enabled) 1 to dealer face down


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

    // condition - behaviour:
    // player has less coins than min allowed stake - player shall be removed
    // player
}