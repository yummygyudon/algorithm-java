import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        long result_total = Long.parseLong(reader.readLine());
        int ea = Integer.parseInt(reader.readLine());
        long history_total = 0l;
        StringTokenizer tokenizer;
        for (int i = 0; i < ea; i++) {
            tokenizer = new StringTokenizer(reader.readLine(), " ");
            long  price = Integer.parseInt(tokenizer.nextToken()), quantity = Integer.parseInt(tokenizer.nextToken());
            history_total += (price * quantity);
        }
        if (result_total == history_total) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

}