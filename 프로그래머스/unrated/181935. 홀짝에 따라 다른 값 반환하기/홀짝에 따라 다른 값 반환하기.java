class Solution {
    public int solution(int n) {
        if (n%2==1){
            return sumForOdd(n);
        }
        return sumForEven(n);
    }
    
    int sumForOdd(int n) {
        int result = 0;
        for(int i = 1; i < n+1; i ++) {
            if (i % 2 == 1) {
                result += i;
            }
        }
        return result;
    }
    int sumForEven(int n) {
        int result = 0;
        for(int i = 1; i < n+1; i ++) {
            if (i % 2 == 0) {
                result += (i*i);
            }
        }
        return result;
    }
}