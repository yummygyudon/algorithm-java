import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());

        int depth = 0;
        int existRoom = 1;
        while (true) {
            int rangeMax = (6 * depth) + existRoom;
            if (rangeMax >= N) {
                System.out.println(depth + 1);
                break;
            }
            existRoom = rangeMax;
            depth++;
        }

    }
}