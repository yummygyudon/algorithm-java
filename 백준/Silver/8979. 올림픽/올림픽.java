import java.io.*;
import java.util.*;
public class Main {
    static int GOLD_VALUE = 3;
    static int SILVER_VALUE = 2;
    static int BRONZE_VALUE = 1;
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
        int N = Integer.parseInt(tokenizer.nextToken()),
                TARGET_TEAM = Integer.parseInt(tokenizer.nextToken());
        int tmp = 0;
        int[][] scoreBoard = new int[N][2];
        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(reader.readLine(), " ");
            int teamNum = Integer.parseInt(tokenizer.nextToken()),
                    gold = Integer.parseInt(tokenizer.nextToken()),
                    silver = Integer.parseInt(tokenizer.nextToken()),
                    bronze = Integer.parseInt(tokenizer.nextToken());
            int[] score = new int[2];

            score[0] = teamNum;
            int value = (gold * GOLD_VALUE) + (silver * SILVER_VALUE) + (bronze * BRONZE_VALUE);
            score[1] = value;
            if (teamNum == TARGET_TEAM) {
                tmp = value;
            }
            scoreBoard[i] = score;
        }
        Comparator<int[]> comparator = (o1, o2) -> Integer.compare(o1[1], o2[1]);
        Arrays.sort(scoreBoard, comparator.reversed());

        int targetValue = tmp;
        long higherCount = Arrays.stream(scoreBoard).filter(x -> x[1] > targetValue).count();
        System.out.println(higherCount + 1);
    }
}