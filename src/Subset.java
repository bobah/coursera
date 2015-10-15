import edu.princeton.cs.algs4.StdIn;

public class Subset {

    public static void main(String[] args) {

        int count = Integer.parseInt(args[0]);

        String[] input = StdIn.readAllStrings();

        RandomizedQueue<String> queue = new RandomizedQueue<>();
        for (String s : input) {
            queue.enqueue(s);
        }

        for (int i = 0; i < count; i++) {
            String res = queue.dequeue();
            System.out.println(res);
        }
    }
}
