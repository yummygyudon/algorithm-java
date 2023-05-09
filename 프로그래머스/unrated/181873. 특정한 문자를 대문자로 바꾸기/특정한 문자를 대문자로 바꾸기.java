class Solution {
    public String solution(String my_string, String alp) {
        StringBuilder answer = new StringBuilder();
        for (String s : my_string.split("")){
            if(s.equals(alp)) {
                s = alp.toUpperCase();
            }
            answer.append(s);
        }
        return answer.toString();
    }
}