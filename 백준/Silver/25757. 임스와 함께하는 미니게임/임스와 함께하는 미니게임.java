import java.io.*;
import java.util.*;

public class Main {

    static Map<String, Integer> PLAYER_LIMIT =  Map.of(
            "Y", 2, "F", 3, "O", 4
    );

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
        int requestCount = Integer.parseInt(tokenizer.nextToken());
        String selectedGame = tokenizer.nextToken();

        int playerLimit = PLAYER_LIMIT.get(selectedGame);
        Set<String> requestPlayers = new HashSet<>();
        for (int i = 0; i < requestCount; i++) {
            requestPlayers.add(reader.readLine());
        }
        System.out.println(requestPlayers.size()/(playerLimit-1));
    }
}