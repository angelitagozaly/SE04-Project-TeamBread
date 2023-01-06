import java.util.*;

class arrayGenerator {
    ArrayList<Integer> list = new ArrayList<>();
    void generateRandom(int n) {
        list = new ArrayList<>(n);

        // Fill the vector with the values
        // 1, 2, 3, ..., n
        for (int i = 0; i < n; i++)
            list.add(i + 1);

        // While vector has elements
        // get a random number from the vector and print it
        Collections.shuffle(list);
    }

    // public static void main(String[] args) {
    //     arrayGenerator a = new arrayGenerator();
    //     int n = Integer.parseInt(args[0]);
    //     a.generateRandom(n);

    //     System.out.println(a.list.toString());
        
    // }

}