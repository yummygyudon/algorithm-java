import java.util.*;

class Solution {
    static int[][] MAP;
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        MAP = new int[rows][columns];
        int value = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                MAP[i][j] = value;
                value++;
            }
        }
        int min_num_idx = 0;
        for (int[] query : queries) {
            int start_y = query[0] - 1, start_x = query[1] - 1;
            int end_y = query[2] - 1, end_x = query[3] - 1;
            int min = rotateAndGetMinimum(start_y, start_x, end_y, end_x);
            answer[min_num_idx] = min;
            min_num_idx++;
        }
        return answer;
    }
    
    private int rotateAndGetMinimum(int start_y, int start_x, int end_y, int end_x) {
        int width = end_x - start_x, height = end_y - start_y;
        int before_value = MAP[start_y][start_x];
        int[] pos = new int[2];
        pos[0] = start_y;
        pos[1] = start_x;
        
        int minimum = before_value;
        
        // right
        for (int w = 1; w <= width; w++) {
            int tmp = MAP[pos[0]][pos[1] + w];
            minimum = Math.min(minimum, tmp);

            MAP[pos[0]][pos[1] + w] = before_value;
            before_value = tmp;
        }
        pos[1] += width;
        
        // down
        for (int h = 1; h <= height; h++) {
            int tmp = MAP[pos[0] + h][pos[1]];
            minimum = Math.min(minimum, tmp);

            MAP[pos[0] + h][pos[1]] = before_value;
            before_value = tmp;
        }
        pos[0] += height;

        // left
        for (int w = 1; w <= width; w++) {
            int tmp = MAP[pos[0]][pos[1] - w];
            minimum = Math.min(minimum, tmp);

            MAP[pos[0]][pos[1] - w] = before_value;
            before_value = tmp;
        }
        pos[1] -= width;
        
        // up
        for (int h = 1; h <= height; h++) {
            int tmp = MAP[pos[0] - h][pos[1]];
            minimum = Math.min(minimum, tmp);

            MAP[pos[0] - h][pos[1]] = before_value;
            before_value = tmp;
        }
        return minimum;
    }
}