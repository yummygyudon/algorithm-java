import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());

        int MOD = 1_000_000_007;
        int[][] NUM_DP = new int[3][1516];
        // 1자리일 때
        NUM_DP[0][1] = 0;
        NUM_DP[1][1] = 0;
        NUM_DP[2][1] = 0;
        
        // 2자리일 때
        NUM_DP[0][2] = 1; // 15
        NUM_DP[1][2] = 1; // 55
        NUM_DP[2][2] = 0; // x

        for (int i = 2; i < N; i++) {
            NUM_DP[0][i + 1] = ((NUM_DP[Math.abs(3 + 3 - 1) % 3][i]) + (NUM_DP[Math.abs(3 + 3 - 5) % 3][i])) % MOD;
            NUM_DP[1][i + 1] = ((NUM_DP[Math.abs(3 + 4 - 1) % 3][i]) + (NUM_DP[Math.abs(3 + 4 - 5) % 3][i])) % MOD;
            NUM_DP[2][i + 1] = ((NUM_DP[Math.abs(3 + 5 - 1) % 3][i]) + (NUM_DP[Math.abs(3 + 5 - 5) % 3][i])) % MOD;
        }
        System.out.println(NUM_DP[0][N]);
    }
    
}