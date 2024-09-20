import java.io.*;
import java.util.*;

public class Main {

    static int[] EXIT_COMMAND = {0, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int[] inputs = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if (Arrays.equals(EXIT_COMMAND, inputs)) {
                break;
            }

            Arrays.sort(inputs);
            
            if (inputs[2] >= inputs[0] + inputs[1]) {
                System.out.println("Invalid");
            } else if (inputs[0] == inputs[1] && inputs[1] == inputs[2]) {
                System.out.println("Equilateral");
            } else if (inputs[0] == inputs[1] || inputs[1] == inputs[2]) {
                System.out.println("Isosceles");
            } else {
                System.out.println("Scalene");
            }
        }
    }
}