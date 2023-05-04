import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
class Solution {
    public int[] solution(int[] num_list, int n) {
        int[] answer = new int[num_list.length - n + 1];
        int index = 0;
        while(n <= num_list.length){
            answer[index] = num_list[n-1];
            index++;
            n++;
        }
        // List<Integer> result = new ArrayList<>();
        // while (num_list.length >= n){
        //     result.add(Integer.valueOf(num_list[n-1]));
        //     n++;
        // }
        // int[] answer = result.toArray(new int[result.size()]);
        return answer;
    }
}