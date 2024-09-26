import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args)  throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(reader.readLine());
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < TC; i++) {
            String[] inputs = reader.readLine().split(" ");
            execute(builder, inputs);
        }
        System.out.println(builder);
    }
    static void execute(StringBuilder builder, String[] inputs) {
        builder.append(inputs[0]).append(" ");
        int[] nums = Arrays.stream(Arrays.copyOfRange(inputs, 1, 21))
                .mapToInt(Integer::parseInt).toArray();
        int result = 0;
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[i]) {
                    result++;
                }
            }
        }
        builder.append(result).append("\n");
    }
}