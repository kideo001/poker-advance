package lintott.stephen.deck;

public class Card {
    public int suit; //1=hearts, 2=diamonds, 3=clubs, 4=spades
    public int value;//2=2......11=jack,12=Queen,13=king,Ace=14
    public Card(int suit, int value){
        this.suit=suit;
        this.value=value;
    }

    public String toString() {
        String cardSuite = CardSuite.of(suit).toString();
        String cardValue = CardValue.of(value).toString();
        return cardValue + " of " + cardSuite;
    }

}
