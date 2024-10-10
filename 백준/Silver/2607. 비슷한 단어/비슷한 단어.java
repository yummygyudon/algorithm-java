import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());

        String word = reader.readLine();
        int result = 0;


        for (int i = 0; i < N - 1; i++) {
            String input = reader.readLine();
            int[] wordCount = new int[26]; // 각 알파벳별 개수 취합
            for (int j = 0; j < word.length(); j++) {
                wordCount[word.charAt(j) - 'A']++;
            }

            int alphabetSameCount = 0;
            for (int j = 0; j < input.length(); j++) {
                if (wordCount[input.charAt(j) - 'A'] > 0) { // word의 값과 동일할 때 (0 이상)
                    alphabetSameCount++;
                    wordCount[input.charAt(j) - 'A']--;
                }
            }

            // "모두 1 이상 차이"나면 확인할 필요도 없이 "구성이 다른 것"으로 판정해도 됨.
            if (
                    word.length() == input.length() && // 같은 길이
                            (word.length() == alphabetSameCount // 완전히 같은 구성
                                    || word.length() - 1 == alphabetSameCount) // or 한 글자만 "바꾸면" 같아지는 구성인 경우
            ) {
                result++;
            } else if (word.length() == input.length() - 1 && // 입력값 "길이가 1 큰데"
                    input.length() - 1 == alphabetSameCount) { // 입력값 글자 중 "하나만 제거하면" 동일한 구성이 될 때
                result++;
            } else if (word.length() == input.length() + 1 && // 입력값 "길이가 1 작은데"
                    input.length() == alphabetSameCount) { // 입력값 글자에 "하나만 추가하면" 동일한 구성이 될 때
                result++;
            }
        }
        System.out.println(result);
    }
}