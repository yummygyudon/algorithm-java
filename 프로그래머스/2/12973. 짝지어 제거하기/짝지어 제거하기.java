import java.util.*;

class Solution {
    public int solution(String s) {
        Deque<Character> queue = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            boolean isRemoved = false;
            while (!queue.isEmpty() && queue.peekLast() == s.charAt(i)) {
                queue.pollLast();
                isRemoved = true;
            }
            if (!isRemoved) {
                queue.addLast(s.charAt(i));
            }
        }
        return !queue.isEmpty() ? 0 : 1;
    }
}