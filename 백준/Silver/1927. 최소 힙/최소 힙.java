import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new PriorityQueue<>();

        int N = Integer.parseInt(reader.readLine());
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(reader.readLine());
            if (input == 0) {
                if (queue.isEmpty()) {
                    result.append(0);
                } else {
                    result.append(queue.poll());
                }
                result.append("\n");
                continue;
            }
            queue.add(input);
        }
        System.out.println(result);
    }
}