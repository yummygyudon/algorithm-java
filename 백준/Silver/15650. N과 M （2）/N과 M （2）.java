import java.io.*;

public class Main {

    private static int M;
    private static int N;
    private static boolean[] CHECK;
    private static String[] NUM_SEQUENCE;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = reader.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);
        CHECK = new boolean[N + 1];
        NUM_SEQUENCE = new String[M];
        for (int i = 0; i < N; i++) {
            CHECK[i + 1] = true;
            NUM_SEQUENCE[0] = String.valueOf(i+1);
            dfs(1);
        }
    }

    private static void dfs(int depth) {
        if (depth == M) {
            System.out.println(String.join(" ", NUM_SEQUENCE));
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (!CHECK[i] && Integer.parseInt(NUM_SEQUENCE[depth - 1]) < i) {
                CHECK[i] = true;
                NUM_SEQUENCE[depth] = String.valueOf(i);
                dfs(depth + 1);
                CHECK[i] = false;
            }
        }
    }

}
