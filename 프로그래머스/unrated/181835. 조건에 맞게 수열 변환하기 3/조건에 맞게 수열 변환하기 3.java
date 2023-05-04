class Solution {
    public int[] solution(int[] arr, int k) {
        boolean isOdd = (k%2==1);
        for(int i = 0; i < arr.length ; i++) {
            arr[i] = isOdd ? arr[i]*k : arr[i]+k;
        }
        return arr;
    }
}