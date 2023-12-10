package lintott.stephen.card;

import lintott.stephen.deck.CardSuite;
import lintott.stephen.deck.CardValue;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
class CardAndSuiteTest {

    @Test
    void cardTranslation() {
        CardValue cardValue = CardValue.of(2);
        CardSuite suite = CardSuite.of(1);
        assertEquals("HEARTS",suite.toString());
        assertEquals("TWO",cardValue.toString());
        cardValue = CardValue.of(5);
        suite = CardSuite.of (4);
        assertEquals("FIVE",cardValue.toString());
        assertEquals("SPADES",suite.toString());
        cardValue = CardValue.of(3);
        suite = CardSuite.of (2);
        assertEquals("THREE",cardValue.toString());
        assertEquals("DIAMONDS",suite.toString());
        cardValue = CardValue.of(14);
        suite = CardSuite.of (3);
        assertEquals("ACE",cardValue.toString());
        assertEquals("CLUBS",suite.toString());
    }
}
