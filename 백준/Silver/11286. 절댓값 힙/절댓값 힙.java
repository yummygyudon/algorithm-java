import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int commandCount = Integer.parseInt(reader.readLine());
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (Math.abs(o1) == Math.abs(o2)) {
                    return o1 - o2;
                } else {
                    return Math.abs(o1) - Math.abs(o2);
                }
            }
        });
        for (int i = 0; i < commandCount; i++) {
            int input = Integer.parseInt(reader.readLine());
            if (input == 0) {
                Integer polledValue = heap.poll();
                System.out.println(polledValue == null? 0 : polledValue);
                continue;
            }
            heap.add(input);
        }
    }
}