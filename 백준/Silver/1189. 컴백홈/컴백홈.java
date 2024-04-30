import java.io.*;
import java.util.*;

public class Main {

    static int R;
    static int C;
    static int K;
    static int COUNT = 0;
    static String[][] MAP;
    static boolean[][] VISITED;
    static int[][] MOVING = {{0,1}, {0,-1}, {1,0}, {-1,0}};


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] RCK = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        R = RCK[0]; C = RCK[1]; K = RCK[2];
        VISITED = new boolean[R][C];
        MAP = new String[R][C];
        for (int r = 0; r < R; r++) {
            String[] line = reader.readLine().split("");
            for (int c = 0; c < C; c++) {
                MAP[r][c] = line[c];
            }
        }
        
        // DFS
        VISITED[R-1][0] = true;
        dfs(1, new int[]{R-1,0});
        System.out.println(COUNT);
    }

    static void dfs(int depth, int[] pos) {
        if (depth == K) {
            if (pos[0] == 0 && pos[1] == C-1) {
                COUNT++;
                return;
            }
        }
        for (int i = 0; i < 4; i++) {
            int nextY = pos[0]  + MOVING[i][0];
            int nextX = pos[1] + MOVING[i][1];
            if (
                    (0 <= nextY && nextY < R)
                    && (0 <= nextX && nextX < C)
                    && !VISITED[nextY][nextX]
                    && (!(MAP[nextY][nextX].equals("T")))
            ) {
                VISITED[nextY][nextX] = true;
                dfs(depth+1, new int[]{nextY, nextX});
                VISITED[nextY][nextX] = false;
            }
        }
    }
}