class Solution {
    public int solution(int a, int b) {
        if (a % 2 == 0) {
            if (b % 2 == 0) { // a, b 둘 다 짝수
                return Math.abs((a-b));
            } else { // a는 짝수, b는 홀수 
                return 2 * (a+b);
            }
        } else { 
            if (b % 2 == 0) { // a는 홀수 , b는 짝수
                return 2 * (a+b);
            } else { // a,b 둘 다 홀수
                return (a*a) + (b*b);
            }
        }
    }
}