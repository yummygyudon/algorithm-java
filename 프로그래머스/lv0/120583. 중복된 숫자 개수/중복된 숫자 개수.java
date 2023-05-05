import java.util.stream.*;
import java.util.*;
class Solution {
    public int solution(int[] array, int n) {
        // Arrays.stream(array).count(n);
        return (int) Arrays.stream(array)
            .filter(a->a==n)
            .count();
    }
}