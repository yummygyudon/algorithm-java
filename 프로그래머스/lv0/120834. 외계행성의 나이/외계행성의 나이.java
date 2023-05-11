class Solution {
    public String solution(int age) {
        int base = 97;
        StringBuilder answer = new StringBuilder();
        String ageString = String.valueOf(age);
        for(String num : ageString.split("")) {
            int n = Integer.valueOf(num);
            answer.append((char)(base+n));
        }
        
        
        return answer.toString();
    }
}