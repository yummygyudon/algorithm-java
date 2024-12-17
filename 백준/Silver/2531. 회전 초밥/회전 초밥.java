import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
        
        int N = Integer.parseInt(tokenizer.nextToken()); // 초밥의 개수
        int D = Integer.parseInt(tokenizer.nextToken()); // 초밥의 가짓수
        int K = Integer.parseInt(tokenizer.nextToken()); // 연속해서 먹는 초밥의 개수
        int C = Integer.parseInt(tokenizer.nextToken()); // 쿠폰으로 먹을 수 있는 초밥

        int[] sushi = new int[N];
        for (int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(reader.readLine());
        }

        // 슬라이딩 윈도우 준비
        int[] count = new int[D + 1]; // 초밥 종류별 개수를 저장
        int currentVariety = 0;       // 현재 윈도우의 초밥 종류 개수
        
        // 초기 윈도우 설정 (0 ~ K-1)
        for (int i = 0; i < K; i++) {
            if (count[sushi[i]] == 0) currentVariety++;
            count[sushi[i]]++;
        }
        
        int maxVariety = currentVariety;
        
        // 슬라이딩 윈도우 실행
        for (int i = 0; i < N; i++) {
            // 윈도우에서 초밥 하나 제거
            int removeSushi = sushi[i];
            count[removeSushi]--;
            if (count[removeSushi] == 0) currentVariety--;

            // 윈도우에 초밥 하나 추가 (회전 형태를 위해 인덱스를 N으로 나눈다)
            int addSushi = sushi[(i + K) % N];
            if (count[addSushi] == 0) currentVariety++;
            count[addSushi]++;

            // 보너스 초밥 포함 여부 체크
            if (count[C] == 0) {
                maxVariety = Math.max(maxVariety, currentVariety + 1);
            } else {
                maxVariety = Math.max(maxVariety, currentVariety);
            }
        }
        
        System.out.println(maxVariety);
    }
}
