import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        // 메모리 초과
        // int[][] matrix = makeMatrix(n);
        // int[] arr = mergeMatrix(n, matrix);
        // int[] result = cutArray(left, right, arr);

        // [공식 1] 2차월 배열 => 3x3 에서 5 = 5 / 3 (1) & 5 % 3 (2) = 좌표 1,2 = 1행 2열
        // [공식 2] 좌표 별 값 채우기 => Math.max(행, 열)
        //      (1,1) = 1 / (1,2) = 2 / (1,3) = 3
        //      (2,1) = 2 / (2,2) = 2 / (2,3) = 3
        //      (3,1) = 3 / (3,2) = 3 / (3,3) = 3
        int idx = 0;
        int[] result = new int[(int)(right - left + 1)];
        for (long i = left; i <= right; i++) {
            int row = (int) (i / n);
            int column = (int) (i % n);
            result[idx] = Math.max(row, column) + 1;
            idx++;
        }
        return result;
    }
    
//     private int[][] makeMatrix(int n) {
//         int[][] matrix = new int[n][n];
//         int value = 1;
//         for (int i = 1; i <= n; i++) {
//             for (int k = 0; k < i; k++) {
//                 for (int j = 0; j < i; j++) {
//                     if (k==i-1 || j==i-1) {
//                         matrix[k][j] = i;    
//                     }
//                 }
//             }
//         }
//         return matrix;
//     }
//     private int[] mergeMatrix(int n, int[][] matrix) {
//         int[] arr = new int[n*n];
//         int idx = 0;
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < n; j++) {
//                 arr[idx] = matrix[i][j];
//                 idx++;
//             }
//         }
//         return arr;
//     }
//     private int[] cutArray(long left, long right, int[] arr) {
//         int size = (int)(right - left + 1);
//         long start = left;
//         int[] slice = new int[size];
        
//         for (int i = 0; i < size; i++) {
//             slice[i] = arr[(int)start];
//             start++;
//         }
//         return slice;
//     }
}