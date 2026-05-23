import java.util.ArrayList;

public class Deck {
    private ArrayList<Card> deck;
    private ArrayList<Card> dealt;
    private int size;

    public Deck(String[] ranks, String[] suits, int[] pointValues) {
        int minLengthOne = Math.min(ranks.length, suits.length);
        int minLengthTwo = Math.min(pointValues.length, suits.length);
        int minLength = Math.min(minLengthOne, minLengthTwo);

        deck = new ArrayList<>();

        for (int i = 0; i < minLength; i++) {
            deck.add(new Card(ranks[i], suits[i], pointValues[i]));
            size++;
        }

        dealt = new ArrayList<>();

        shuffle();
    }

    public void shuffle() {
        return;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public Card deal() {
        if (isEmpty()) {
            return null;
        }

        Card dealtCard = deck.remove(size - 1);

        dealt.add(dealtCard);
        size--;

        return dealtCard;
    }
}
