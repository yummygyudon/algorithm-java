class Solution {
    public long solution(int w, int h) {
        long W = w, H = h; 
        
        long gcd = getGCD(w, h);
        if (W == H) {
            return W * H - gcd;
        }
        return (W * H) - (W + H - gcd);
    }
    private long getGCD(long numA, long numB) {
        long a = numA, b = numB;
        long mod = Long.MAX_VALUE;
        while (mod != 0) {
            mod = a % b;
            a = b;
            b = mod;
        }
        return a;
    }
}