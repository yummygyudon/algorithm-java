import java.io.*;
import java.util.*;

public class Main {

    static List<Character> VOWELS = List.of('a', 'e', 'i', 'o', 'u');
    static String END_COMMAND = "end";

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        while (true) {
            String input = reader.readLine();
            if (input.equals(END_COMMAND)) {
                break;
            }
            result.append("<").append(input).append("> is");
            char[] password = input.toCharArray();
            boolean isAvailable = false;

            char before = ' ';
            boolean isVowelBefore = false;
            int sameCount = 0;
            for (char alp : password) {
                boolean isVowelNow = VOWELS.contains(alp);
                if (isVowelNow) {
                    isAvailable = true;
                }

                if (isVowelNow != isVowelBefore) {
                    sameCount = 1;
                } else { // 연속으로 모음 혹은 자음일 경우 누적
                    sameCount++;
                }

                if (sameCount > 2 || // 모음 혹은 자음이 3번 이상 나왔거나
                        (alp == before && !(alp == 'e' || alp == 'o')) // 두 글자가 똑같을 글자가 'e'/'o'가 아닌 경우
                ){
                    isAvailable = false;
                    break;
                }

                before = alp;
                isVowelBefore = isVowelNow;
            }
            if (!isAvailable) {
                result.append(" not");
            }
            result.append(" acceptable.\n");
        }
        System.out.println(result);
    }
}