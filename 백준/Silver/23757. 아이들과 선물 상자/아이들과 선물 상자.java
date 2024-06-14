import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader.readLine();
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (String input : reader.readLine().split(" ")) {
            queue.add(Integer.parseInt(input));
        }
        for (String input : reader.readLine().split(" ")) {
            int currentNeed = Integer.parseInt(input);
            int polled = queue.poll();
            if (currentNeed > polled) {
                System.out.println(0);
                return;
            }
            queue.add(polled - currentNeed);
        }
        System.out.println(1);
    }
}