import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static int[] VIDEO_SIZES;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());

        VIDEO_SIZES = new int[N];
        long maxCriteria = 0L;
        long minCriteria = 0L;

        tokenizer = new StringTokenizer(reader.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int size = Integer.parseInt(tokenizer.nextToken());
            VIDEO_SIZES[i] = size;
            maxCriteria += size;
            minCriteria = Math.max(minCriteria, size);
        }

        while (minCriteria <= maxCriteria) {
            long middleCriteria = (minCriteria + maxCriteria) / 2;
            int countWhenCriteriaIsMiddle = bluerayCountWhenCriteriaIs(middleCriteria);

            if (countWhenCriteriaIsMiddle > M) {
                minCriteria = middleCriteria + 1;
            } else {
                maxCriteria = middleCriteria - 1;
            }
        }
        System.out.println(minCriteria);
    }

    static int bluerayCountWhenCriteriaIs(long criteria) {
        int count = 0;
        long eachSum = 0L;
        for (int size : VIDEO_SIZES) {
            if (eachSum + size > criteria) {
                eachSum = 0L;
                count++;
            }
            eachSum += size;
        }
        if (eachSum != 0) {
            count++;
        }
        return count;
    }
}