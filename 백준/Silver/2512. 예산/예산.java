import java.io.*;
import java.util.*;

public class Main {

    static int N, TOTAL_LIMIT;
    static int[] BUDGETS;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
        BUDGETS = new int[N];

        int high = 0;
        int low = 0;
        for (int i = 0; i < N; i++) {
            int budget = Integer.parseInt(tokenizer.nextToken());
            BUDGETS[i] = budget;
            high = Math.max(high, budget);
        }

        TOTAL_LIMIT = Integer.parseInt(reader.readLine());

        if (Arrays.stream(BUDGETS).sum() <= TOTAL_LIMIT) {
            System.out.println(high);
            return;
        }

        while (low < high - 1) { 
            int middle = (low + high) / 2;
            long totalBudgetWhenLimitIsMiddle = totalWhenLimitIs(middle);

            if (totalBudgetWhenLimitIsMiddle > TOTAL_LIMIT) {
                high = middle;
            } else {
                low = middle;
            }
        }
        System.out.println(low);
    }

    static long totalWhenLimitIs(long budgetLimit) {
        long total = 0L;
        for (int budget : BUDGETS) {
            total += Math.min(budget, budgetLimit);
        }
        return total;
    }

}
