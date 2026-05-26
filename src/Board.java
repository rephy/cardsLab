import java.util.ArrayList;

public abstract class Board {
    private Deck deck;
    private Card[] cards;

    public Board(String[] ranks, String[] suits, int[] values, int boardSize) {
        deck = new Deck(ranks, suits, values);

        System.out.println(deck);

        cards = new Card[boardSize];
    }

    public void newGame() {
        deck.shuffle();
        dealMyCards();
    }

    public int size() {
        return cards.length;
    }

    public int deckSize() {
        return deck.size();
    }

    public void deal(int k) {
        cards[k] = deck.deal();
    }

    public void dealMyCards() {
        for (int i = 0; i < size(); i++) {
            deal(i);
        }
    }

    public Card cardAt(int k) {
        return cards[k];
    }

    public abstract boolean isLegal(int[] indexes);

    public abstract boolean anotherPlayIsPossible();

    public int[] cardIndexes() {
        ArrayList<Integer> listIndexes = new ArrayList<>();

        for (int i = 0; i < cards.length; i++) {
            if (cards[i] != null) {
                listIndexes.add(i);
            }
        }

        int size = listIndexes.size();
        int[] indexes = new int[size];
        for (int i = 0; i < size; i++) {
            indexes[i] = listIndexes.get(i);
        }

        return indexes;
    }

    public String toString() {
        String s = "";

        for (int k = 0; k < cards.length; k++) {
            s += k + ": " + cards[k] + "\n";
        }

        return s;
    }

    public boolean isEmpty() {
        for (Card card : cards) {
            if (card != null) {
                return false;
            }
        }

        return true;
    }

    public boolean gameIsWon() {
        return isEmpty() && deck.isEmpty();
    }

    public void replaceSelectedCards(int[] indexes) {
        for (int i : indexes) {
            deal(i);
        }
    }
}
