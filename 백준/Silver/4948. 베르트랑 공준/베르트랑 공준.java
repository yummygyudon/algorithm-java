import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            int num = Integer.parseInt(reader.readLine());
            if (num == 0) {
                break;
            }
            int cnt = 0;
            for (int i = num+1; i <= num * 2; i++) {
                if (!isPrime(i)) {
                    continue;
                }
                cnt++;
            }
            System.out.println(cnt);
        }
    }

    private static boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}