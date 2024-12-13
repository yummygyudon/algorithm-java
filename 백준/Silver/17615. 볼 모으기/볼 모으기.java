import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int quantity = Integer.parseInt(reader.readLine());
        String[] balls = reader.readLine().split("");
        int redBallCount = 0, blueBallCount = 0;
        int ballCount = 0;
        boolean isRedNow = true;

        for (int i = 0; i < quantity; i++) {
            if (balls[i].equals("B")) {
                if (isRedNow) {
                    isRedNow = false;
                    redBallCount += ballCount;
                    ballCount = 0;
                }
                ballCount++;
            } else { 
                if (!isRedNow) {
                    isRedNow = true;
                    blueBallCount += ballCount;
                    ballCount = 0;
                }
                ballCount++;
            }
        }
        System.out.println(Math.min(redBallCount, blueBallCount));
    }

}
