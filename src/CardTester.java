public class CardTester {
    public static void main(String[] args) {
        Card cardOne = new Card("Ace", "Spades", 11);
        Card cardTwo = new Card("Three", "Diamonds", 3);
        Card cardThree = new Card("Ace", "Spades", 11);

        System.out.println(cardOne.rank() + ", " + cardTwo.rank() + ", " + cardThree.rank());
        System.out.println(cardOne.suit() + ", " + cardTwo.suit() + ", " + cardThree.suit());
        System.out.println(cardOne.pointValue() + ", " + cardTwo.pointValue() + ", " + cardThree.pointValue());

        System.out.println();

        System.out.println(cardOne);
        System.out.println(cardTwo);
        System.out.println(cardThree);

        System.out.println();

        System.out.println(cardOne.matches(cardTwo));
        System.out.println(cardOne.matches(cardThree));
        System.out.println(cardTwo.matches(cardThree));
    }
}
