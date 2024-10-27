import java.util.*;
import java.io.*;

public class Main {
    static final Set<String> keywords = new HashSet<>();
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
        int N = Integer.parseInt(tokenizer.nextToken()), M = Integer.parseInt(tokenizer.nextToken());

        for (int i = 0; i < N; i++) {
            keywords.add(reader.readLine().trim());
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < M; i++) {
            tokenizer = new StringTokenizer(reader.readLine(), ",");
            while (tokenizer.hasMoreTokens()) {
                keywords.remove(tokenizer.nextToken().trim());
            }
            result.append(keywords.size()).append("\n");
        }
        System.out.println(result);
    }


}