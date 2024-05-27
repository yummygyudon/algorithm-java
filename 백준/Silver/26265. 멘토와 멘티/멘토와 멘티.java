import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int quan = Integer.parseInt(reader.readLine());

        PriorityQueue<String[]> queue = new PriorityQueue<>(new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                if (o1[0].equals(o2[0])) {
                    return o2[1].compareTo(o1[1]);
                }
                return o1[0].compareTo(o2[0]);
            }
        });
        StringTokenizer tokenizer;
        for (int q = 0; q < quan; q++) {
            tokenizer = new StringTokenizer(reader.readLine(), " ");
            queue.add(new String[]{tokenizer.nextToken(), tokenizer.nextToken()});
        }
        for (int q = 0; q < quan; q++) {
            String[] poll = queue.poll();
            System.out.println(String.join(" ", poll[0], poll[1]));
        }
    }

}