class Solution {
    public int[] solution(int n, int k) {
        int[] answer = new int[n/k];
        int index = 0;
        for (int i = 1; i < n+1 ; i++){
            if(i % k == 0) {
                answer[index] = i;
                index ++ ;
            }
        }
        return answer;
    }
}