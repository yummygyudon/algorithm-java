import java.io.*;

public class Main {

    static int[] HEART_POSITION = new int[2];
    static String[][] X_RAY;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        X_RAY = new String[N][N];

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String[] line = reader.readLine().split("");
            X_RAY[i] = line;
        }
        for (int i = 1; i < N - 1; i++) {
            for (int k = 1; k < N - 1; k++) {
                if (X_RAY[i - 1][k].equals("*") &&
                    X_RAY[i][k+1].equals("*") &&
                    X_RAY[i][k-1].equals("*") &&
                    X_RAY[i + 1][k].equals("*")
                ) {
                    HEART_POSITION[0] = i;
                    builder.append(i+1).append(" ");
                    HEART_POSITION[1] = k;
                    builder.append(k+1).append("\n");
                    break;
                }
            }
        }

        int middle = 0;
        // Left Arm
        for (int i = 0; i < HEART_POSITION[1]; i++) {
            if (X_RAY[HEART_POSITION[0]][i].equals("*")) {
                builder.append(HEART_POSITION[1] - i).append(" ");
                break;
            }
        }
        // Right Arm
        for (int i = N-1; i > HEART_POSITION[1]; i--) {
            if (X_RAY[HEART_POSITION[0]][i].equals("*")) {
                builder.append(i - HEART_POSITION[1]).append(" ");
                break;
            }
        }
        // Middle
        for (int i = HEART_POSITION[0]; i < N; i++) {
            if (X_RAY[i + 1][HEART_POSITION[1]].equals("_")) {
                middle = i - HEART_POSITION[0];
                builder.append(middle).append(" ");
                break;
            }
        }
        // Left Leg
        for (int i = HEART_POSITION[0] + middle + 1; i < N; i++) {
            if (i+1 == N ||
                    X_RAY[i+1][HEART_POSITION[1]-1].equals("_")) {
                builder.append(i - (HEART_POSITION[0] + middle)).append(" ");
                break;
            }
        }
        // Right Leg
        for (int i = HEART_POSITION[0] + middle + 1; i < N; i++) {
            if (i+1 == N ||
                    X_RAY[i+1][HEART_POSITION[1]+1].equals("_")) {
                builder.append(i - (HEART_POSITION[0] + middle));
                break;
            }
        }
        System.out.println(builder);
    }

}