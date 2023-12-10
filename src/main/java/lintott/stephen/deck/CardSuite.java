package lintott.stephen.deck;

public enum CardSuite {
    SPADES(4),
    DIAMONDS(2),
    HEARTS(1),
    CLUBS(3);

    private int value;
    private CardSuite(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static CardSuite of(int value) {
        for (int i=0;i<CardSuite.values().length;i++) {
            if (value == CardSuite.values()[i].getValue()) {
                return CardSuite.values()[i];
            }
        }
        throw new RuntimeException("Invalid suite specified. " + value);
    }

}
