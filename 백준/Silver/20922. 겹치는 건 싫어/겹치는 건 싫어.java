import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] counts = new int[100001];
        int result = Integer.MIN_VALUE;

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
        int N = Integer.parseInt(tokenizer.nextToken());
        int K = Integer.parseInt(tokenizer.nextToken());

        tokenizer = new StringTokenizer(reader.readLine(), " ");
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(tokenizer.nextToken());
            numbers[i] = num;
        }
        int startIdx = 0, endIdx = 0;
        while (endIdx < N) {
            int endNumber = numbers[endIdx];
            counts[endNumber]++;
            while (counts[endNumber] > K) {
                int startNumber = numbers[startIdx];
                counts[startNumber]--;
                startIdx++;
            }
            result = Math.max(result, endIdx - startIdx + 1);
            endIdx++;
        }
        System.out.println(result);

    }
}
