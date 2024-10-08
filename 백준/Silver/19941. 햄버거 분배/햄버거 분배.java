import java.util.*;
import java.io.*;

public class Main {

    static boolean[] HAMBURGERS;
    static boolean[] PEOPLE;
    static int N, K;
    static int RESULT = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
        N = Integer.parseInt(tokenizer.nextToken());
        K = Integer.parseInt(tokenizer.nextToken());

        String[] inputs = reader.readLine().split("");

        HAMBURGERS = new boolean[N];
        PEOPLE = new boolean[N];
        for (int i = 0; i < N; i++) {
            if (inputs[i].equals("H")) {
                HAMBURGERS[i] = true;
            } else {
                PEOPLE[i] = true;
            }
        }

        for (int i = 0; i < N; i++) {
            if (PEOPLE[i]) {
                calc(i);
            }
        }
        System.out.println(RESULT);
    }

    static void calc(int humanPos) {
        for (int k = K; k >= 1; k--) {
            if (humanPos - k >= 0 && HAMBURGERS[humanPos - k]) {
                RESULT++;
                HAMBURGERS[humanPos - k] = false;
                return;
            }
        }
        for (int k = 1; k <= K; k++) {
            if (humanPos + k < N && HAMBURGERS[humanPos + k]) {
                RESULT++;
                HAMBURGERS[humanPos + k] = false;
                return;
            }
        }
    }
}