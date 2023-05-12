class Solution {
    public boolean solution(boolean x1, boolean x2, boolean x3, boolean x4) {
        boolean oneAndTwo = (x1 || x2) ? true : false ;
        boolean threeAndFour = (x3 || x4) ? true : false ;
        return oneAndTwo && threeAndFour ;
    }
}