import java.util.Arrays;
class Solution {
    public int solution(int[] num_list) {
        int index = 0;
        for(int num : num_list) {
            if(num < 0) {
                return index;
            }
            index ++ ;
        }
        return -1;
    }
}