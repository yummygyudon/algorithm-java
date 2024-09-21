import java.io.*;
import java.util.*;

public class Main {

    static int[] DP;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int stoneQuantity = Integer.parseInt(reader.readLine());
        DP = new int[stoneQuantity + 1];
        Arrays.fill(DP, Integer.MAX_VALUE);

        DP[stoneQuantity] = 0;
        for (int i = stoneQuantity; i > 0; i--) {
            DP[i - 1] = Math.min(DP[i - 1], DP[i] + 1);
            if (i >= 3) {
                DP[i - 3] = Math.min(DP[i - 3], DP[i] + 1);
            }
        }
        if (DP[0] % 2 == 0) {
            System.out.println("CY");
        } else {
            System.out.println("SK");
        }

    }
}
