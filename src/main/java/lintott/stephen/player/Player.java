package lintott.stephen.player;

import lintott.stephen.deck.Card;

public class Player {
    public Card[] hand;
    public int rank;
    public Player(Card[] hand) {
        this.hand = hand;
    }
}
