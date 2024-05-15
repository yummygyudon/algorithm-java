import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int[] NUMBERS;
    static StringBuilder BUILDER = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());
        NUMBERS = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        Arrays.sort(NUMBERS);

        dfs(0, new int[M]);
        System.out.println(BUILDER);
    }

    static void dfs(int depth, int[] nums) {
        if (depth == M) {
            for (int num : nums) {
                BUILDER.append(String.valueOf(num)).append(" ");
            }
            //System.out.println(joiner);
            BUILDER.append("\n");
            return;
        }
        for (int i = 0; i < N; i++) {
            nums[depth] = NUMBERS[i];
            dfs(depth+1, nums);
        }
    }


}