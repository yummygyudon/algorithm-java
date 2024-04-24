import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        long[] pibo = new long[91];
        pibo[1] = 1;
        for (int i = 2; i < N + 1; i++) {
            pibo[i] = pibo[i - 1] + pibo[i - 2];
        }
//        System.out.println(Arrays.toString(pibo));
        System.out.println(pibo[N]);
    }
}