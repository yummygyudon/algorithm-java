import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int LIMIT_TIME;
    static int[] GRAM_POS;
    static int[][] MAP;
    static boolean[][][] VISIT;


    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");

        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());
        LIMIT_TIME = Integer.parseInt(tokenizer.nextToken());
        MAP = new int[N][M];
        VISIT = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(reader.readLine(), " ");
            int[] line = new int[M];
            for (int j = 0; j < M; j++) {
                int point = Integer.parseInt(tokenizer.nextToken());
                if (point == 2) {
                    GRAM_POS = new int[]{i, j};
                }
                line[j] = point;
            }
            MAP[i] = line;
        }

        int result = bfs();
        if (result == Integer.MAX_VALUE || result > LIMIT_TIME) {
            System.out.println("Fail");
        } else {
            System.out.println(result);
        }
    }

    static class Warrior implements Comparable<Warrior>{
        final int y;
        final int x;
        final boolean hasGram;
        final int moveCount;

        public Warrior(int y, int x, boolean hasGram, int moveCount) {
            this.y = y;
            this.x = x;
            this.hasGram = hasGram;
            this.moveCount = moveCount;
        }

        @Override
        public int compareTo(Warrior o) {
            return this.moveCount - o.moveCount;
        }
    }

    static int[][] MOVING = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    static int bfs() {
        PriorityQueue<Warrior> warriors = new PriorityQueue<>();
        warriors.add(new Warrior(0, 0, false, 0));

        VISIT[0][0][0] = true;
        while (!warriors.isEmpty()) {
            Warrior warrior = warriors.poll();
            if (warrior.y == N - 1 && warrior.x == M - 1) {
                return warrior.moveCount;
            }
            boolean isGramHere = (warrior.y == GRAM_POS[0] && warrior.x == GRAM_POS[1]);
            for (int i = 0; i < 4; i++) {
                int nextY = warrior.y + MOVING[i][0];
                int nextX = warrior.x + MOVING[i][1];
                if ((0 <= nextY && nextY < N) && (0 <= nextX && nextX < M)) {
                    if (!(isGramHere || warrior.hasGram)) {
                        if (MAP[nextY][nextX] == 0 && !VISIT[nextY][nextX][0]) {
                            VISIT[nextY][nextX][0] = true;
                            warriors.add(new Warrior(nextY, nextX, false, warrior.moveCount + 1));
                        }
                        if (MAP[nextY][nextX] == 2 && !VISIT[nextY][nextX][0]) {
                            VISIT[nextY][nextX][0] = true;
                            warriors.add(new Warrior(nextY, nextX, true, warrior.moveCount + 1));
                        }
                    } else {
                        if (!VISIT[nextY][nextX][1]) {
                            VISIT[nextY][nextX][1] = true;
                            warriors.add(new Warrior(nextY, nextX, true, warrior.moveCount + 1));
                        }
                    }
                }
            }
        }
        return Integer.MAX_VALUE;
    }
}