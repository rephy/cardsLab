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
        for (int i = 0; i < dealt.size(); i++) {
            deck.add(dealt.remove(0));
            size++;
        }

        Shuffler shuffler = new Shuffler(size, 3);
        int[] newIndices = shuffler.shuffle();

        ArrayList<Card> newDeck = new ArrayList<>();

        for (int index : newIndices) {
            newDeck.add(deck.get(index));
        }

        deck = newDeck;
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
