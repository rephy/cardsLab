import java.util.ArrayList;

public class Shuffler {
    private final int VALUE_COUNT;
    private final int SHUFFLE_COUNT;

    public Shuffler(int VALUE_COUNT, int SHUFFLE_COUNT) {
        this.VALUE_COUNT = VALUE_COUNT;
        this.SHUFFLE_COUNT = SHUFFLE_COUNT;
    }

    public int[] shuffle() {
        int[] shuffled = new int[VALUE_COUNT];
        ArrayList<Integer> range = new ArrayList<>();

        for (int i = 0; i < VALUE_COUNT; i++) {
            range.add(i);
        }

        for (int i = 0; i < SHUFFLE_COUNT; i++) {
            int j = 0;

            while (range.size() > 0) {
                int randIndex = (int) (Math.random() * range.size());
                shuffled[j] = range.remove(randIndex);
                j++;
            }

            if (i < SHUFFLE_COUNT - 1) {
                for (int k = 0; k < VALUE_COUNT; k++) {
                    range.add(shuffled[k]);
                    shuffled[k] = 0;
                }
            }
        }

        return shuffled;
    }

    public static void main(String[] args) {
        Shuffler shufflerOne = new Shuffler(5, 1);
        Shuffler shufflerTwo = new Shuffler(3, 3);
        Shuffler shufflerThree = new Shuffler(4, 4);

        for (int num : shufflerOne.shuffle()) {
            System.out.println(num);
        }

        System.out.println();

        for (int num : shufflerTwo.shuffle()) {
            System.out.println(num);
        }

        System.out.println();

        for (int num : shufflerThree.shuffle()) {
            System.out.println(num);
        }
    }
}
