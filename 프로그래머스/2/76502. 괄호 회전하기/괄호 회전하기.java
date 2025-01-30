import java.util.*;
class Solution {
    private static String[] STRINGS;
        private static Map<String, String> PAIR = Map.of(
                "[","]",
                "{", "}",
                "(", ")"
        );
        public int solution(String s) {
            STRINGS = s.split("");
            int answer = 0;
            for (int i = 0; i < STRINGS.length; i++) {
                if (isAvailableWhenStart(i)) {
                    answer++;
                }
            }
            return answer;
        }
        boolean isAvailableWhenStart(int startIdx) {
            Stack<String> stack = new Stack<>();
            for (int i = 0; i < STRINGS.length; i++) {
                int nowIdx = (startIdx + i) % STRINGS.length;
                if (isStart(STRINGS[nowIdx])) {
                    stack.add(STRINGS[nowIdx]);
                } else if (stack.isEmpty()) {
                    return false;
                } else {
                    String lastStart = stack.pop();
                    if (!isCorrectPair(lastStart, STRINGS[nowIdx])) {
                        return false;
                    }
                }
            }
            return stack.isEmpty();
        }

        boolean isStart(String s) {
            return PAIR.containsKey(s);
        }
        boolean isCorrectPair(String open, String close) {
            return PAIR.get(open).equals(close);
        }
}