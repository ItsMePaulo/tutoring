public class Card {

    private final Suit suit;
    private final Number number;

    public Card(Suit s, Number n) {
        suit = s;
        number = n;
    }

    @Override
    public String toString() {
        return number.displayName + suit.symbol;
    }
}
