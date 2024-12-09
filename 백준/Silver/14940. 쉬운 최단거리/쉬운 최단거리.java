import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] MAP;

    public static void main(String[] args) throws Exception {
         BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());
        MAP = new int[N][M];
        int[] startPoint = new int[2];

        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(reader.readLine(), " ");
            Arrays.fill(MAP[i], Integer.MAX_VALUE);
            for (int j = 0; j < M; j++) {
                MAP[i][j] = Integer.parseInt(tokenizer.nextToken());
                if (MAP[i][j] == 2) {
                    startPoint[0] = i;
                    startPoint[1] = j;
                    MAP[i][j] = 0;
                } else if (MAP[i][j] == 1) {
                    MAP[i][j] = -1;
                }
            }
        }

        bfs(startPoint[0], startPoint[1]);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                builder.append(MAP[i][j]).append(" ");
            }
            builder.append("\n");
        }
        System.out.println(builder);
    }

    static int[][] MOVING = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    static void bfs(int y, int x) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{y, x});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int nowY = poll[0];
            int nowX = poll[1];
            for (int i = 0; i < 4; i++) {
                int nextY = nowY + MOVING[i][0];
                int nextX = nowX + MOVING[i][1];
                if (0 <= nextY && nextY < N && 0 <= nextX && nextX < M && MAP[nextY][nextX] == -1) {
                    MAP[nextY][nextX] = MAP[nowY][nowX] + 1;
                    queue.add(new int[]{nextY, nextX});
                }
            }
        }

    }
}
