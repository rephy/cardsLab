import java.util.ArrayList;

public class ElevensBoard extends Board {
    public ElevensBoard() {
        super(new String[]{"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"},
                new String[]{"Diamonds", "Hearts", "Spades", "Clubs"},
                new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0}, 9);
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

    private boolean containsPairSum11(int[] indexes) {
        Card[] selectedCards = new Card[indexes.length];
        for (int i = 0; i < indexes.length; i++) {
            selectedCards[i] = cardAt(indexes[i]);
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

    private boolean containsJQK(int[] indexes) {
        boolean jackFound = false;
        boolean queenFound = false;
        boolean kingFound = false;

        Card[] selectedCards = new Card[indexes.length];
        for (int i = 0; i < indexes.length; i++) {
            selectedCards[i] = cardAt(indexes[i]);
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
}
