class Solution {
    public int solution(int n, String control) {
        int answer = n;
        for(String command : control.split("")){
            answer += convertToMoving(command);
        }
        return answer;
    }
    int convertToMoving(String command) {
        switch(command) {
            case "w" :
                return 1;
            case "s" :
                return -1;
            case "d" :
                return 10;
            case "a" :
                return -10;
            default :
                return 0;
        }
    }
}