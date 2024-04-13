import java.io.* ;
import java.util.* ;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int time = Integer.parseInt(reader.readLine());
        int[] stack = new int[time];
        int idx = 0;
        for (int i = 0; i < time; i++) {
            int value = Integer.parseInt(reader.readLine());
            if (value == 0) {
                stack[idx - 1] = 0;
                idx--;
                continue;
            }
            stack[idx] = value;
            idx++;
        }
        System.out.println(Arrays.stream(stack).sum());
    }
}
