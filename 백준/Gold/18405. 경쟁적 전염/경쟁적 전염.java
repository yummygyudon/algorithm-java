import java.io.*;
import java.util.*;

public class Main {

    static int[][] VIRUS_MAP;
    static int[][] MOVING = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
        int N = Integer.parseInt(tokenizer.nextToken()), K = Integer.parseInt(tokenizer.nextToken());
        VIRUS_MAP = new int[N][N];

        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[3] == o2[3]) {
                    return o1[0] - o2[0];
                }
                return o1[3] - o2[3];
            }
        });

        for (int i = 0; i < N; i++) {
            int[] line = new int[K];
            tokenizer = new StringTokenizer(reader.readLine(), " ");
            for (int j = 0; j < N; j++) {
                line[j] = Integer.parseInt(tokenizer.nextToken());
                if (line[j] != 0) {
                    queue.add(new int[]{line[j], i, j, 0});
                }
            }
            VIRUS_MAP[i] = line;
        }
        
        tokenizer = new StringTokenizer(reader.readLine(), " ");
        int S = Integer.parseInt(tokenizer.nextToken()),
                X = Integer.parseInt(tokenizer.nextToken()),
                Y = Integer.parseInt(tokenizer.nextToken());

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int type = poll[0], y = poll[1], x = poll[2], time = poll[3];
            if (time >= S) {
                continue;
            }
            for (int i = 0; i < 4; i++) {
                int nextY = y + MOVING[i][0], nextX = x + MOVING[i][1];
                if (
                        (0 <= nextY && nextY < N)
                        && (0 <= nextX && nextX < N)
                        && (VIRUS_MAP[nextY][nextX] == 0)
                ) {
                    VIRUS_MAP[nextY][nextX] = type;
                    queue.add(new int[]{type, nextY, nextX, time + 1});
                }
            }
        }
        System.out.println(VIRUS_MAP[X-1][Y-1]);
    }
}