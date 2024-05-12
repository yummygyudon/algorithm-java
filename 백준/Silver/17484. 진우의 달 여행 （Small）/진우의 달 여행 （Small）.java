import java.util.*;
import java.io.*;
public class Main {
    
    static int[][] MAP;
    static int[][][] DP;

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] nAndM = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int N = nAndM[0]; int M = nAndM[1];
        DP = new int[N][M][3];
        MAP = new int[N][M];
        for (int i = 0; i < N; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
            for (int j = 0; j < M; j++) {
                MAP[i][j] = Integer.parseInt(tokenizer.nextToken());
                Arrays.fill(DP[i][j], Integer.MAX_VALUE);
            }
        }
        for (int i = 0; i < M; i++) { // 시작점 갱신
            DP[0][i][0] = MAP[0][i];
            DP[0][i][1] = MAP[0][i];
            DP[0][i][2] = MAP[0][i];
        }
        for (int i = 1; i < N; i++) {
            for (int k = 0; k < M; k++) {
                // 기존 {-1, 0, 1} 을 {0, 1, 2} 로 생각하기
                if (k == 0) { // 맨 왼쪽 열일 경우 - 이전 행의 위 & 오른쪽 위에서만 올 수 있음
                    // 지금의 0 (오른쪽 위열) : 이전 행에서 이전&전 행의 0으로부터 온 값은 쓸 수 없음
                    DP[i][k][0] = Math.min(DP[i - 1][k + 1][1], DP[i - 1][k + 1][2]) + MAP[i][k]; // 직전의 같은 방향 값 제외
                    // 지금의 1 (같은 열) : 이전 행에서 이전&전 행의 1으로부터 온 값을 쓸 수 없음
                    // ++ 맨 왼쪽이기 때문에 0방향에서 온 값이 있을 수 없음
                    DP[i][k][1] = DP[i - 1][k][0] + MAP[i][k];
                    continue;
                }
                if (k == M - 1) { // 맨 오른쪽 열일 경우
                    DP[i][k][2] = Math.min(DP[i-1][k-1][0], DP[i-1][k-1][1]) + MAP[i][k]; // 직전의 같은 방향 값 제외
                    DP[i][k][1] = DP[i - 1][k][2] + MAP[i][k];
                    continue;
                }
                DP[i][k][0] = Math.min(DP[i - 1][k + 1][1], DP[i - 1][k + 1][2]) + MAP[i][k];
                DP[i][k][1] = Math.min(DP[i - 1][k][0], DP[i - 1][k][2]) + MAP[i][k];
                DP[i][k][2] = Math.min(DP[i - 1][k - 1][0], DP[i - 1][k - 1][1]) + MAP[i][k];
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < M; i++) {
            for (int k = 0; k < 3; k++) {
                result = Math.min(DP[N - 1][i][k], result);
            }
        }
        System.out.println(result);
    }

}