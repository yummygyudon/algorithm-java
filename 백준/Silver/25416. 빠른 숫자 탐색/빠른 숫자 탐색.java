import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[][] BOARD = new int[5][5];
        boolean[][] VISITED = new boolean[5][5];
        int[][] MOVING = {{1,0}, {0,1}, {-1,0}, {0,-1}};
        int[] TARGET_POS = new int[2];

        for (int i = 0; i < 5; i++) {
            String[] line = reader.readLine().split(" ");
            for (int k = 0; k < 5; k++) {
                int value = Integer.parseInt(line[k]);
                BOARD[i][k] = value;
                if (value == 1) {
                    TARGET_POS[0] = i;
                    TARGET_POS[1] = k;
                }
            }
        }
        String[] START_POS = reader.readLine().split(" ");
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{Integer.parseInt(START_POS[0]), Integer.parseInt(START_POS[1]), 0});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int nowY = poll[0];
            int nowX = poll[1];
            if (VISITED[nowY][nowX]) {
                continue;
            }
            if (BOARD[nowY][nowX] == 1) {
                System.out.println(poll[2]);
                return;
            }
            VISITED[nowY][nowX] = true;
            BOARD[nowY][nowX] = poll[2];
            for (int[] move : MOVING) {
                int nextY = nowY + move[0];
                int nextX = nowX + move[1];
                if ((0 <= nextY && nextY < 5)
                        && (0 <= nextX && nextX < 5)
                        && (BOARD[nextY][nextX] != -1)) {
                    queue.add(new int[]{nextY, nextX, poll[2] + 1});
                }
            }

        }
//        System.out.println(Arrays.toString(TARGET_POS));
//        System.out.println(Arrays.toString(START_POS));
//        System.out.println(Arrays.deepToString(BOARD));
//        if (BOARD[TARGET_POS[0]][TARGET_POS[1]] == 1) {
            System.out.println(-1);
    }
}