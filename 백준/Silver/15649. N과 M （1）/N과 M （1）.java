import java.io.*;

public class Main {

    private static boolean[] CHECK;
    private static int N;
    private static int M;
    private static String[] NUM_SEQUENCE;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = reader.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);
        CHECK = new boolean[N+1];
        NUM_SEQUENCE = new String[M];
        dfs(0);
    }

    private static void dfs(int depth) {
        if (depth == M) {
            System.out.println(String.join(" ", NUM_SEQUENCE));
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (!CHECK[i]) {
                CHECK[i] = true;
                NUM_SEQUENCE[depth] = String.valueOf(i);
                dfs(depth+1);
                CHECK[i] = false;
            }
        }
    }

}