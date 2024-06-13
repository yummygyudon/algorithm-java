import java.io.*;
import java.util.*;


public class Main {

    static int INDEX_COUNT;
    static String[] TEMP_ARRAY;
    static boolean[] TEMP_CHECK;
    static String RESULT;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while ((input = reader.readLine()) != null) {
            StringTokenizer tokenizer = new StringTokenizer(input, " ");
            String[] values = tokenizer.nextToken().split("");
            int index = Integer.parseInt(tokenizer.nextToken());
            Arrays.sort(values);
            TEMP_ARRAY = values;
            TEMP_CHECK = new boolean[values.length];
            INDEX_COUNT = 0;
            RESULT = "No permutation";


            dfs(0, index, new String[values.length]);
            System.out.printf("%s %d = %s\n", String.join("",values), index, RESULT);
        }
    }

    static void dfs(int nowDepth, int targetIndex, String[] array) {
        if (nowDepth == array.length) {
            INDEX_COUNT++;
            if(INDEX_COUNT == targetIndex) {
                RESULT = String.join("", array);
            }
            return;
        }
        for (int i = 0; i < array.length; i++) {
            if (!TEMP_CHECK[i]) {
                array[nowDepth] = TEMP_ARRAY[i];
                TEMP_CHECK[i] = true;
                dfs(nowDepth+1, targetIndex, array);
                TEMP_CHECK[i] = false;
            }
        }
    }

}