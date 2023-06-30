class Solution {
    public String solution(String n_str) {
        String[] splitStr = n_str.split("");
        String answer = "";
        boolean isZeroOver = false ;
        for(String s : splitStr) {
            if (s.equals("0") && !isZeroOver) {
                continue;
            }
            else if(s != "0" && isZeroOver == false) {
                isZeroOver = true;
                answer += s;
            } else if (s!="0" && isZeroOver) {
                answer += s;
            }
        }
        
        return answer;
    }
}