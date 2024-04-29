import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int MOD = 9901;

        int[][] dp = new int[N+1][2];
        int[] cases = new int[N + 1];
        dp[1][0] = 1;
        dp[1][1] = 1;
        cases[1] = 1;

        if (N > 1) {
            for (int i = 2; i < N + 1; i++) {
                cases[i] = dp[i - 1][0] + dp[i - 1][0] + cases[i - 1];
                for (int k = 0; k < 2; k++) {
                    if (k == 0) { // 왼쪽 Case
                        dp[i][k] = (dp[i - 1][1] + cases[i - 1]) % MOD;
                    }
                    if (k == 1) { // 오른쪽 Case
                        dp[i][k] = (dp[i - 1][0] + cases[i - 1]) % MOD;
                    }
                }
            }
        }
        System.out.println((cases[N] + dp[N][0] + dp[N][1])%MOD);

    }

}