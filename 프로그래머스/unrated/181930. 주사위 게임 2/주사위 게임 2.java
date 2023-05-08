class Solution {
    public int solution(int a, int b, int c) {
        int answer = 0;
        if (isAllEqual(a,b,c)) {
            return (a+b+c) 
                * (int)(Math.pow(a,2) + Math.pow(b,2) + Math.pow(c,2))
                * (int)(Math.pow(a,3) + Math.pow(b,3) + Math.pow(c,3)) ;
        } else if (isOneEqual(a, b, c)) {
            return (a+b+c) 
                * (int)(Math.pow(a,2) + Math.pow(b,2) + Math.pow(c,2));
        }
        return a+b+c;
    }
    boolean isAllEqual(int a, int b, int c) {
        return a==b && a==c ;
    }
    boolean isOneEqual(int a, int b, int c) {
        if(a == b) {
            if (a != c || b != c) {
                return true ;
            }
        } else if (a == c) {
            if (a != b || c != b) {
                return true ;
            }
        } else if(b==c) {
            if (a != b || a!= c) {
                return true ;
            }
        }
        return false ;
    }
}