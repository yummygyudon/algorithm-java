import java.io.*;

public class Main {
    static char A = 'A';
    static char B = 'B';

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String S = reader.readLine();
        String T = reader.readLine();

         System.out.println(countPossible(S, T) > 0 ? 1 : 0);
    }

    static int countPossible(String str, String expected) {
        if (str.length() == expected.length()) {
            return str.equals(expected) ? 1 : 0;
        }

        int result = 0;
        if (expected.charAt(0) == B) { // startsWith("")
            result += countPossible(str, new StringBuffer(expected.substring(1)).reverse().toString());
        }
        // A로 시작하는 경우 중
        if (expected.charAt(expected.length() - 1) == A) {
            result += countPossible(str, expected.substring(0, expected.length()-1));
        }
        return result;
    }
}