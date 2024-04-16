import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int[] counts = new int[20000001];
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
		
		for(int i = 0 ; i < N; i++) {
			counts[Integer.parseInt(st.nextToken()) + 10000000]++;	// 해당 인덱스의 값 증가
		}
		
		int M = Integer.parseInt(reader.readLine());
		
		st = new StringTokenizer(reader.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < M; i++) {
			sb.append(counts[Integer.parseInt(st.nextToken()) + 10000000]).append(' ');
		}
		System.out.println(sb);
    }
}