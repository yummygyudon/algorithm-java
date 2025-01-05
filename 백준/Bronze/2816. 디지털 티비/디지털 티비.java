import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        String[] channels = new String[N];
        int oneIdx = 0, twoIdx = 0;
        for (int i = 0; i < N; i++) {
            channels[i] = reader.readLine();
            if (channels[i].equals("KBS1")) {
                oneIdx = i;
                continue;
            }
            if (channels[i].equals("KBS2")) {
                twoIdx = i;
            }
        }

        int pointer = 0;
        if (oneIdx > twoIdx) {
            twoIdx++;
        }
        StringBuilder result = new StringBuilder();
        int distanceCurrentFromPointer = oneIdx - pointer;
        int distanceCurrentFromPosition = oneIdx;
        result.append("1".repeat(distanceCurrentFromPointer));
        result.append("4".repeat(distanceCurrentFromPosition));

        distanceCurrentFromPointer = twoIdx - pointer;
        distanceCurrentFromPosition = twoIdx - 1;
        result.append("1".repeat(distanceCurrentFromPointer));
        result.append("4".repeat(distanceCurrentFromPosition));
        System.out.println(result);
    }
}
