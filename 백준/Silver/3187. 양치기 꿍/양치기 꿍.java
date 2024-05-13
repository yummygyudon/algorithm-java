import java.io.*;
import java.util.*;

public class Main {
    static int R;
    static int C;
    static int[][] MOVING = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static Map<String, Integer> SCORE;
    static {
        SCORE = new HashMap<>();
        SCORE.put("k", 0);
        SCORE.put("v", 0);
    }
    static String[][] MAP;
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] rAndC = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        R = rAndC[0];
        C = rAndC[1];
        MAP = new String[R][C];
        for (int i = 0; i < R; i++) {
            MAP[i] = reader.readLine().split("");
        }

        for (int i = 0; i < R; i++) {
            for (int k = 0; k < C; k++) {
                if (MAP[i][k].equals("k") || MAP[i][k].equals("v")) {
                    bfs(i, k);
                }
            }
        }
        System.out.println(SCORE.get("k") + " " + SCORE.get("v"));

    }

    static void bfs(int y, int x) {
        Queue<int[]> queue = new ArrayDeque();
        int countOfWolf = 0;
        int countOfSheep = 0;
        queue.add(new int[]{y, x});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int nowY = poll[0];
            int nowX = poll[1];
            if (MAP[nowY][nowX].equals("#")) {
                continue;
            }
            if (MAP[nowY][nowX].equals("v")) {
                countOfWolf++;
            }
            if (MAP[nowY][nowX].equals("k")) {
                countOfSheep++;
            }
            MAP[nowY][nowX] = "#";
            for (int i = 0; i < 4; i++) {
                int nextY = nowY + MOVING[i][0];
                int nextX = nowX + MOVING[i][1];
                if ((nextY > 0 && nextY <= R)
                        && (nextX > 0 && nextX <= C)) {
                    queue.add(new int[]{nextY, nextX});
                }
            }
        }
        if (countOfSheep > countOfWolf) {
            Integer existSheep = SCORE.get("k");
            SCORE.put("k", existSheep + countOfSheep);
        } else {
            Integer existWolf = SCORE.get("v");
            SCORE.put("v", existWolf + countOfWolf);
        }
    }
    
}