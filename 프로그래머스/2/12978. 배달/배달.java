import java.util.Arrays;

class Solution {
    static int MAX = 2000 * 10000;
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[][] map = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            int[] arr = new int[N + 1];
            Arrays.fill(arr, MAX);
            arr[i] = 0;
            map[i] = arr;
        }

        for (int[] r : road) {
            map[r[0]][r[1]] = Math.min(map[r[0]][r[1]], r[2]);
            map[r[1]][r[0]] = Math.min(map[r[1]][r[0]], r[2]);
        }

        for (int middle = 1; middle <= N; middle++) {
            for (int start = 1; start <= N; start++) {
                for (int end = 1; end <= N; end++) {
                    map[start][end] = Math.min(map[start][end], map[start][middle] + map[middle][end]);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if (map[1][i] <= K) {
                answer++;
            }
        }
        return answer;
    }
}