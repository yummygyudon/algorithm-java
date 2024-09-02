import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numQuantity = Integer.parseInt(reader.readLine());
        int[] arr = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int targetNum = Integer.parseInt(reader.readLine());
        int result = 0;
        for (int num : arr) {
            if (num == targetNum) {
                result++;
            }
        }
        System.out.println(result);
    }
}