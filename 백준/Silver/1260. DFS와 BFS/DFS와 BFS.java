import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = reader.readLine().split(" ");

        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        int START = Integer.parseInt(inputs[2]);

        int[][] NODE = new int[N+1][N+1];
        for (int i = 0; i < M; i++) {
            String[] ab = reader.readLine().split(" ");
            int a = Integer.parseInt(ab[0]);
            int b = Integer.parseInt(ab[1]);
            NODE[a][b] = b;
            NODE[b][a] = a;
        }

        boolean[] visitedDFS = new boolean[N+1];
        boolean[] visitedBFS = new boolean[N+1];
        visitedBFS[0] = true;
        visitedDFS[0] = true;

        dfs(NODE, visitedDFS, START);
        System.out.print("\n");
        bfs(NODE, visitedBFS, START);
    }

    private static void dfs(int[][] node, boolean[] visited, int nodeIdx) {
        System.out.print(nodeIdx + " ");
        visited[nodeIdx] = true;
        for (int nextNode : node[nodeIdx]) {
            if (!visited[nextNode]) {
                dfs(node, visited, nextNode);
            }
        }
    }

    private static void bfs(int[][] node, boolean[] visited, int nodeIdx) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(nodeIdx);
        while (queue.size() > 0) {
            Integer targetNodeIdx = queue.poll();
            if (visited[targetNodeIdx]) {
                continue;
            }
            visited[targetNodeIdx] = true;
            System.out.print(targetNodeIdx + " ");
            for (int nextNode : node[targetNodeIdx]) {
                if (nextNode != 0) {
                    queue.add(nextNode);
                }
            }
        }
    }
}