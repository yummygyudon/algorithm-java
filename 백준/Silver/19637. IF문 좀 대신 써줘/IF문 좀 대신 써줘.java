import java.util.*;
import java.io.*;
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine(), " ");
        int N = Integer.parseInt(stringTokenizer.nextToken()), M = Integer.parseInt(stringTokenizer.nextToken());

        String[][] TITLE_BOARD = new String[N][2];
        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(reader.readLine(), " ");
            TITLE_BOARD[i][0] = stringTokenizer.nextToken();
            TITLE_BOARD[i][1] = stringTokenizer.nextToken();
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int strength = Integer.parseInt(reader.readLine());
            int left = 0, right = N - 1;

            while (left <= right) {
                int middle = (left + right) / 2;

                if (strength > Integer.parseInt(TITLE_BOARD[middle][1])) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }

            builder.append(TITLE_BOARD[left][0]).append("\n");
        }
        System.out.print(builder);
    }

}