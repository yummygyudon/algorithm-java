import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int quantity = Integer.parseInt(reader.readLine());
        int highest = Integer.MIN_VALUE;
        int highestIndex = 0;
        int[] HEIGHTS = new int[1001];
        StringTokenizer tokenizer;
        for (int i = 0; i < quantity; i++) {
            tokenizer = new StringTokenizer(reader.readLine(), " ");
            int index = Integer.parseInt(tokenizer.nextToken());
            int height = Integer.parseInt(tokenizer.nextToken());
            if (height > highest) {
                highestIndex = index;
                highest = height;
            }
            HEIGHTS[index] = height;
        }

        int totalSize = 0;
        int heightCriteria = 0;
        for (int i = 0; i < highestIndex; i++) {
            if (heightCriteria < HEIGHTS[i]) {
                heightCriteria = HEIGHTS[i];
            }
            totalSize += heightCriteria;
        }
        heightCriteria = 0;
        for (int i = 1000; i > highestIndex; i--) {
            if (heightCriteria < HEIGHTS[i]) {
                heightCriteria = HEIGHTS[i];
            }
            totalSize += heightCriteria;
        }
        System.out.println(totalSize + highest);

    }
}