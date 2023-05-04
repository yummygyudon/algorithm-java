class Solution {
    public int[] solution(int[] arr, int n) {
        boolean isSizeOdd = (arr.length % 2 == 1) ;
        if (isSizeOdd) {
            for (int i = 0; i < arr.length ; i ++ ) {
                if(i%2 == 0) {
                    arr[i] = arr[i] + n ;
                }
            }
        } else {
            for (int i = 0; i < arr.length ; i ++ ) {
                if(i%2 == 1) {
                    arr[i] = arr[i] + n ;
                }
            }
        }
        return arr;
    }
}