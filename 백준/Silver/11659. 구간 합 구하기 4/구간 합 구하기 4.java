import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());

        int[] nums = new int[N+1];
        nums[0] = 0;
        tokenizer = new StringTokenizer(reader.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(tokenizer.nextToken()) + nums[i-1];
        }

        for (int k = 0; k < M; k++) {
            tokenizer = new StringTokenizer(reader.readLine(), " ");
            int start = Integer.parseInt(tokenizer.nextToken());
            int end = Integer.parseInt(tokenizer.nextToken());
            System.out.println(nums[end] - nums[start-1]);
        }
    }
}