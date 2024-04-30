import java.util.*;
import java.io.*;
public class Main {

    static int M;
    static int N;
    static String[][] MAP;
    static boolean[][] CHECK;
    static int[][] MOVING = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1},
            {1, 1}, {1, -1}, {-1, 1}, {-1, -1}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] MN = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        M = MN[0]; N = MN[1];

        MAP = new String[M][N];
        for (int m = 0; m < M; m++) {
            String[] line = reader.readLine().split(" ");
            for (int n = 0; n < N; n++) {
                MAP[m][n] = line[n];
            }
        }

        int result = 0;
        for (int m = 0; m < M; m++) {
            for (int n = 0; n < N; n++) {
                if (MAP[m][n].equals("1")) {
                    MAP[m][n] = "0";
                    checking(m, n);
                    result++;
                }
            }
        }
        System.out.println(result);
    }

    static void checking(int y, int x) {
        for (int i = 0; i < 8; i++) {
            int nextY = y + MOVING[i][0];
            int nextX = x + MOVING[i][1];
            if (
                    (0 <= nextY && nextY < M)
                            && (0 <= nextX && nextX < N)
                            && (MAP[nextY][nextX].equals("1"))
            ) {
                MAP[nextY][nextX] = "0";
                checking(nextY, nextX);
            }
        }
    }

}