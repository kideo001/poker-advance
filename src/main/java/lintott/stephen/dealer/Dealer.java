package lintott.stephen.dealer;

import lintott.stephen.deck.Card;
import lintott.stephen.deck.Deck;

import java.util.ArrayList;
import java.util.List;

public class Dealer {
    public Deck deck = new Deck();


    public void shuffel() {
        deck.shuffel();
    }
    public List<Card[]> deal(int numberOfPlayers) {
        List<Card []> hands = new ArrayList<Card []>();
        for (int i = 0;i < numberOfPlayers;i++) {
            hands.add(new Card[5]);
        }
        int counter = 0;
        for (int j=0;j< 5;j++) {
            for (int i = 0; i < hands.size(); i++) {
                Card [] cards = hands.get(i);
                cards[j] = deck.getNextCard(counter++);
            }
        }
        return hands;
    }
}
