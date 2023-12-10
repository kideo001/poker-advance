package lintott.stephen.deck;

public enum CardValue {
    ACE(14),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(11),
    QUEEN(12),
    KING(13);

    private int value = 0;
    private CardValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    public static CardValue of(int value){
        for (int i=0;i< CardValue.values().length;i++) {
            if (value == CardValue.values()[i].getValue()) {
                return CardValue.values()[i];
            }
        }
        throw new RuntimeException("Invalid card value specified. "+ value);
    }
}
