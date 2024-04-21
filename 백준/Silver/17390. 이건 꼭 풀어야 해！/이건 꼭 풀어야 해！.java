import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
        int N = Integer.parseInt(tokenizer.nextToken());
        int Q = Integer.parseInt(tokenizer.nextToken());

        String[] inputNumbers = reader.readLine().split(" ");
        int[] numbers = new int[N+1];
        for (int n = 1; n < N+1; n++) {
            numbers[n] = Integer.parseInt(inputNumbers[n-1]);
        }
        Arrays.sort(numbers);
        for (int n = 1; n < N + 1; n++) {
            numbers[n] += numbers[n - 1];
        }
        for (int q = 0; q < Q; q++) {
            String[] aAndB = reader.readLine().split( " ");
            int a = Integer.parseInt(aAndB[0]);
            int b = Integer.parseInt(aAndB[1]);
            System.out.println(numbers[b] - numbers[a-1]);
        }
    }
}
