class Solution {
    public String solution(String my_string, String letter) {
        StringBuilder sb = new StringBuilder();
        for(String s : my_string.split("")) {
            if (s.equals(letter)) {
                continue ;
            }
            sb.append(s);
        }
        return sb.toString();
    }
}