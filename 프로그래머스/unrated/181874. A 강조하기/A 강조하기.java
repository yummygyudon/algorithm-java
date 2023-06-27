class Solution {
    public String solution(String myString) {
        String answer = "";
        
        for (char alp : myString.toCharArray()){
            if(!(alp == 'a' || alp == 'A')) {
                if(Character.isUpperCase(alp)){
                    answer += Character.toLowerCase(alp);
                } else {
                    answer += alp;
                }
            } else {
                if(Character.isLowerCase(alp)) {
                    answer += "A";
                } else {
                    answer += alp;
                }
            }
        }
        return answer;
    }
}