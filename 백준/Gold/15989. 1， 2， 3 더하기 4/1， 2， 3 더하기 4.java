import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(reader.readLine());
        int[][] DP = new int[10001][3];

        DP[1][0] = 1;
        DP[2][0] = 1;
        DP[2][1] = 1;
        DP[3][0] = 1;
        DP[3][1] = 1;
        DP[3][2] = 1;

        for (int i = 4; i < 10001; i++) {
            DP[i][0] = DP[i - 1][0];
            DP[i][1] = DP[i - 2][0] + DP[i - 2][1];
            DP[i][2] = DP[i - 3][0] + DP[i - 3][1] + DP[i - 3][2];
        }
        for (int i = 0; i < TC; i++) {
            int num = Integer.parseInt(reader.readLine());
            System.out.println(DP[num][0] + DP[num][1] + DP[num][2]);
        }
    }
}
