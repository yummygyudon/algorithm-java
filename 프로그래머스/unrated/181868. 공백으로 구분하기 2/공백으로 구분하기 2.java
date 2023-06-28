class Solution {
    public String[] solution(String my_string) {
        my_string = my_string.trim();
        String[] answer = my_string.split("[^A-z]+");
        
        return answer;
    }
}