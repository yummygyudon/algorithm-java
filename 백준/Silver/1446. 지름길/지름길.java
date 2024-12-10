import java.io.*;
import java.util.*;

public class Main {
    static class ShortCut {
        final int start;
        final int end;
        final int distance;

        ShortCut(int start, int end, int distance) {
            this.start = start;
            this.end = end;
            this.distance = distance;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
        int N = Integer.parseInt(tokenizer.nextToken()), D = Integer.parseInt(tokenizer.nextToken());
        int[] road = new int[10001];

        List<ShortCut> shortCuts = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(reader.readLine(), " ");
            int start = Integer.parseInt(tokenizer.nextToken()),
                    end = Integer.parseInt(tokenizer.nextToken()),
                    distance = Integer.parseInt(tokenizer.nextToken());
            shortCuts.add(new ShortCut(start, end, distance));
        }
        for (int i = 0; i <= D; i++) {
            road[i] = i;
        }
        for (int i = 0; i <= D; i++) {
            if (i > 0) {
                road[i] = Math.min(road[i-1] + 1, road[i]);
            }
            for (ShortCut shortCut : shortCuts) {
                if (shortCut.start == i) {
                    road[shortCut.end] = Math.min(road[shortCut.start] + shortCut.distance, road[shortCut.end]);
                }
            }
        }
        System.out.println(road[D]);

    }
}
