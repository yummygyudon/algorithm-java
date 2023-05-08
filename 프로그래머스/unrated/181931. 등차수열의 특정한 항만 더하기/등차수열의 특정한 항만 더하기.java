class Solution {
    public int solution(int a, int d, boolean[] included) {
        int answer = 0;
        for (boolean haveToAdd : included) {
            if(haveToAdd) {
                answer += a;
            }
            a += d;
        }
        return answer;
    }
}