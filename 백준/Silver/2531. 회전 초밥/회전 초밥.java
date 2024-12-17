import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
        int N = Integer.parseInt(tokenizer.nextToken()),
                D = Integer.parseInt(tokenizer.nextToken()),
                K = Integer.parseInt(tokenizer.nextToken()), // 할인 최소 기준
                C = Integer.parseInt(tokenizer.nextToken());

        int[] foods = new int[N];
        for (int i = 0; i < N; i++) {
            foods[i] = Integer.parseInt(reader.readLine());
        }

        int[] eatCounts = new int[D + 1];
        int nowUniqueCnt = 0;
        // (주의) 무조건 서로 다른 연속적인 초밥을 먹을 필요는 없음!
        for (int i = 0; i < K; i++) { // "필수 만족 조건"으로 초기 윈도우 설정 (K개를 먹을 경우)
            if (eatCounts[foods[i]] == 0) { // 처음 먹는 종류일 경우
                nowUniqueCnt++;
            }
            eatCounts[foods[i]]++;
        }
        int maxUniqueCnt = nowUniqueCnt; // 초기 윈도우 기준

        for (int i = 0; i < N; i++) {
            int excludeFood = foods[i];
            eatCounts[excludeFood]--;
            if (eatCounts[excludeFood] == 0) {
                nowUniqueCnt--;
            }

            // 윈도우 조건을 유지해야 하기 때문에 반드시 추가해야함
            int addFood = foods[(i + K) % N]; // 현재 순서 ~ 필수 조건 개수
            if (eatCounts[addFood] == 0) {
                nowUniqueCnt++;
            }
            eatCounts[addFood]++;

            if (eatCounts[C] == 0) {
                maxUniqueCnt = Math.max(maxUniqueCnt, nowUniqueCnt + 1);
            } else {
                maxUniqueCnt = Math.max(maxUniqueCnt, nowUniqueCnt);
            } 
        }
        System.out.println(maxUniqueCnt);
    }
}
