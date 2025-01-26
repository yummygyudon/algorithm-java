import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Deque<String> existWords = new ArrayDeque<>();
        Set<String> alreadyWord = new HashSet<>();
        int round = 1;
        int wordIdx = 0; //, playerIdx = 0
        int playerIdx = 0;
        while (true) {
            if (playerIdx == n) {
                round++;
            }
            if (wordIdx == words.length) {
                break;
            }
            playerIdx = playerIdx % n ;
            String nowWord = words[wordIdx];
            if (existWords.contains(nowWord)) {
                System.out.println("중복");
                break;
            }
            if (!existWords.isEmpty()) {
                String lastWord = existWords.peekLast();
                if (lastWord.charAt(lastWord.length() - 1) != nowWord.charAt(0)) {

                    break;
                }
            }
            existWords.add(nowWord);
            wordIdx++;
            playerIdx++;


        }
        if (wordIdx == words.length) {
            return new int[]{0, 0};
        }
        return new int[]{playerIdx + 1, round};
    }
}