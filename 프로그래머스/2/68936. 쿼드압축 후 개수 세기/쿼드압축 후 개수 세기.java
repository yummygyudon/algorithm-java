import java.util.*;

class Solution {
    static int[] ANSWER = new int[]{0, 0};
    
    public int[] solution(int[][] arr) {
        compress(arr);
        return ANSWER;
    }

    private void compress(int[][] arr) {
        if (isAlreadyCompressed(arr)) {
            if (arr[0][0] == 0) {
                ANSWER[0] += 1;
            } else {
                ANSWER[1] += 1;
            }
            return;
        }
        List<int[][]> compressArrays = new ArrayList<>();
        for (int y = 0; y < arr.length; y+=arr.length/2) {
            for (int x = 0; x < arr.length; x += arr.length / 2) {
                compressArrays.add(separateArray(y, x, arr));
            }
        }
        for (int[][] array : compressArrays) {
            if (array.length == 1) {
                if (array[0][0] == 0) {
                    ANSWER[0] += 1;
                } else {
                    ANSWER[1] += 1;
                }
            } else {
                compress(array);
            }
        }
    }

    private boolean isAlreadyCompressed(int[][] arr) {
        int start = arr[0][0]; // 시작 기준값
        for (int y = 0; y < arr.length; y++) {
            for (int x = 0; x < arr.length; x++) {
                if (start != arr[y][x]) { // 서로 하나라도 다르면 불가능
                    return false;
                }
            }
        }
        return true;
    }

    private int[][] separateArray(int startY, int startX, int[][] originArray) {
        int[][] nextArr = new int[originArray.length/2][originArray.length/2];
        for (int y = 0; y < originArray.length/2; y++) {
            for (int x = 0; x < originArray.length/2; x++) {
                nextArr[y][x] = originArray[startY + y][startX + x];
            }
        }
        return nextArr;
    }
}