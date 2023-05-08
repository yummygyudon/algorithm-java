class Solution {
    public String solution(int[] numLog) {
        StringBuilder answer = new StringBuilder();
        for (int i = numLog.length-1; i > 0; i--) {
            answer.append(getCommand(numLog[i], numLog[i-1]));
        }
        return answer.reverse().toString();
        
    }
    String getCommand(int value, int before) {
        int diff = value-before;
        if(diff == 1) {
            return "w";
        }else if(diff == -1) {
            return "s";
        }else if(diff == 10) {
            return "d";
        } else {
            return "a";
        }
    }
}