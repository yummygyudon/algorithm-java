import java.util.*;
import java.io.*;

public class Main {
    
    static int K;
    static int N;
    static long RESULT = Long.MIN_VALUE;
    static int[]  NUMBERS;
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
        N = Integer.parseInt(tokenizer.nextToken());
        K = Integer.parseInt(tokenizer.nextToken());
        NUMBERS = new int[(N - 1) + K];
        tokenizer = new StringTokenizer(reader.readLine(), " ");
        for (int i = 0; i < N; i++) {
            NUMBERS[i] = Integer.parseInt(tokenizer.nextToken());
        }
        for (int i = 0; i < K - 1; i++) {
            NUMBERS[N + i] = NUMBERS[i];
        }
        long sum = 0L;
        /**
         * 먼저 갯수만큼 합 구한 후, 하나씩 추가 & 제거 => 여전히 구간은 보존
         * 이중 For문 해결
         */
        for (int k = 0; k < K; k++) {
            sum += NUMBERS[k];
        }
        RESULT = Math.max(RESULT, sum);

        for (int include = K; include < (N - 1) + K; include++) {
            int exclude = include - K; // 이번 포함값의 K번째 뒤의 값 (제외될 값)
            sum -= NUMBERS[exclude];
            sum += NUMBERS[include];
            RESULT = Math.max(RESULT, sum);
        }
        System.out.println(RESULT);
    }
    
}