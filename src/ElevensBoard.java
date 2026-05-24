import java.util.ArrayList;

public class ElevensBoard {
    private Deck deck;
    private Card[] cards;

    public ElevensBoard() {
        String[] ranks = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
        String[] suits = {"Diamonds", "Hearts", "Spades", "Clubs"};
        int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0};

        deck = new Deck(ranks, suits, values);

        cards = new Card[9];
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
        for (int i = 0; i < 9; i++) {
            deal(i);
        }
    }

    public Card cardAt(int k) {
        return cards[k];
    }

    public boolean isLegal(int[] indexes) {
        if (indexes.length == 2 && containsPairSum11(indexes)) {
            return true;
        }

        return (indexes.length == 3 && containsJQK(indexes));
    }

    public boolean anotherPlayIsPossible() {
        int[] indexes = cardIndexes();

        return containsPairSum11(indexes) || containsJQK(indexes);
    }

    public boolean containsPairSum11(int[] indexes) {
        Card[] selectedCards = new Card[indexes.length];
        for (int i = 0; i < indexes.length; i++) {
            selectedCards[i] = cards[indexes[i]];
        }

        for (int i = 0; i < selectedCards.length; i++) {
            for (int j = i + 1; j < selectedCards.length; j++) {
                if (selectedCards[i].pointValue() + selectedCards[j].pointValue() == 11) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean containsJQK(int[] indexes) {
        boolean jackFound = false;
        boolean queenFound = false;
        boolean kingFound = false;

        Card[] selectedCards = new Card[indexes.length];
        for (int i = 0; i < indexes.length; i++) {
            selectedCards[i] = cards[indexes[i]];
        }

        for (Card card : selectedCards) {
            if (card.rank().equals("Jack")) {
                jackFound = true;
            } else if (card.rank().equals("Queen")) {
                queenFound = true;
            } else if (card.rank().equals("King")) {
                kingFound = true;
            }
        }

        if (jackFound && queenFound && kingFound) {
            return true;
        }

        return false;
    }

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

    private void replaceSelectedCards(int[] indexes) {
        for (int i : indexes) {
            deal(i);
        }
    }
}
