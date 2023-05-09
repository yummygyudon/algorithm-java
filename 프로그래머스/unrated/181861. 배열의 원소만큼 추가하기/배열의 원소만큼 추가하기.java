import java.util.stream.*;
class Solution {
    public int[] solution(int[] arr) {
        int sum = IntStream.of(arr).sum();
        int[] answer = new int[sum];
        int index = 0;
        for(int num : arr) {
            for (int i = 0 ; i < num ; i ++) {
                answer[index] = num;
                index ++ ;
            }
        }
        // Integer[] answer = numList.toArray(Integer[]::new);
        return answer ;
    }
}