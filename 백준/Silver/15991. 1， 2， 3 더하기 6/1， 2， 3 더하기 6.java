import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(reader.readLine());
        long[] DP = new long[100_001];
        // 특수케이스인 1+1 & 2+2 & 3+3 까지는 지정해줘야함
        DP[1] = 1; // 자기자신
        DP[2] = 1 + 1; // 1+1 과 자기자신
        DP[3] = 1 + 1; // 1+1+1 과 자기자신
        DP[4] = DP[4 - (1 + 1)] + DP[4 - (2 + 2)] + 1; // 2 + 0 + 특수케이스(2+2) = 3
        DP[5] = DP[5 - (1 + 1)] + DP[5 - (2 + 2)]; // 2 + 1  = 3
        DP[6] = DP[6 - (1 + 1)] + DP[6 - (2 + 2)] + DP[6 - (3 + 3)] + 1; // 3 + 2 + 0 + 특수케이스 (3+3) =

        for (int i = 7; i < 100_001; i++) {
            DP[i] = (DP[i - (1 + 1)] + DP[i - (2 + 2)] + DP[i - (3 + 3)]) % 1_000_000_009;
        }

        for (int i = 0; i < TC; i++) {
            System.out.println(DP[Integer.parseInt(reader.readLine())]);
        }

    }
}
