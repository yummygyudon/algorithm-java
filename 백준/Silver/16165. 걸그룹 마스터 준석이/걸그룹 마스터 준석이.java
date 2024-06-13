import java.util.*;
import java.io.*;

public class Main {

    static Map<String, List<String>> MAP;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
        int N = Integer.parseInt(tokenizer.nextToken()), M = Integer.parseInt(tokenizer.nextToken());
        MAP = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String team = reader.readLine();
            int memberCnt = Integer.parseInt(reader.readLine());
            List<String> members = new ArrayList<>(memberCnt);
            for (int k = 0; k < memberCnt; k++) {
                members.add(k,reader.readLine());
            }
            Collections.sort(members);
            MAP.putIfAbsent(team, members);
        }

        for (int i = 0; i < M; i++) {
            String value = reader.readLine();
            if (reader.readLine().equals("1")) {
                // 멤버이름 탐색 -> 팀 이름 출력
                for (String key : MAP.keySet()) {
                    List<String> members = MAP.get(key);
                    if (members.contains(value)) {
                        System.out.println(key);
                        continue;
                    }
                }
            } else {
                for (String key : MAP.keySet()) {
                    // 팀이름 탐색 -> 멤버 이름 출력
                    if (key.equals(value)) {
                        List<String> members = MAP.get(key);
                        members.forEach(System.out::println);
                    }
                }
            }
        }
    }
}