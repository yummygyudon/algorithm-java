import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static int[][] MAP;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
        M = Integer.parseInt(tokenizer.nextToken());
        N = Integer.parseInt(tokenizer.nextToken());

        MAP = new int[N][M];

        for (int i = 0; i < N; i++) {
            MAP[i] = Arrays.stream(reader.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        bfs();

    }

    static int[][] MOVING = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    static void bfs() {
        PriorityQueue<int[]> queue = new PriorityQueue<>(((o1, o2) -> o1[0] - o2[0]));
        queue.add(new int[]{0,0,0});

        boolean[][] VISIT = new boolean[N][M];
        VISIT[0][0] = true;
        while (!queue.isEmpty()) {
            int[] polled = queue.poll();
            int breakCnt = polled[0], y = polled[1], x = polled[2];
            if (y == N - 1 && x == M - 1) {
                System.out.println(breakCnt);
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nextY = y + MOVING[i][0], nextX = x + MOVING[i][1];
                if ((0 <= nextY && nextY < N) && (0 <= nextX && nextX < M) && !VISIT[nextY][nextX]) {
                    VISIT[nextY][nextX] = true;
                    if (MAP[nextY][nextX] == 1) {
                        queue.add(new int[]{breakCnt + 1, nextY, nextX});
                    }
                    if (MAP[nextY][nextX] == 0) {
                        queue.add(new int[]{breakCnt, nextY, nextX});
                    }
                }
            }

        }

    }

}
