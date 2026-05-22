public class Card {
    private String rank;
    private String suit;
    private int pointValue;

    public Card(String rank, String suit, int pointValue) {
        this.rank = rank;
        this.suit = suit;
        this.pointValue = pointValue;
    }

    public String rank() {
        return rank;
    }

    public String suit() {
        return suit;
    }

    public int pointValue() {
        return pointValue;
    }

    public boolean equals(Card other) {
        return rank().equals(other.rank()) && suit().equals(other.suit()) && pointValue() == other.pointValue();
    }

    @Override
    public String toString() {
        return rank() + " of " + suit() + " (point value = " + pointValue() + ")";
    }
}
