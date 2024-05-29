import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int M;
    static String P;
    static String STRINGS;

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());
        M = Integer.parseInt(reader.readLine());
        STRINGS = reader.readLine();

        P = "I" + "OI".repeat(N);

        int idx = 0;
        int result = 0;
        while (idx <= M-(2*N+1)) {
            if (STRINGS.charAt(idx) == 'I') {
                if (isP(idx)) {
                    result++;
                }
            }
            idx++;
        }
        System.out.println(result);
    }
    private static boolean isP(int index) {
        return STRINGS.substring(index, index + (2 * N + 1)).equals(P);
    }
}