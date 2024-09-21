import java.io.*;
import java.util.*;

public class Main {

    static Set<Integer> SET = new HashSet<>();
    static final Set<Integer> INIT_SET = new HashSet<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20));
    static StringBuilder RESULT = new StringBuilder();
    
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int commandCnt = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer;
        
        for (int i = 0; i < commandCnt; i++) {
            tokenizer = new StringTokenizer(reader.readLine(), " ");
            String command = tokenizer.nextToken();

            if (command.equals("all")) {
                SET = new HashSet<>(INIT_SET);
            } else if (command.equals("empty")) {
                SET.clear();
            } else {
                int value = Integer.parseInt(tokenizer.nextToken());
                switch (command) {
                    case "add":
                        SET.add(value);
                        break;
                    case "remove":
                        SET.remove(value);
                        break;
                    case "check":
                        RESULT.append(SET.contains(value) ? "1\n" : "0\n");
                        break;
                    case "toggle":
                        if (SET.contains(value)) {
                            SET.remove(value);
                        } else {
                            SET.add(value);
                        }
                        break;
                }
            }
        }
        System.out.println(RESULT);
    }

}