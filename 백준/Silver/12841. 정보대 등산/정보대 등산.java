import java.util.*;
import java.io.*;

public class Main {

    static int[] DISTANCE, LEFT, RIGHT;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        DISTANCE = new int[N];
        LEFT = new int[N];
        RIGHT = new int[N];
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
        for (int i = 0; i < N; i++) {
            DISTANCE[i] = Integer.parseInt(tokenizer.nextToken());
        }

        tokenizer = new StringTokenizer(reader.readLine(), " ");
        for (int i = 0; i < N-1; i++) {
            LEFT[i] = Integer.parseInt(tokenizer.nextToken());
        }
        tokenizer = new StringTokenizer(reader.readLine(), " ");
        for (int i = 0; i < N-1; i++) {
            RIGHT[i] = Integer.parseInt(tokenizer.nextToken());
        }
        LEFT[N-1] = 0;
        RIGHT[N-1] = 0;

        int bestIndex = 0;
        long totalReduceBetween = 0; 
        long min = DISTANCE[0]; 

        for (int i = 0; i < N - 1; i++) {
            int reduce = LEFT[i] - RIGHT[i];
            totalReduceBetween += reduce;
            if (totalReduceBetween + DISTANCE[i + 1] < min) { 
                bestIndex = i + 1;
                min = totalReduceBetween + DISTANCE[i + 1];
            }
        }

        long result = 0;
        for (int i = 0; i < N - 1; i++) {
            if (i < bestIndex) {
                result += LEFT[i];
            } else {
                result += RIGHT[i];
            }
        }
        result += DISTANCE[bestIndex];
        System.out.printf("%d %d", bestIndex+1, result);

    }

}