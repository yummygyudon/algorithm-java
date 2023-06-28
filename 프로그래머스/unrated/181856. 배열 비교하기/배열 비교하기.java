import java.util.Arrays;
class Solution {
    public int solution(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            return arr1.length > arr2.length ? 1 : -1 ;
        }
        int arr1Total = 0;
        int arr2Total = 0;
        for (int value : arr1){
            arr1Total = arr1Total+value;
        }
        for (int value : arr2){
            arr2Total = arr2Total+value;
        }
        if (arr1Total == arr2Total) {
            return 0;
        }
        return arr1Total > arr2Total ? 1 : -1;
    }
}