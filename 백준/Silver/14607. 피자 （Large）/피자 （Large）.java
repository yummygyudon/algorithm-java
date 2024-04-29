import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(reader.readLine());
        System.out.println((N * (N - 1)) / 2);
    }
}