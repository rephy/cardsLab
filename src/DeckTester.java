public class DeckTester {
    public static void main(String[] args) {
        Deck deckOne = new Deck(new String[]{"Ace", "Five", "Queen"}, new String[]{"Hearts", "Spades", "Diamonds"}, new int[]{11, 5, 10});
        Deck deckTwo = new Deck(new String[]{"Six", "Three", "Jack"}, new String[]{"Spades", "Spades", "Clubs"}, new int[]{6, 3, 10});
        Deck deckThree = new Deck(new String[]{"Two", "Two", "Ace"}, new String[]{"Diamonds", "Clubs", "Hearts"}, new int[]{2, 2, 1});

        int minLengthOne = Math.min(deckOne.size(), deckTwo.size());
        int minLengthTwo = Math.min(deckOne.size(), deckThree.size());
        int minLength = Math.min(minLengthOne, minLengthTwo);

        for (int i = 0; i < minLength; i++) {
            System.out.println(deckOne.size() + ", " + deckTwo.size() + ", " + deckThree.size());
            System.out.println(deckOne.deal() + ", " + deckTwo.deal() + ", " + deckThree.deal());

            System.out.println();
        }
    }
}
