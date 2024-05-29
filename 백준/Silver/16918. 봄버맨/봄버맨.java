import java.util.*;import java.io.*;


public class Main {

    static int[][] SCOPE = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int[][] BOMB_TIME_MAP;
    static char[][] STATUS_MAP;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
        int R = Integer.parseInt(tokenizer.nextToken()), C = Integer.parseInt(tokenizer.nextToken()), N = Integer.parseInt(tokenizer.nextToken());
        STATUS_MAP = new char[R][C];
        BOMB_TIME_MAP = new int[R][C];

        for (int i = 0; i < R; i++) {
            String input = reader.readLine();
            for (int k = 0; k < C; k++) {
                char value = input.charAt(k);
                if (value == 'O') {
                    BOMB_TIME_MAP[i][k] = 3; // 아무일도 안일어나는 1초 제외
                }
                STATUS_MAP[i][k] = value;
            }
        }

        int time = 1; // 최초 봄버맨 설치 시간 & 아무일도 안일어나는 1초 제외
        while (time <= N) {
            if (time % 2 == 0) {
                for (int i = 0; i < R; i++) {
                    for (int k = 0; k < C; k++) {
                        if (STATUS_MAP[i][k] == '.') {
                            STATUS_MAP[i][k] = 'O';
                            BOMB_TIME_MAP[i][k] = time + 3; // 현재 시간 + 3초 후에 터짐
                        }
                    }
                }
            } else { // 터지는 시간
                for (int i = 0; i < R; i++) {
                    for (int k = 0; k < C; k++) {
                        if (BOMB_TIME_MAP[i][k] == time) {
                            STATUS_MAP[i][k] = '.';
                            for (int scope = 0; scope < 4; scope++) {
                                int nextY = i + SCOPE[scope][0], nextX = k + SCOPE[scope][1];
                                if ((0 <= nextX && nextX < C) && (0 <= nextY && nextY < R)) {
                                    if (STATUS_MAP[nextY][nextX] == 'O' && BOMB_TIME_MAP[nextY][nextX] != time) {
                                        STATUS_MAP[nextY][nextX] = '.';
                                        BOMB_TIME_MAP[nextY][nextX] = 0;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            time++;
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < R; i++) {
            for (int k = 0; k < C; k++) {
                builder.append(STATUS_MAP[i][k]);
            }
            builder.append('\n');
        }
        System.out.println(builder);
    }

}