class Solution {
    public String solution(String my_string, int n) {
        String result = "";
        String[] strings = my_string.split("");
        int pointer = strings.length-1;
        for (int i = 0 ; i < n ; i++){
            result = strings[pointer] + result;
            pointer--;
        }
        return result;
    }
}