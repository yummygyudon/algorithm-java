class Solution {
    public int solution(int a, int b) {
        String convertToString = String.valueOf(a) + String.valueOf(b) ;
        int convertToInt = Integer.valueOf(convertToString) ;
        return convertToInt >= (2*a*b) ? convertToInt : 2*a*b;
    }
}