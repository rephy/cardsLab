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

        String[] ranks = {
            "Two", "Three", "Four", "Five", "Six", "Seven",
            "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace"
        };

        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};

        int[] values = {2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11};

        String[] deckRanks = new String[52];
        String[] deckSuits = new String[52];
        int[] deckValues = new int[52];

        int index = 0;

        for (String suit : suits) {
            for (int i = 0; i < ranks.length; i++) {
                deckRanks[index] = ranks[i];
                deckSuits[index] = suit;
                deckValues[index] = values[i];
                index++;
            }
        }

        Deck testDeck = new Deck(deckRanks, deckSuits, deckValues);

        while (!testDeck.isEmpty()) {
            System.out.println(testDeck.deal());
        }
    }
}
