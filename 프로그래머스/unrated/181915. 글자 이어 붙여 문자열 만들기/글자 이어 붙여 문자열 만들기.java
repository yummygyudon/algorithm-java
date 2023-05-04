class Solution {
    public String solution(String my_string, int[] index_list) {
        String[] strings = my_string.split("");
        String answer = "";
        for (int index : index_list) {
            answer += strings[index] ;
        }
        return answer;
    }
}