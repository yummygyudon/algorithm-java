class Solution {
    /*
    1, 1, 1, 0
    1, 2, 2, 0
    1, 0, 0, 1
    0, 0, 0, 1
    0, 0, 0, 3
    0, 0, 0, 3
    
    dfs & check map & max 연산
    */
    static int[][] MOVING = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static boolean[][] CHECK_MAP;
    static int[][] MAP;
    static int NUM_AREA;
    static int MAX_AREA;
    static int CNT_AREA;
    static int H, W;
    
    public int[] solution(int m, int n, int[][] picture) {
        H = m;
        W = n;
        NUM_AREA = 0;
        MAX_AREA = 0;
        CNT_AREA = 0;
        
        CHECK_MAP = new boolean[m][n];
        MAP = picture;
        
        for (int i = 0; i < m; i++) {
            for (int k = 0; k < n; k++) {
                if (MAP[i][k] != 0 && !CHECK_MAP[i][k]) {
                    CNT_AREA = 0;
                    check(i, k, MAP[i][k]);
                    MAX_AREA = Math.max(MAX_AREA, CNT_AREA);
                    NUM_AREA++;
                }
            }
        }
        return new int[]{NUM_AREA, MAX_AREA};
    }
    private void check(int y, int x, int targetNum) {
        if (MAP[y][x] != targetNum) {
            return;
        }
        CHECK_MAP[y][x] = true;
        CNT_AREA++;
        for (int i = 0; i < 4; i++) {
            int next_y = y + MOVING[i][0], next_x = x + MOVING[i][1];
            if (0 <= next_y && next_y < H && 0 <= next_x && next_x < W && !CHECK_MAP[next_y][next_x]) {
                check(next_y, next_x, targetNum);
            }
        }
    }
}