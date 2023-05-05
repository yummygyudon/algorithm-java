class Solution {
    public int[] solution(String[] strlist) {
        int[] answer = new int[strlist.length];
        int index = 0 ;
        for (String word : strlist) {
            answer[index] = word.toCharArray().length;
            index++;
        }
        return answer;
    }
}