import java.io.*;
import java.util.*;


public class Main {
    
    private static int Y;
    private static int X;
    private static boolean[][] MAP;
    private static final int[][] MOVING = {{1,0}, {0,1}, {-1,0}, {0,-1}};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs  = reader.readLine().split(" ");
        Y = Integer.parseInt(inputs[0]);
        X = Integer.parseInt(inputs[1]);
        MAP = new boolean[Y][X];

        int AREA_QUANTITY = Integer.parseInt(inputs[2]);
        for (int i = 0; i < AREA_QUANTITY; i++) {
            String[] areaPos = reader.readLine().split(" ");
            int startY = Integer.parseInt(areaPos[1]);
            int startX = Integer.parseInt(areaPos[0]);
            int endY = Integer.parseInt(areaPos[3]);
            int endX = Integer.parseInt(areaPos[2]);
            for (int k = startY; k < endY; k++) {
                for (int j = startX; j < endX; j++) {
                    MAP[k][j] = true;
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int q = 0; q < AREA_QUANTITY; q++) {
            for (int i = 0; i < Y; i++) {
                for (int k = 0; k < X; k++) {
                    if (!MAP[i][k]) {
                        MAP[i][k] = true;
                        result.add(count(i, k));
                    }
                }
            }
        }
        Collections.sort(result);
        System.out.println(result.size());
        result.forEach(value -> System.out.print(value + " "));
    }
    
    private static int count(int startY, int startX) {
        int count = 1;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{startY, startX});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int nowY = poll[0];
            int nowX = poll[1];
            for (int[] move : MOVING) {
                int nextY = nowY + move[0];
                int nextX = nowX + move[1];
                if (
                    (0 <= nextY && nextY < Y)
                        && (0 <= nextX && nextX < X)
                        && (!MAP[nextY][nextX])
                ){
                    MAP[nextY][nextX] = true;
                    count++;
                    queue.add(new int[]{nextY, nextX});
                }
            }
        }
        return count;
    }
}