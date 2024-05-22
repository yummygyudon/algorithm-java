import java.io.*;
import java.util.*;

public class Main {

    static int SWITCH_QUAN;
    static int STUDENT_COUNT;
    static int[] SWITCHES;


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        SWITCH_QUAN = Integer.parseInt(reader.readLine());
        SWITCHES = new int[SWITCH_QUAN + 2];

        String[] numbers = reader.readLine().split(" ");
        for (int i = 1; i <= SWITCH_QUAN; i++) {
            SWITCHES[i] = Integer.parseInt(numbers[i - 1]);
        }
        STUDENT_COUNT = Integer.parseInt(reader.readLine());
        for (int i = 0; i < STUDENT_COUNT; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
            int gender = Integer.parseInt(tokenizer.nextToken());
            int number = Integer.parseInt(tokenizer.nextToken());
            if (gender == 1) {
                boy(number);
            } else {
                girl(number);
            }
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= SWITCH_QUAN; i++) {
            builder.append(SWITCHES[i]).append(" ");
            if (i%20==0) {
                builder.append("\n");
            }
        }
        System.out.println(builder);
    }

    private static void boy(int startIdx) {
        int value = startIdx;
        do {
            if (SWITCHES[value]==0) {
                SWITCHES[value] = 1;
            } else {
                SWITCHES[value] = 0;
            }
            value += startIdx;
        } while (value <= SWITCH_QUAN);
    }
    private static void girl(int startIdx) {
        SWITCHES[startIdx] = SWITCHES[startIdx] == 0 ? 1 : 0;
        int left = startIdx - 1;
        int right = startIdx + 1;
        while (left >= 1 && right <= SWITCH_QUAN && SWITCHES[left] == SWITCHES[right]) {
            SWITCHES[left] = SWITCHES[left] == 0 ? 1 : 0;
            SWITCHES[right] = SWITCHES[right] == 0 ? 1 : 0;
            left--;
            right++;
        }
    }

}