import java.io.*;

public class Main {
    
    static int N;
    static int COUNT = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());
        if (N < 2) {
            System.out.println(0);
            return;
        }
        dfs(0, new String[N]);
        System.out.println(COUNT);
    }

    static void dfs(int depth, String[] nums) {
        if (depth == N) {
            int num = Integer.parseInt(String.join("", nums));
            if ((num >= Math.pow(10, N - 1)) 
                    && num % 3 == 0) {
                COUNT++;
            }
            return;
        }
        for (int i = 0; i < 3; i++) {
            nums[depth] = String.valueOf(i);
            dfs(depth+1, nums);
        }
    }
}
