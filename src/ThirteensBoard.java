public class ThirteensBoard extends Board {
    public ThirteensBoard() {
        super(new String[]{"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"},
                new String[]{"Diamonds", "Hearts", "Spades", "Clubs"},
                new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 0}, 10);
    }

    public boolean isLegal(int[] indexes) {
        if (indexes.length == 2 && containsPairSum13(indexes)) {
            return true;
        }

        return (indexes.length == 1 && containsK(indexes));
    }

    public boolean anotherPlayIsPossible() {
        int[] indexes = cardIndexes();

        return containsPairSum13(indexes) || containsK(indexes);
    }

    private boolean containsPairSum13(int[] indexes) {
        Card[] selectedCards = new Card[indexes.length];
        for (int i = 0; i < indexes.length; i++) {
            selectedCards[i] = cardAt(indexes[i]);
        }

        for (int i = 0; i < selectedCards.length; i++) {
            for (int j = i + 1; j < selectedCards.length; j++) {
                if (selectedCards[i].pointValue() + selectedCards[j].pointValue() == 13) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean containsK(int[] indexes) {
        Card[] selectedCards = new Card[indexes.length];
        for (int i = 0; i < indexes.length; i++) {
            selectedCards[i] = cardAt(indexes[i]);
        }

        for (Card card : selectedCards) {
            if (card.rank().equals("King")) {
                return true;
            }
        }

        return false;
    }
}
