class Solution {
    public int solution(int a, int b) {
        Integer caseA = Integer.valueOf(String.valueOf(a) + String.valueOf(b)) ;
        Integer caseB = Integer.valueOf(String.valueOf(b) + String.valueOf(a)) ;
        if(caseA >= caseB) {
            return (int) caseA;
        }
        return (int) caseB;
    }
}