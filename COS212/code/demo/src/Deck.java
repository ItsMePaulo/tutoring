import java.util.ArrayList;
import java.util.StringJoiner;

public class Deck {

    private final ArrayList<Card> cards;

    public Deck() {
        cards = new ArrayList<>();

        for (Suit suit : Suit.values()) {
            for (Number number : Number.values()) {
                cards.add(new Card(suit, number));
            }
        }
    }


    /**
     * Output should look something like this:
     * <p>
     * [A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠],
     * [A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣],
     * [A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥],
     * [A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦]
     * </p>
     */
    public void print() {
        ArrayList<String> cardRows = new ArrayList<>();

        for (int i = 0; i < 52; ) {
            // ["hello", "world"] => "Hello,World"
            StringJoiner joiner = new StringJoiner(", ", "[", "]");

            for (int j = 0; j < 13; i++, j++) {
                joiner.add(cards.get(i).toString());
            }
            System.out.println("Added row");
            cardRows.add(joiner.toString());
        }

        System.out.println(String.join(",\n", cardRows));
    }

}
