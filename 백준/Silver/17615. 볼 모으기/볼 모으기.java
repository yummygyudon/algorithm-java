import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int quantity = Integer.parseInt(reader.readLine());
        String[] balls = reader.readLine().split("");
        int redBallCountFromLeft = 0, redBallCountFromRight = 0;
        int blueBallCountFromLeft = 0, blueBallCountFromRight = 0;
        int minOfLeft = 0, minOfRight = 0;
        int ballCount = 0;
        boolean isRedNow = true;
        for (int i = 0; i < quantity; i++) {
            if (balls[i].equals("B")) {
                if (isRedNow) {
                    isRedNow = false;
                    redBallCountFromLeft += ballCount;
                    ballCount = 0;
                }
                ballCount++;
            } else { 
                if (!isRedNow) {
                    isRedNow = true;
                    blueBallCountFromLeft += ballCount;
                    ballCount = 0;
                }
                ballCount++;
            }
        }
        minOfLeft = Math.min(redBallCountFromLeft, blueBallCountFromLeft);
        
        ballCount = 0;
        isRedNow = true;
        for (int i = quantity-1; i >= 0; i--) {
            if (balls[i].equals("B")) { 
                if (isRedNow) {
                    isRedNow = false;
                    redBallCountFromRight += ballCount;
                    ballCount = 0;
                }
                ballCount++;
            } else { 
                if (!isRedNow) {
                    isRedNow = true;
                    blueBallCountFromRight += ballCount;
                    ballCount = 0;
                }
                ballCount++;
            }
        }
        minOfRight = Math.min(redBallCountFromRight, blueBallCountFromRight);

        System.out.println(Math.min(minOfLeft, minOfRight));
        
    }

}
