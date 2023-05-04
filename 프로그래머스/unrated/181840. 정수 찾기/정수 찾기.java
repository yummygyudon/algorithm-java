import java.util.*;
class Solution {
    public int solution(int[] num_list, int n) {
//         List<Integer> numList = Arrays.asList(num_list);
//         for (Integer num : numList){
//             System.out.println(num);
//         }
        
//         return numList.contains(n) ? 1 : 0;
        for (int num : num_list) {
            if (num == n) {
                return 1;
            }
        }
        return 0;
    }
}