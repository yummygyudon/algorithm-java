import java.io.*;
import java.util.*;

public class Main {
    static int MAX = Integer.MIN_VALUE;
    static int N;
    static int[] NUMBERS;
    static int[] TEMPLATE;
    static boolean[] CHECK;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());
        TEMPLATE = new int[N];
        CHECK = new boolean[N];
        NUMBERS = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        for (int i = 0; i < N; i++) {
            int[] numbers = new int[N];
            CHECK[i] = true;
            numbers[0] = NUMBERS[i];
            dfs(1, numbers);
            CHECK[i] = false;
        }
        System.out.println(MAX);
    }

    static void dfs(int idx, int[] numbers) {
        if (idx == N) {
            check(numbers);
        }
        for (int i = 0; i < N; i++) {
            if (!CHECK[i]) {
                CHECK[i] = true;
                numbers[idx] = NUMBERS[i];
                dfs(idx+1,numbers);
                CHECK[i] = false;
            }
        }
    }

    static void check(int[] numbers) {
        int result = 0;
        for (int i = 0; i < N-1; i++) {
            result += Math.abs(numbers[i] - numbers[i + 1]);
        }
        MAX = Math.max(MAX, result);
    }
}