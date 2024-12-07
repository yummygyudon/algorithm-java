import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numberCount = Integer.parseInt(reader.readLine());
        int[] NUMBERS = new int[numberCount + 1];
        int[] INDEXES = new int[numberCount + 1];
        String[] inputs = reader.readLine().split(" ");

        for (int i = 1; i <= numberCount; i++) {
            NUMBERS[i] = Integer.parseInt(inputs[i-1]);
        }
        for (int i = 1; i <= numberCount; i++) {
            int targetIdx = 1;
            while (true) {
                if (INDEXES[targetIdx] == 0 && NUMBERS[i] == 0) {
                    INDEXES[targetIdx] = i;
                    break;
                }
                if (INDEXES[targetIdx] == 0) {
                    NUMBERS[i]--;
                }
                targetIdx++;
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= numberCount; i++) {
            builder.append(INDEXES[i]).append(" ");
        }
        System.out.println(builder);
    }
}