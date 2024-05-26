import java.util.*;
import java.io.*;

public class Main {

    static int[] A;
    static int[] B;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(reader.readLine());

        for (int c = 0; c < cases; c++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
            int aLength = Integer.parseInt(tokenizer.nextToken());
            A = new int[aLength];
            int bLength = Integer.parseInt(tokenizer.nextToken());
            B = new int[bLength];

            tokenizer = new StringTokenizer(reader.readLine(), " ");
            for (int a = 0; a < aLength; a++) {
                A[a] = Integer.parseInt(tokenizer.nextToken());
            }
            tokenizer = new StringTokenizer(reader.readLine(), " ");
            for (int b = 0; b < bLength; b++) {
                B[b] = Integer.parseInt(tokenizer.nextToken());
            }
            Arrays.sort(B);
            long result = 0L;

            for (int target : A) {
                int startIdx = 0, endIdx = bLength-1;
                while (startIdx <= endIdx) {
                    int middle = (startIdx + endIdx) / 2;
                    if (target > B[middle]) {
                        startIdx = middle+1;
                    } else {
                        endIdx = middle-1;
                    }
                }
                result += startIdx;
            }
            System.out.println(result);
        }
    }

}