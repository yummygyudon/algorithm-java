import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
        int N = Integer.parseInt(tokenizer.nextToken()), X = Integer.parseInt(tokenizer.nextToken());
        tokenizer = new StringTokenizer(reader.readLine(), " ");
        int[] sums = new int[250001];
        for (int i = 1; i < N + 1; i++) {
            sums[i] = sums[i - 1] + Integer.parseInt(tokenizer.nextToken());
        }
        int maxValue = Integer.MIN_VALUE;
        int[] visits = new int[250001];
        for (int i = 0; i <= N - X; i++) {
            visits[i] = sums[i + X] - sums[i];
            maxValue = Math.max(maxValue, visits[i]);
        }
        if (maxValue == 0) {
            System.out.println("SAD");
        } else {
            int result = 0;
            for (int value : visits) {
                if (value == maxValue) {
                    result++;
                }
            }
            System.out.println(maxValue);
            System.out.println(result);            
        }
    }
}