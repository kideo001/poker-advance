package lintott.stephen.deck;

import java.util.ArrayList;
import java.util.List;

public class Deck {
    private Card[] deck = new Card[52];

    public Deck() {
        this.init();
    }

    public Card getNextCard(int index) {
        return deck[index];
    }

    public void shuffel() {
        // shuffel on odds and evens;
        int counter = 0;
        int reverseCounter = 51;
        //First swap out cards from the back of the deck with the front of the deck
        while (counter < 52) {
            Card c1 = deck[counter];
            Card c2 = deck[reverseCounter];
            deck[counter] = c2;
            deck[reverseCounter] = c1;
            counter++;
            reverseCounter--;
        }
        //Swap out odd and even cards
        for (int i = 0; i < deck.length; i+=2) {
            Card c1 = deck[i];
            Card c2 = deck[i+1];
            deck[i] = c2;
            deck[i+1] = c1;
        }


        List<Integer> handled = new ArrayList<Integer>();

        // Do 26 random swaps throughout the deck
        while (handled.size()<26) {
            int i1 = (int)Math.round(Math.random()*51);
            int i2 = (int)Math.round(Math.random()*51);
            while (i1 == i2) {
                i2 = (int)Math.round(Math.random()*51);
            }
            Card c1 = deck[i1];
            Card c2 = deck[i2];
            deck[i1] = c2;
            deck[i2] = c1;
            handled.add(i1);
            handled.add(i2);
        }
    }

    private void init() {
        CardSuite [] cardSuites = CardSuite.values();
        CardValue [] cardValues = CardValue.values();
        int counter = 0;
        for (int i = 0; i < cardSuites.length; i++) {
            for (int j = 0; j < cardValues.length; j++) {
                Card card = new Card(i+1,j+2);
                this.deck[counter++] = card;
            }
        }
    }


}
