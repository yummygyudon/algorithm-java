import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
        int H = Integer.parseInt(tokenizer.nextToken());
        int W = Integer.parseInt(tokenizer.nextToken());
        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());

        int heightQuot = H / (N+1);
        int heightMod = H % (N+1);
        if (heightMod > 0) {
            heightQuot++;
        }

        int widthQuot = W / (M+1);
        int widthMod = W % (M+1);
        if (widthMod > 0) {
            widthQuot++;
        }
        System.out.println(heightQuot * widthQuot);

    }

}