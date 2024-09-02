import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
        long result = 0;
        while (tokenizer.hasMoreTokens()) {
            result += Long.parseLong(tokenizer.nextToken());
        }
        System.out.println(result);
    }

}