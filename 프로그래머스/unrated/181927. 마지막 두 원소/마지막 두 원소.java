class Solution {
    public int[] solution(int[] num_list) {
        int arrSize = num_list.length ;
        int[] answer = new int[arrSize+1];
        for (int i = 0 ; i < arrSize; i++) {
            answer[i] = num_list[i] ;
        }
        answer[arrSize] = answer[arrSize-1] > answer[arrSize-2] 
            ? answer[arrSize-1] - answer[arrSize-2]
            : answer[arrSize-1] * 2 ;
        return answer;
    }
}