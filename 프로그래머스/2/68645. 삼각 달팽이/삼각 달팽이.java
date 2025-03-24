class Solution {
    static int[][] MOVEMENTS = {
            {1, 0}, // step%3 == 0
            {0, 1}, // step%3 == 1
            {-1, -1} // step%3 == 2
    };
    public int[] solution(int n) {
        int[] answer = new int[factorial(n)];
        int[][] nodes = new int[n][n];
        
        int y = -1, x = 0, movementIdx = 0; 
        int value = 1;

        for (int step = n; step >= 1; step--) {
            int[] movement = MOVEMENTS[movementIdx % 3];
            for (int i = 0; i < step; i++) {
                y += movement[0];
                x += movement[1];
                nodes[y][x] = value;
                value++;
            }
            movementIdx++;
        }
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int k = 0; k <= i; k++) {
                answer[idx] = nodes[i][k];
                idx++;
            }
        }
        return answer;
    }
    
    private int factorial(int x) {
        if (x == 1) {
            return x;
        }
        return x + factorial(x - 1);
    }
}