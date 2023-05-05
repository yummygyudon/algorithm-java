class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = new int[num_list.length];
        int maxSize = num_list.length-1;
        for(int i = 0 ; i <= maxSize ; i ++ ){
            answer[i] = num_list[maxSize - i];
        }
        return answer;
    }
}