import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] NMR = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int N = NMR[0]; int M = NMR[1]; int R = NMR[2];

        int[] DEPTHS = new int[N+1];
        boolean[] VISITED = new boolean[N + 1];
        Map<Integer, List<Integer>> NODES = new HashMap<>();

        for (int m = 0; m < M; m++) {
            int[] AB = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            List<Integer> ofA = NODES.getOrDefault(AB[0], new ArrayList<>());
            ofA.add(AB[1]);
            NODES.put(AB[0], ofA);
            List<Integer> ofB = NODES.getOrDefault(AB[1], new ArrayList<>());
            ofB.add(AB[0]);
            NODES.put(AB[1], ofB);
        }
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0,R});
        while (!queue.isEmpty()) {
            int[] countAndNode = queue.poll();
            if (VISITED[countAndNode[1]]) {
                continue;
            }
            VISITED[countAndNode[1]] = true;
            DEPTHS[countAndNode[1]] = countAndNode[0];
            for (int elem : NODES.getOrDefault(countAndNode[1], Collections.emptyList())) {
                queue.add(new int[]{countAndNode[0]+1, elem});
            }
        }
        for (int i = 1; i < N + 1; i++) {
            if (DEPTHS[i] == 0 && i != R) {
                System.out.println(-1);
                continue;
            }
            System.out.println(DEPTHS[i]);
        }
    }

}