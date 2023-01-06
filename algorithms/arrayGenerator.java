import java.util.*;

class arrayGenerator {
    public static ArrayList<Integer> generateRandom(int n) {
        ArrayList<Integer> list = new ArrayList<>();

        // Fill the vector with the values
        // 1, 2, 3, ..., n
        for (int i = 0; i < n; i++)
            list.add(i + 1);

        // While vector has elements
        // get a random number from the vector and print it
        Collections.shuffle(list);

        return list;

    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        ArrayList<Integer> list = arrayGenerator.generateRandom(n);

        System.out.println(list.toString());
        selectionSort.Sort(list);
        System.out.println(list.toString());

    }

}
