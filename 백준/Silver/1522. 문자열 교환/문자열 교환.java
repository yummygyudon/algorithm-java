import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[] alps = reader.readLine().toCharArray();
        int result = Integer.MAX_VALUE;
        int aCnt = 0;
        for (char alp : alps) {
            if (alp == 'a') {
                aCnt++;
            }
        }
        for (int i = 0; i < alps.length; i++) {
            int bCnt = 0;
            for (int j = 0; j < aCnt; j++) {
                int targetIdx = i + j;
                if (targetIdx >= alps.length) {
                    targetIdx = targetIdx % alps.length;
                }
                if (alps[targetIdx] == 'b') {
                    bCnt++;
                }
            }
            result = Math.min(result, bCnt);
        }
        System.out.println(result);
    }
}