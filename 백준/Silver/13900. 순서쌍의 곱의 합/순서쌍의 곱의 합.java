import java.io.*;
import java.util.*;


public class Main {

    static int N;
    static long RESULT = 0L;
    static long[] NUMBERS;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());
        NUMBERS = new long[N];

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
        for (int i = 0; i < N; i++) {
            NUMBERS[i] = Long.parseLong(tokenizer.nextToken());
        }
        long sum = 0L;
        for (int i = 0; i < N; i++) {
            sum += NUMBERS[i];
        }
        for (int i = 0; i < N; i++) {
            sum -= NUMBERS[i];
            RESULT += NUMBERS[i] * sum;
        }
        System.out.println(RESULT);
    }
}