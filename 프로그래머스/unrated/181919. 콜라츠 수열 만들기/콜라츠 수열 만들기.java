import java.util.* ;
class Solution {
    public int[] solution(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(n);
        while(n != 1) {
            if(n%2 == 0) {
                n /= 2;
            } else {
                n = 3*n+1;
            }
            result.add(n);
        }
        int[] answer = new int[result.size()];
        for(int i = 0 ; i < result.size() ; i ++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}