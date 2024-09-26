import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
        int N = Integer.parseInt(tokenizer.nextToken()),
                TARGET_TEAM = Integer.parseInt(tokenizer.nextToken());
        int[][] scoreBoard = new int[N][5];
        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(reader.readLine(), " ");
            int[] score = new int[5];
            score[0] = Integer.parseInt(tokenizer.nextToken());
            score[1] = Integer.parseInt(tokenizer.nextToken());
            score[2] = Integer.parseInt(tokenizer.nextToken());
            score[3] = Integer.parseInt(tokenizer.nextToken());
            score[4] = 1; // Rank
            scoreBoard[i] = score;
        }

        Arrays.sort(scoreBoard, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                if (o1[2] == o2[2]) {
                    return -(o1[3] - o2[3]);
                } else {
                    return -(o1[2] - o2[2]);
                }
            } else {
                return -(o1[1] - o2[1]);
            }
        });
        int targetIndex = 0;
        for (int i = 1; i < N; i++) {
            if (scoreBoard[i][0] == TARGET_TEAM) {
                targetIndex = i;
            }
            if ((scoreBoard[i][1] == scoreBoard[i-1][1]) &&
                    (scoreBoard[i][2] == scoreBoard[i-1][2]) &&
                    (scoreBoard[i][3] == scoreBoard[i-1][3])) {
                scoreBoard[i][4] = scoreBoard[i - 1][4];
            } else {
                scoreBoard[i][4] = i + 1; // 공동 순위 책정 때문에 이전 순서가 아닌 i로 연산
            }
        }
        System.out.println(scoreBoard[targetIndex][4]);
    }
}