import java.io.*;
import java.util.*;
public class Main {

    static int N;
    static int M;
    static boolean[] IS_LAMP_BUILT;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());
        M = Integer.parseInt(reader.readLine());
        IS_LAMP_BUILT = new boolean[N+1];
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
        for (int i = 0; i < M; i++) {
            IS_LAMP_BUILT[Integer.parseInt(tokenizer.nextToken())] = true;
        }

        int start = 0, end = N + 1, bestHeight = 0;

        while (start <= end) {
            int trialHeight = (start + end) / 2;
            if (isLightCoverAllWhenHeightIs(trialHeight)) {
                bestHeight = trialHeight;
                end = trialHeight - 1;
            } else {
                start = trialHeight + 1;
            }
        }
        System.out.println(bestHeight);
    }

    static boolean isLightCoverAllWhenHeightIs(int lampHeight) {
        int startPoint = 0;
        for (int i = 0; i < N + 1; i++) {
            if (IS_LAMP_BUILT[i]) {
                if (i - lampHeight <= startPoint) {
                    startPoint = i + lampHeight;
                } else {
                    return false;
                }
            }
        }
        return N - startPoint <= 0;
    }

}
