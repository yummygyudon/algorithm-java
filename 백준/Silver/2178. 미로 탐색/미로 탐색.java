import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[][] MAP = new int[N][M];
        // (0,1) : 오른쪽 | (1,0) : 아래쪽 | (0,-1) : 왼쪽 | (-1,0) : 위쪽
        int[][] MOVING = new int[][]{{0,1}, {1,0}, {0, -1}, {-1,0}};
        
        for (int i = 0; i < N; i++) {
            int[] line = Arrays.stream(reader.readLine().split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            MAP[i] = line;
        }

        boolean[][] visited = new boolean[N][M];

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0});
        
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
                if ((0 <= nextY && nextY < N)
                        && (0 <= nextX && nextX < M)
                        && !visited[nextY][nextX]
                        && MAP[nextY][nextX] == 1
                ) {
                    queue.add(new int[]{nextY, nextX});
                    MAP[nextY][nextX] = MAP[nowY][nowX] + 1;
                }
            }
        }
        System.out.println(MAP[N-1][M-1]);
    }
}