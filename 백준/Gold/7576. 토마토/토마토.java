import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");

        int M = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);
        int[][] box = new int[N][M];
        boolean[][] visited = new boolean[N][M];
        List<int[]> startPoints = new ArrayList<>();
        int[][] MOVING = {{0,1},{1,0},{0,-1},{-1,0}};

        for (int i = 0; i < N; i++) {
            String[] line = reader.readLine().split(" ");
            for (int k = 0; k < M; k++) {
                int value = Integer.parseInt(line[k]);
                box[i][k] = value;
                if (value == 1) {
                    startPoints.add(new int[]{i,k});
                }
            }
        }

        Queue<int[]> queue = new ArrayDeque<>(startPoints);

        while (queue.size() > 0) {
            int[] position = queue.poll();
            int nowY = position[0];
            int nowX = position[1];
            if (visited[nowY][nowX]) {
                continue;
            }
            visited[nowY][nowX] = true;
            for (int i = 0; i < 4; i++) {
                int nextY = nowY + MOVING[i][0];
                int nextX = nowX + MOVING[i][1];
                if ((0 <= nextY && nextY <  N)
                        && (0 <= nextX && nextX <  M)
                        && (box[nextY][nextX] == 0)
                ) {
                    box[nextY][nextX] = box[nowY][nowX] + 1;
                    queue.add(new int[]{nextY, nextX});
                }
            }
        }
        int maxDay = -1_000_000;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                if (maxDay < box[i][j]) {
                    maxDay = box[i][j];
                }
            }
        }
        System.out.println(maxDay-1);
    }

}