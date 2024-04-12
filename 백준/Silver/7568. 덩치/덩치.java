import java.io.*;

public class Main {
public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int time = Integer.parseInt(reader.readLine());
    int[][] people = new int[time][2];
    for (int i = 0; i < time; i++) {
        int[] input = new int[2];
        String[] s = reader.readLine().split(" ");
        input[0] = Integer.parseInt(s[0]);
        input[1] = Integer.parseInt(s[1]);
        people[i] = input;
    }
    for (int j = 0; j < time; j++) {
        int rank = 1;
        for (int k = 0; k < time; k++) {
            if ((people[j][0] < people[k][0]) && (people[j][1] < people[k][1])) {
                rank++;
            }
        }
        System.out.println(rank);
    }
}
}
