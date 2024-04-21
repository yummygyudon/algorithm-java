import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(reader.readLine());
        }
        Arrays.sort(numbers);
        for (int k = 0; k < M; k++) {
            int target = Integer.parseInt(reader.readLine());
            int minPoint = binarySearchLowest(target, numbers);
            int maxPoint = binarySearchHighest(target, numbers);
            if (minPoint == maxPoint) {
                System.out.println(-1);
            } else {
                System.out.println(minPoint);
            }
        }
    }

    private static int binarySearchLowest(int targetNum, int[] numbers) {
        int lowestPoint = 0;
        int highestPoint = numbers.length;
        while (lowestPoint < highestPoint) {
            int middle = (highestPoint + lowestPoint) / 2;
            if (numbers[middle] >= targetNum) {
                highestPoint = middle;
            } else {
                lowestPoint = middle + 1;
            }
        }
        return lowestPoint;
    }
    private static int binarySearchHighest(int targetNum, int[] numbers) {
        int lowestPoint = 0;
        int highestPoint = numbers.length;
        while (lowestPoint < highestPoint) {
            int middle = (highestPoint + lowestPoint) / 2;
            if (numbers[middle] > targetNum) {
                highestPoint = middle;
            } else {
                lowestPoint = middle + 1;
            }
        }
        return lowestPoint;
    }
}