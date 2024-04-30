import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int M;
    static int[][] DISTANCE;
    static Map<Integer, List<Integer>> NODES = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] NM = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        N = NM[0]; M = NM[1];
        DISTANCE = new int[N+1][N+1];

        for (int n = 0; n < N - 1; n++) {
            int[] ABD = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            List<Integer> ofA = NODES.getOrDefault(ABD[0], new ArrayList<>());
            ofA.add(ABD[1]);
            NODES.put(ABD[0], ofA);
            List<Integer> ofB = NODES.getOrDefault(ABD[1], new ArrayList<>());
            ofB.add(ABD[0]);
            NODES.put(ABD[1], ofB);
            DISTANCE[ABD[0]][ABD[1]] = ABD[2]; DISTANCE[ABD[1]][ABD[0]] = ABD[2];
        }
        for (int i = 0; i < M; i++) {
            int[] startAndTarget = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            System.out.println(bfs(startAndTarget[0], startAndTarget[1]));
        }

    }
    static int bfs(int start, int target){
        boolean[] check = new boolean[N+1];
        int result = Integer.MAX_VALUE;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{start, 0});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            if (poll[0] == target) {
                result = Math.min(result, poll[1]);
                continue;
            }
            check[poll[0]] = true;
            for (int elem : NODES.get(poll[0])) {
                if (!check[elem]) {
                    queue.add(new int[]{elem, poll[1] + DISTANCE[poll[0]][elem]});
                }
            }
        }
        return result;
    }

}