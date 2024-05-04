import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int[] dp = new int[N+1];
        while (N > 0) {
            if (N < 3) {
                System.out.println(-1);
                return;
            }
            if (N % 5 == 0) { // 5로 나눠지면 사실상 끝남
                dp[N - 5] = dp[N] + 1;
                N -= 5;
                continue;
            }
            dp[N - 3] = dp[N] + 1;
            N -= 3;
        }
        System.out.println(dp[0]);
    }

}