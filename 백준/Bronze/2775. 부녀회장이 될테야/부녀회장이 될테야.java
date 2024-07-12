import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(reader.readLine());
            int n = Integer.parseInt(reader.readLine());
            int[][] apart = new int[k+1][n+1];
            for (int j = 1; j < n + 1; j++) {
                apart[0][j] = apart[0][j - 1] + 1;
            }
            for (int j = 1; j < k + 1; j++) {
                for (int p = 1; p < n + 1; p++) {
                    apart[j][p] = apart[j][p - 1] + apart[j - 1][p];
                }
            }
            System.out.println(apart[k][n]);
        }

    }

}