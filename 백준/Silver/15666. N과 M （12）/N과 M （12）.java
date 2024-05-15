import java.util.*;
import java.io.*;


public class Main {
    
    static int N;
    static int M;
    static int[] NUMBERS;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nAndM = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        N = nAndM[0];
        M = nAndM[1];

        NUMBERS = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .distinct().sorted()
                .toArray();
        for (int i = 0; i < NUMBERS.length; i++) {
            int[] ints = new int[M];
            ints[0] = NUMBERS[i];
            dfs(1, ints);
        }
    }

    static void dfs(int depth, int[] nums) {
        if (depth == M) {
            Arrays.stream(nums).forEach(num -> System.out.printf("%d ", num));
            System.out.println();
            return;
        }
        for (int i = 0; i < NUMBERS.length; i++) {
            if (nums[depth-1] <= NUMBERS[i]) {
                nums[depth] = NUMBERS[i];
                dfs(depth+1, nums);
            }
        }
    }
    
}