import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        long[] cases = new long[1001];
        cases[1] = 1;
        cases[2] = 2;
        if (N > 2) {
            for (int i = 3; i < N+1; i++) {
                cases[i] = (cases[i - 1] + cases[i - 2])% 10007;
            }
        }
        System.out.println(cases[N]);
    }
}