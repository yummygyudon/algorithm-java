import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int N = inputs[0];
        int M = inputs[1];
        int A = inputs[2];
        int B = inputs[3];
        int SMALL = Math.min(A,B);
        int BIG = Math.max(A, B);

        int[] DP = new int[N + 1];

        for (int i = 0; i < M; i++) {
            int[] zone = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int k = zone[0]; k <= zone[1]; k++) {
                DP[k] = -1;
            }
        }
        for (int i = 1; i < BIG; i++) {
            if (i < SMALL) {
                DP[i] = -1;
            } else {
                if (DP[i - SMALL] == -1) {
                    DP[i] = -1;
                } else {
                    DP[i] = DP[i - SMALL] + 1;
                }
            }
        }
        for (int i = BIG; i <= N; i++) {
            if (DP[i] == -1) {
                continue;
            }
            if (DP[i - BIG] != -1 && DP[i - SMALL] != -1) {
                DP[i] = Math.min(DP[i - BIG], DP[i - SMALL]) + 1;
                continue;
            }
            if (DP[i - BIG] != -1) {
                DP[i] = DP[i - BIG] + 1;
                continue;
            }
            if (DP[i - SMALL] != -1) {
                DP[i] = DP[i - SMALL] + 1;
                continue;
            }
            DP[i] = -1;
        }
        System.out.println(DP[N]);
    }

}