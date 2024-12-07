import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Long> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int lineCount = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer;

        for (int i = 0; i < lineCount; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < lineCount; j++) {
                pq.add(Long.parseLong(tokenizer.nextToken()));
            }
        }
        for (int i = 0; i < lineCount-1; i++){
            pq.poll();
        }
        System.out.println(pq.poll());

    }
}