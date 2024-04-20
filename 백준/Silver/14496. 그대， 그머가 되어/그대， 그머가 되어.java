import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
        int A = Integer.parseInt(tokenizer.nextToken());
        int B = Integer.parseInt(tokenizer.nextToken());
        
        tokenizer = new StringTokenizer(reader.readLine(), " ");
        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < M; i++) {
            tokenizer = new StringTokenizer(reader.readLine(), " ");
            int x = Integer.parseInt(tokenizer.nextToken());
            int y = Integer.parseInt(tokenizer.nextToken());
            
            List<Integer> orDefaultX = map.getOrDefault(x, new ArrayList<>());
            List<Integer> orDefaultY = map.getOrDefault(y, new ArrayList<>());
            orDefaultX.add(y);
            orDefaultY.add(x);
            
            map.put(x, orDefaultX);
            map.put(y, orDefaultY);
        }

        boolean[] CHECK = new boolean[N + 1];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{A, 0});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int target = poll[0];
            if (target == B) {
                System.out.println(poll[1]);
                return;
            }
            if (CHECK[target]) {
                continue;
            }
            CHECK[target] = true;
            for (int possible : map.get(target)) {
                queue.add(new int[]{possible, poll[1]+1});
            }
        }
        System.out.println(-1);
    }

}