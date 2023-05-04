class Solution {
    public int[] solution(int start, int end) {
        int answerSize = start-end+1 ;
        int[] answer = new int[answerSize];
        for(int i = 0; i < answerSize; i++){
            answer[i] = start;
            start--;
        }
        return answer;
    }
}