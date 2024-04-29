import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] split = reader.readLine().split(" ");
        int A = Integer.parseInt(split[0]);
        int K = Integer.parseInt(split[1]);
        int[] dp = new int[K + 1];

        while (K > A) {
            if (K % 2 == 0 && (K / 2) >= A) {
                dp[K / 2] = dp[K] + 1;
                K = K / 2;
                continue;
            }
            dp[K - 1] = dp[K] + 1;
            K--;
        }
        System.out.println(dp[A]);
    }
}